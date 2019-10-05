/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vicnb
 */
public class ProyectoOperativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Controller cont= new Controller();
        cont.extractProcessesTXT("pruebaEDF.txt");
        //cont.createEDF(20);
        /*
        ArrayList<Process> n= new ArrayList<Process>();
        Process p1= new Process();
        p1.setName("p1");
        Process p2= new Process();
        p2.setName("p2");
        Process p3= new Process();
        p3.setName("p3");
        Process p4= new Process();
        p4.setName("p4");
        Process p5= new Process();
        p5.setName("p5");
        
        n.add(p1);
        n.add(p2);
        n.add(p3);
        n.add(p4);
        n.add(p5);
        ArrayList<Process> dummy=n;
        for(int i=0;i<n.size();i++){
            if(n.get(i).equals(p2)){
                n.remove(i);
            }
        }
        for(Process p:n){
            System.out.println(p.toString());
        }
        
        */
        //String s="";
        //s= s+"Hola";
        //System.out.println(s);
        /*
        ArrayList<String> s= new ArrayList<String>();
        s.add("\t hola");
        s.add("ha \t hola");
        Path file = Paths.get("outpuPUREA.txt");
        Files.write(file, s);
        */
        
        //-i pruebaEDF.txt -o outputEDFuno.txt -a EDF -t 20
        cont.Menu();
       
    }
    
    
}
