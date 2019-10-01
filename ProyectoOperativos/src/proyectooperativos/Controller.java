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
public class Controller {
    private ArrayList<Process> procesos;
    
    public Controller() {
        procesos=new ArrayList<Process>();
    }
   
    
    public ArrayList createEDF(){
        
        return null;
    }
            
    public void extractProcessesTXT(String filename){
        Archive txt= new Archive(filename);
        ArrayList<String> sinProcesar= txt.readFile();
        int cont=0;
        for(String s: sinProcesar){
            Process proce=new Process();
            proce.setName("P"+Integer.toString(cont));
            String[] parts = s.split(" ");
            if(parts.length== 3){
                proce.setExTime(Integer.parseInt(parts[0]));
                proce.setDeadline(Integer.parseInt(parts[1]));
                proce.setPeriodo(Integer.parseInt(parts[2]));
            }
            else{
                proce.setExTime(Integer.parseInt(parts[0]));
                proce.setPeriodo(Integer.parseInt(parts[1]));
            }
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
