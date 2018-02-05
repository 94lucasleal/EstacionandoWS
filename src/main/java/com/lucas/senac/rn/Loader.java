package com.lucas.senac.rn;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceFeature;

public class Loader {

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {
        String port = System.getenv("PORT");
        if (port == null) port = "9998";
        //URI BASE_URI = UriBuilder.fromUri("https://0.0.0.0/").port(Integer.parseInt(port)).build(); 
        
       // String port = "9998";
        String host = "http://0.0.0.0:";
        String uri = "/service";
        //SimpleService service = new SimpleService();
        //Endpoint.publish(host + port + uri,service);
        
        final String baseUri = "http://localhost:"+(System.getenv("PORT")!=null?System.getenv("PORT"):"9998")+"/";
        //final String baseUri = "http://0.0.0.0:"+port+"/";
        //final String baseUri = String.valueOf(BASE_URI);
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.property.packages","com.lucas.senac.rn");
        initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        
        System.out.println("Iniciando o grizzly...");
        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
        System.out.println(String.format("Serviço iniciado acesse: %sapplication.wadl.",baseUri, baseUri));
        
    }
}
