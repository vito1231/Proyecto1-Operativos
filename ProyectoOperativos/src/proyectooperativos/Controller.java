/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vicnb
 */
public class Controller {
    private ArrayList<Process> procesos;
    private String outputfile;
    private int timeLineLen;
    
    public Controller() {
        procesos=new ArrayList<Process>();
    }
   
    
    public void Menu(){
        Boolean flag=true;
        while(flag){
        System.out.println("************************************************");
        System.out.println("");
        System.out.println("Menu");
        System.out.println("Opcion 1: Linea Comandos");
        System.out.println("Opcion 2: Interfaz Grafica");
         int selection;
        Scanner input = new Scanner(System.in);
        selection=input.nextInt();
        switch(selection){
            case 1:
                Boolean flag2=true;
                while(flag2){
                    System.out.println("For help -h or -?");
                    System.out.println("Exit -e");
                    input = new Scanner(System.in);
                    
                    String command= input.nextLine();
                    
                        String[] cParts= command.split(" ");
                        
                    
                          if(command.equals("-e")){
                            flag2 =false;
                        }  
                          else if(command.equals("-h")||command.equals("-?")){
                              help();
                          }
                          else{
                              extractProcessesTXT(cParts[1]);
                              for(Process a: procesos){
                                  System.out.println(a.toString());
                              }
                              this.outputfile=cParts[3];
                              System.out.println(this.outputfile);
                              this.timeLineLen=Integer.parseInt(cParts[7]);
                              System.out.println(this.timeLineLen);
                              if(cParts[5].equals("EDF")){
                                  System.out.println(cParts[5]);
                                  createEDF(timeLineLen);
                                  
                                  
                              }
                              else if (cParts[5].equals("Monotonic")){
                                  System.out.println(cParts[5]);
                                  createMonotonic();
                                  
                              }
                              else{
                                  System.out.println("EL COMANDO NO ESTA CORRECTO");
                              }
                          }
                          
                        
                    
                }
                flag=false;
                break;
            case 2:
                flag=false;
                break;
            default:
                System.out.println("NO EXISTE ESA OPCION");
        }
        }
    }
    
    public void help(){
        System.out.println("");
        System.out.println("******************************************************************************");
        System.out.println("HELP ?");
        System.out.println("");
        System.out.println("-i(input) <filename>.txt -o(output) "
                + "<filename>.txt -a(Algorithm) <EDF o Monotonic> -t(time) <int>"  );
    
        System.out.println("");
        System.out.println("******************************************************************************");
    }
    
    public ArrayList createEDF(int len){
        EDF edf= new EDF(len, procesos);
        edf.crearProcesos();
        edf.distribuirProcesos();
        ArrayList<Process> temp= edf.getProcesos();
        
        edf.apply();
        Process[] lineatiempo=edf.getProcessLine();
        for(int i=0;i<lineatiempo.length;i++){
            if(lineatiempo[i].equals(null)){
                //System.out.println("NULL");
            }
            else{
            //System.out.println(lineatiempo[i].toString());
            }
        }
        return null;
    }
    public ArrayList createMonotonic(){
        return null;
    }
            
    public void extractProcessesTXT(String filename){
        procesos=new ArrayList<Process>();
        Archive txt= new Archive(filename);
        ArrayList<String> sinProcesar= txt.readFile();
        int cont=0;
        for(String s: sinProcesar){
            Process proce=new Process();
            proce.setName("P"+Integer.toString(cont));
            String[] parts = s.split(" ");
            proce.setExTime(Integer.parseInt(parts[0]));
            proce.setPeriodo(Integer.parseInt(parts[2]));
            proce.setDeadline(Integer.parseInt(parts[2])-Integer.parseInt(parts[0]));
            procesos.add(proce);
            cont++;
        }
    }

    public ArrayList<Process> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Process> procesos) {
        this.procesos = procesos;
    }
    
    
}
