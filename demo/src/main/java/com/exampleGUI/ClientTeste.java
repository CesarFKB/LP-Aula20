package com.exampleGUI;

import java.io.IOException;
import java.net.Socket;

public class ClientTeste {
    public static void main(String[] args) {
        Socket cliente;
        try {
            cliente = SimpleClient.iniciaCliente();
            TelaClient tc = new TelaClient(cliente);
            tc.setStatus("Status: CONECTADO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
