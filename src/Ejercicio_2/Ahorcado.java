/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_2;

import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class Ahorcado extends JFrame{

//   public static void main(String[] args) {
//    Letra letra1= new Letra();
//    letra1.Jugar(letra1);
    
//}
    
    public Ahorcado() {
        add(new NewPanel());
    }
    
    public static void main(String[] args) {
        Ahorcado frame = new Ahorcado();
        frame.setTitle("Ahorcado");
        frame.setSize(848,480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
