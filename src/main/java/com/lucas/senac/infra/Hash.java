package com.lucas.senac.estacionando3.utils;

import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class Hash {

    public static final String IV = "estacionando9631";
    public static final String chaveencriptacao = "6l6u4k2a4s9d1c8a";

    public void teste(String texto){
        try {
            System.out.println("Texto Puro: " + texto);
            String s = encrypt(texto);
            System.out.println("Texto Encriptado: "+ s);
            String textodecriptado = decrypt(s);
            System.out.println("Texto Decriptado: " + textodecriptado);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public String encrypt(String textopuro) {
        try {
            Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
            encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            byte[] bytes = encripta.doFinal(textopuro.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }

    public String decrypt(String textoencriptado){
        try {
            byte[] bytes = Base64.getDecoder().decode(textoencriptado);
            Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
            decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            return new String(decripta.doFinal(bytes),"UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }
}
