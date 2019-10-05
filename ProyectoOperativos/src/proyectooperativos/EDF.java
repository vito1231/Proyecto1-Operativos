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
        ArrayList<Process> actualesInactivos= new ArrayList<Process>();
        //System.out.println("");
        //System.out.println("");
        //System.out.println("Procesos");
        
                
        for(Process p:procesos){
           // System.out.println(p.toString());
            p.getQueue().get(0).setProcessState(true);
            p.getQueue().get(0).setInit(true);
            
            actuales.add(p.getQueue().get(0));
            p.getQueue().remove(0);
        }
        orderArray(actuales);
        /*
        
        System.out.println("");
        System.out.println("");
        System.out.println("Procesos despues de ACTUALES");
        for(Process p: procesos){
            System.out.println(p.toString());
        }
        
        
        System.out.println("");
        System.out.println("ACTUALES 0");
        for(int ac=0;ac<actuales.size();ac++){
            System.out.println(actuales.get(ac));
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("COLA de Cada proceso");
        for(int ac=0;ac<procesos.size();ac++){
            System.out.println("PROCESOS " + procesos.get(ac).getName());
            for(int ac2=0; ac2 < procesos.get(ac).getQueue().size();ac2++){
                System.out.println(procesos.get(ac).getQueue().get(ac2).toString());
            }
            System.out.println(" ");
            System.out.println(" ");
            
        }*/
        
        
        for(int time=0;time<len;time++){
            
            //System.out.println("");
            
            
           // System.out.print("Actuales");
            //System.out.println();
            //System.out.println(actuales.toString());
            //System.out.print("Inactivos");
            //System.out.println(actualesInactivos.toString());
            //if(!actuales.isEmpty()){
                
                for(int i=0;i<actuales.size();i++){
                    
                    if(actuales.get(i).getProcessState()==false && actuales.get(i).getInit()==true){
                        Process prTemp= actuales.get(i);
                        actuales.remove(i);
                        for(Process temp: procesos){
                            if(!actuales.isEmpty()){
                                if(prTemp.getName().equals(temp.getName())){
                                    if(!temp.getQueue().isEmpty()){
                                    //temp.getQueue().get(0).setProcessState(true);
                                        if(temp.getQueue().get(0).getProcessBeg()<=time && temp.getQueue().get(0).getPeriodo() >= time){
                                            temp.getQueue().get(0).setProcessState(true);
                                            temp.getQueue().get(0).setInit(true);
                                            actuales.add(temp.getQueue().get(0));
                                            temp.getQueue().remove(0);
                                            orderArray(actuales);
                                        }
                                        else{
                                            actualesInactivos.add(temp.getQueue().get(0));
                                            temp.getQueue().remove(0);   
                                        }

                                    } 
                                }
                            }
                            else{
                                break;
                            }
                            
                        }   
                    }
                }
                
                if(!actualesInactivos.isEmpty()){
              //      System.out.println("ENTRA");
                    int primerS= actuales.size();
                    for(int i=0;i<actualesInactivos.size();i++){
                        
                        if(actualesInactivos.get(i).getProcessBeg()<=time && actualesInactivos.get(i).getPeriodo() >= time){
                //            System.out.println("Paso el if");
                  //          System.out.print("Inactivos despues del if");
                    //        System.out.println(actualesInactivos.toString());
                            actualesInactivos.get(i).setProcessState(true);
                            actualesInactivos.get(i).setInit(true);
                            actuales.add(actualesInactivos.get(i));
                            actualesInactivos.remove(i);
                        }
                    }
                    if(primerS!=actuales.size()){
                        orderArray(actuales);
                    }
                }

                    for(Process p: actuales){
                        if(time<=(p.getPeriodo()-p.getExTime())){
                            processLine[time]=p;
                            p.setExTime(p.getExTime()-1);
                            if(p.getExTime()==0){
                                p.setProcessState(false);
                            }
                            
                            break;
                        }
                        else if(time > (p.getPeriodo()-p.getExTime()) || time>p.getPeriodo()){
                                    p.setProcessState(false);
                            for(Process miss:procesos){
                                if(miss.getName().equals(p.getName())){
                                    miss.setMissedDeadLines(miss.getMissedDeadLines()+1);
                                }
                            }
                        }
                    }
                    
                    
                   if(processLine[time] == null){
                       //System.out.println("NULL");
                       Process p1=new Process();
                       p1.setName("NULL");
                       processLine[time]=p1;
                   }
                          
                //}

            
            
               
            
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
                tempProcBeg=procesos.get(i).getPeriodo()*contCERO;
                tempname=procesos.get(i).getName();
                Process temp =new Process(tempDead, tempPeriodo, tempEx, tempname, tempProcBeg, contUNO,false,false);
                
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
        for(int i=0;i<queue.size();i++){
            for(int j=0;j<procesos.size();j++){
                if(procesos.get(j).getName()==queue.get(i).getName()){
                    procesos.get(j).getQueue().add(queue.get(i));
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
    
    public void orderArray(ArrayList<Process> queue){
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
