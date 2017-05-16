/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Diego
 */
public class NewPanel extends JPanel implements ActionListener,MouseListener{

    private Timer timer;
    private int x;
    private int secuencia;

    public NewPanel() {
   
        this.timer = new Timer(25,this);
        this.timer.start();
        this.x=0;
        this.secuencia=0;
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Image ahorcado = loadImage("ahorcado.png");
        Image abecedario = loadImage("abecedario-minusculas.jpg");
        g.drawImage(ahorcado, 25, 25, 25+136, 25+205,(this.secuencia*136),0,(this.secuencia*136)+136,204,this);
        g.drawImage(abecedario, 300, 50, this);
        g.setColor(Color.red);
        g.fillRect(x, 75, 25, 50);
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
        x=x+2;
        if(this.secuencia==6){
            this.secuencia=0;
        }else{
        this.secuencia++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
