package com.exampleGUI;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;

public class SimpleServerTest {
    public static final String ENDERECO = "localhost";
    public static final int PORTA = 3334;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(PORTA);
            System.out.println("Servidor iniciado na porta " + PORTA);

            Socket cliente = servidor.accept();

            System.out.println("Cliente de IP: " +
            cliente.getInetAddress().getHostAddress() + 
            " conectado ao servidor");

            Scanner entrada = new Scanner(cliente.getInputStream());
            System.out.println("Mensagens do Cliente: ");

            while(entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }

            System.out.println("Servidor finalizado!");
            entrada.close();
            servidor.close();
        } catch (IOException ex) {
            System.out.println("Erro ao criar o servidor!");
        }
    }
}
