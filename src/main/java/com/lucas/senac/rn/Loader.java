package com.lucas.senac.rn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

public class Loader {

    public static void main(String[] args) throws IOException {

        String host = "http://0.0.0.0:";

        final String baseUri = host + (System.getenv("PORT") != null ? System.getenv("PORT") : "9998") + "/";
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.property.packages", "com.lucas.senac.rn");

        System.out.println("Iniciando grizzly...");
        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
        System.out.println(String.format("Webservice disponivel em: %sapplication.wadl.", baseUri, baseUri));
    }
}
