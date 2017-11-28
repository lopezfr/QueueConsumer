package com.so1.servicio;

import com.google.gson.Gson;
import com.so1.bean.Transaccion;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 * Created by carloscubur on 24/11/17.
 */
public class EnvioPost {

    public void envPost(String json){
    // enviar objeto transaccion.... a docker en el puerto 8080
    Transaccion response = new Transaccion();

    try {
        Client client;
        client = Client.create();
        client.setConnectTimeout(10000);
        client.setReadTimeout(60000);

        //Envia un POST para distribuir
        WebResource service = client
                .resource("http://192.168.10.3:8080/SpringRestHibernateExample/distTrx");

        Transaccion request = new Transaccion();
        Gson gson = new Gson();
        request=gson.fromJson(json, Transaccion.class);
        System.out.println("String convertido a JSON " + json);
        System.out.println("Objeto:");
        System.out.println("idTransaccion     "+ request.getIdTransaccion());
        System.out.println("idUsuario         "+ request.getIdUsuario());
        System.out.println("idCoin            "+ request.getIdCoin());
        System.out.println("idPlatformOrigin  "+ request.getIdPlatformOrigin());
        System.out.println("idPlatformDestiny "+ request.getIdPlatformDestiny());
        System.out.println("idProduct         "+ request.getIdProduct());
        System.out.println("Mount             "+ request.getMount());
        System.out.println("Quantity          "+ request.getQuantity());


        /*request.setId(1);
        request.setNombre("Manuel");
        request.setEdad(31);*/

        response = service
                .type(MediaType.APPLICATION_JSON)
                .post(Transaccion.class, request);

    }

    catch(
    Exception e
    )

    {
        e.printStackTrace();
    }

    if(response!=null)

    {
        System.out.println("id:" + response.getIdTransaccion());
    }
}
}
