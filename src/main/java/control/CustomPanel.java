/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.PanelListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aaron
 */
public class CustomPanel extends JPanel{
    private String nombre;
    private String descripcion;
    private int id;
    private int index;
    private JButton button;
    private PanelListener listener;
    
    public CustomPanel(String nombre, String descripcion, String imagePath, int id, int index, String tipo, PanelListener listener) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.index = index;
        this.listener = listener;
        
        // Establecer el layout
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir márgenes
        
        // Crear panel derecho (nombre, descripción y botón)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        // Crear etiquetas
        JLabel nameLabel = new JLabel(nombre);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel descriptionLabel = new JLabel("<html><p style='width:200px;'>" + descripcion + "</p></html>"); 
        
        // Crear botón
        
        if(tipo.equals("boletos")) {
            button = new JButton();
            button.setText("Seleccionar Boleto");
        } else if(tipo.equals("eventos")) {
            button = new JButton();
            button.setText("Ver Boletos en Reventa");
        }
        
        // Añadir un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se presiona el botón, llamamos al método del listener y pasamos el ID
                if (listener != null) {
                    listener.onButtonClicked(id, index);  // Devolver el ID al listener
                }
            }
        });
        
        // Añadir nombre, descripción y botón al panel derecho
        rightPanel.add(nameLabel);
        rightPanel.add(descriptionLabel);
        rightPanel.add(button);
        
        // Cargar imagen
        ImageIcon imageIcon = new ImageIcon(imagePath); 
        JLabel imageLabel = new JLabel();
        if (imageIcon.getIconWidth() > 0) {
            imageLabel.setIcon(imageIcon);
        } else {
            // Si la imagen no está disponible, usar un espacio en blanco o una imagen por defecto
            imageLabel.setIcon(new ImageIcon(new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB)));
        }
        
        // Añadir imagen a la izquierda y panel derecho con información a la derecha
        add(imageLabel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
