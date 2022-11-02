package gui;
import modelo.Despachador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Container panel;
    public JTextField entrada;
    public JTextArea salida;
    public JTextArea usuarios;
    public Despachador despachador;

    public Ventana() {
        super("Ventana Principal");
        panel = getContentPane();
        panel.setLayout(new FlowLayout());
        setSize(500,400);
        panel.add(new JLabel("Mensaje"));
        entrada = new JTextField(20);
        entrada.setSize(300,50);
        panel.add(entrada);
        JButton btnEnviar = new JButton("Enviar");
        panel.add(btnEnviar);
        salida = new JTextArea(20,30);
        salida.setEditable(false);panel.add(salida);
        usuarios = new JTextArea(20,10);
        usuarios.setEditable(false);panel.add(usuarios);

        btnEnviar.addActionListener(actionEvent -> {
            despachador.send();
        });
    }


}