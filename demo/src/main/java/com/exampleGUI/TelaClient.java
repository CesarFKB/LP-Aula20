package com.exampleGUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaClient extends JFrame implements ActionListener {
    
    private JButton bEnviar, bLimpar, bSair;
    private JTextField aTexto;
    private JLabel lStatus;
    public String mensagem = "";
    private Socket cliente;

    public TelaClient(Socket cliente) {
        super("Cliente");
        this.cliente = cliente;
        iniciarElementos();
        setMinimumSize(new Dimension(350, 200));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarElementos() {
        
        /* Definindo botoes */
        bEnviar = new JButton("Enviar");
        bLimpar = new JButton("Limpar");
        bSair = new JButton("Sair");

        bEnviar.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);

        /* Definindo label e textField */
        aTexto = new JTextField(10);
        lStatus = new JLabel("Status: Aguardando conexao...");
        lStatus.setHorizontalAlignment(JLabel.CENTER);

        definirLayout();
    }

    private void definirLayout() {
        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());
        caixa.add(aTexto);
        caixa.add(lStatus);
        caixa.add(bEnviar);
        caixa.add(bLimpar);
        caixa.add(bSair);
    }

    public void setStatus(String s) {
        lStatus.setText(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSair) {
            System.exit(0);
        } else if (e.getSource() == bLimpar) {
            aTexto.setText("");
        } else if (e.getSource() == bEnviar) {
            mensagem = aTexto.getText();
            try {
                SimpleClient.enviaMensagem(mensagem, cliente);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            aTexto.setText("");
        }
    }
    
}
