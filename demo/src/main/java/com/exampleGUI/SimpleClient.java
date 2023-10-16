package com.exampleGUI;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class SimpleClient {

    public static Socket iniciaCliente() throws IOException {
        // 10.33.126.151
        Socket cliente = new Socket(SimpleServerTest.ENDERECO, SimpleServerTest.PORTA);
        System.out.println("Cliente: " +
        SimpleServerTest.ENDERECO + ":" +
        SimpleServerTest.PORTA + " conectado ao servidor!");
        return cliente;
    }

    public static void enviaMensagem(String msg, Socket cliente) throws IOException {
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(msg);
    }
}
