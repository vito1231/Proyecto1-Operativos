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
public class EDF {
    private int len;
    private String[] processLine;
    private ArrayList<Process> procesos;
     

    public EDF(int len, ArrayList<Process> pro) {
        this.len = len;
        processLine=new String[len];
        procesos=pro;
        
    }

    public EDF() {
    }

    public void apply(){
        
    }
    
    
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String[] getProcessLine() {
        return processLine;
    }

    public void setProcessLine(String[] processLine) {
        this.processLine = processLine;
    }

    public ArrayList<Process> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Process> procesos) {
        this.procesos = procesos;
    }
    
    
    
}
