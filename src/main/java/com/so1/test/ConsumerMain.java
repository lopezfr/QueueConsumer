/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so1.test;

/**
 *
 * @author mmendez
 */
public class ConsumerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestConsumerThread thread01 = new TestConsumerThread("Thread 01", 500);
        TestConsumerThread thread02 = new TestConsumerThread("Thread 02", 500);
        TestConsumerThread thread03 = new TestConsumerThread("Thread 03", 500);
        TestConsumerThread thread04 = new TestConsumerThread("Thread 04", 500);
        TestConsumerThread thread05 = new TestConsumerThread("Thread 05", 500);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }

}
