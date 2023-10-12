package com.example;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaClient extends JFrame implements ActionListener {
    
    private JButton bEnviar, bLimpar, bSair;
    private JTextField aTexto;
    private JLabel lStatus;

    public TelaClient() {
        super("Cliente");
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
        lStatus = new JLabel("Status: Esperando conexao...");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
