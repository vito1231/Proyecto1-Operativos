/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;

/**
 *
 * @author vicnb
 */
public class ProyectoOperativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controller cont= new Controller();
        cont.extractProcessesTXT("prueba.txt");
        for(Process p:cont.getProcesos()){
            System.out.println(p.toString());
        }
        
       
    }
    
    
}
