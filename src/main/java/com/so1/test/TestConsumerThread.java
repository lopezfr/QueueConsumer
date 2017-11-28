/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so1.test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.so1.servicio.EnvioPost;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

/**
 *
 * @author mmendez
 */
public class TestConsumerThread extends Thread {

    private String threadId;
    private long millis;

    public TestConsumerThread(String threadId, long millis) {
        this.threadId = threadId;
        this.millis = millis;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        String nombreCola = "PROYECTO.COLAMENSAJE";
        String nombreServicio = "EjemploCola_" + threadId;
        String serverLocation = "failover:(tcp://192.168.10.2:61616)?timeout=3000";
        //String serverLocation = "failover:(tcp://localhost:61616)?timeout=3000";

        try {

            //MessageConsumer consumer = QueueUtil.getMessageConsumer(serverLocation, nombreCola, nombreServicio);
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(serverLocation);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(nombreCola);

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);

            while (true) {
                try {

                    Message message = consumer.receive(1000);

                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        String text = textMessage.getText();
                        System.out.println("[" + threadId + "] JSON Extraido de colas: " + text);

                        EnvioPost envioPost = new EnvioPost();
                        envioPost.envPost(text);

                    } else {
                        System.out.println("[" + threadId + "]Received: " + message);
                    }

                    Thread.sleep(millis);

//                    Message message = consumer.receive(1000);
//                    procesarMensaje(message);
//                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void procesarMensaje(Message message) {

        if (message instanceof ActiveMQTextMessage) {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;

            try {
                System.out.println("[" + threadId + "] mensaje:" + msg.getText());

            } catch (Exception e) {
                System.out.println("[" + threadId + "]" + "Mensaje no puede ser leido ..");
            }

        } else {
            System.out.println("[" + threadId + "]" + "Se desconoce el formato de mensaje..." + message);
        }

    }

}
