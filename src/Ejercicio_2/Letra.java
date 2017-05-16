/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Letra {
    
    Random numeroAleatorio =new Random();
    int numeroPalabra = numeroAleatorio.nextInt(10);
    String[] palabra={"oscar","sebastian","florecitadelcampo","david","elprofegarcia","juanita","saravalentina","juliozorra","wardiola","buitrear"};
    char[] LetrasMalas=new char[7];
    int posicionLetraMala=0;
    int cantidadDeLetras=palabra[numeroPalabra].length();
    Boolean[] palabraActual=new Boolean[cantidadDeLetras];
    char[] muñeco={'q','(','x','_','x',')','p'};
    int aciertos=0;
    int ultimoAcierto;
    String letrasAcertadas="";
    
    public void asignacionDeFalse(){
        for(int i=0; i<palabra[numeroPalabra].length(); i++){
            palabraActual[i]=false;
        }
    }
    
    public String obtenerLetra(){
        String letraIngresada;
        Scanner lectura= new Scanner(System.in);
        letraIngresada=lectura.nextLine();
        letraIngresada= letraIngresada.toLowerCase();
        return letraIngresada;
    }
    
    public int buscarLetra(String palabraRevisada, String letraBuscada, int i){
        
        if(palabraRevisada.charAt(i)==letraBuscada.charAt(0)){
            ultimoAcierto=i;
            return i;      
        }
        return ultimoAcierto;
        
    }
    
    public int verificarLetra(String palabraObjetivo, int fallosRestantes){
        
     //Ingreso de la letra y validaciÃ³n
        String LetraEscogida;
        letrasAcertadas="";
        
        for(int i=0; i<palabraObjetivo.length();i++){
            if(palabraActual[i]){
                System.out.print(palabraObjetivo.charAt(i)+" ");
             
            }else{
                System.out.print("_ ");         
            }
            
        }
        
        System.out.print("\t");
        for(int i=0; i<7; i++){
            if(posicionLetraMala>i){
                System.out.print(muñeco[i]);
            }
        }
        System.out.print("\t");
        for(int i=0; i<7; i++){
            System.out.print(LetrasMalas[i]);         
        }
        
        System.out.println("\nIngrese una letra!");
        //aqui llamo el metodo para la lectura del teclado
        LetraEscogida=obtenerLetra();
        //aqui van los casos
        if(LetraEscogida.length()!=1){
            System.out.println("ERROR! Ingresa UNA sola letra");
        }else if(palabraObjetivo.indexOf(LetraEscogida)<0){
            System.out.println("Mala suerte esa no se encuentra dentro de la palabra");
            fallosRestantes--;
            LetrasMalas[posicionLetraMala]=LetraEscogida.charAt(0);
            posicionLetraMala++;
        }else{
            for(int i=palabraObjetivo.indexOf(LetraEscogida); i<cantidadDeLetras; i++){
                palabraActual[buscarLetra(palabraObjetivo, LetraEscogida,i)]=true;
            }      
             System.out.println("Acertaste!!!");
        }
        for(int i=0; i<palabraObjetivo.length();i++){
            if(palabraActual[i]){
                
               
               letrasAcertadas+=palabraObjetivo.charAt(i);
            }
            
        }
      //Aqui va cuantas oportunidades le quedan
        return fallosRestantes;
    }
    public void Jugar(Letra letra1){
    int oportunidades=7;
        
        letra1.asignacionDeFalse();
        Boolean win=false;
        //Consola
        System.out.println("||AHORCADO|| \n El juego para adivinar la palabra");
        // Iteracion para mostrar lo que va resolviendo de la palabra, el morraquito y el resultado de si acerto o no
        //luego la funcion devuelve verdadero si las oportunidades no llegan a cero, en el momento en que se cero se detiene la iteracion
        do{
           oportunidades=letra1.verificarLetra(letra1.palabra[letra1.numeroPalabra], oportunidades);
           if(letra1.letrasAcertadas.equals(letra1.palabra[letra1.numeroPalabra])){
               oportunidades=0;
               win=true;
               
           }
        }while(oportunidades>0);
        if(win){
            System.out.println(letra1.palabra[letra1.numeroPalabra]);
            System.out.println("Re pro Ganaste!!!");
        }else{
            System.out.println("q(x_x)p");
            System.out.println("Lo siento, has perdido");
        }     
    }


    
}
