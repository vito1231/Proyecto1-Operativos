/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author vicnb
 */
public class EDF {
    private int len;
    private Process[] processLine;
    private ArrayList<Process> procesos;
    private ArrayList<Process> queue;
     

    public EDF(int len, ArrayList<Process> pro) {
        this.len = len;
        processLine=new Process[len];
        procesos=pro;   
    }

    public EDF() {
        
    }

    public void apply(){
        ArrayList<Process> actuales= new ArrayList<Process>();
        
        for(int time=0;time<len;time++){
            
        }
        
    }
    
    public void crearProcesos(){
        ArrayList<Process> res= new ArrayList<Process>();
        int contUNO, contCERO, cantidadProcesos,tempPeriodo,tempEx,tempDead, tempProcBeg;
        String tempname;
        for(int i=0;i<procesos.size();i++){
            cantidadProcesos=(int) Math.ceil((float)this.len/procesos.get(i).getPeriodo());
            contUNO=1;
            contCERO=0;
            while(cantidadProcesos>0){
                tempPeriodo=procesos.get(i).getPeriodo()*contUNO;
                tempEx=procesos.get(i).getExTime();
                tempDead=procesos.get(i).getPeriodo()*contCERO+procesos.get(i).getDeadline();
                tempProcBeg=procesos.get(i).getPeriodo()*contUNO;
                tempname=procesos.get(i).getName();
                Process temp =new Process(tempDead, tempPeriodo, tempEx, tempname, tempProcBeg, contUNO,false);
                res.add(temp);
                cantidadProcesos--;
                contUNO++;
                contCERO++;
            }
        }
        queue=res;
    } 
    
    
    public void distribuirProcesos(){
        order();
        for(Process p:queue){
            for(Process temp: procesos){
                if(temp.getName()==p.getName()){
                    temp.getQueue().add(p);
                }
            }
        }
    }

    public ArrayList<Process> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<Process> queue) {
        this.queue = queue;
    }
    
    
    
    public void order(){
        for(int i=0; i< queue.size();i++){
            int dead=queue.get(i).getDeadline();
            for(int j=0; j<queue.size();j++){
                if(queue.get(j).getDeadline() > queue.get(i).getDeadline()){
                    Collections.swap(queue,i,j);
                }
            }
            
        }
    }
    
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public Process[] getProcessLine() {
        return processLine;
    }

    public void setProcessLine(Process[] processLine) {
        this.processLine = processLine;
    }

    public ArrayList<Process> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Process> procesos) {
        this.procesos = procesos;
    }
    
    
    
}
