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
public class Process {
    private int deadline;
    private int periodo;
    private int exTime;
    private String name;
    private int processBeg;
    private int missedDeadLines;
    private int cantPeriods;
    private int numProc;
    private Boolean processState;
    private ArrayList<Process> queue;
    private Boolean init;
    

    public Process() {
        this.queue=new ArrayList<Process>();
    }

    public Process(int deadline, int periodo, int exTime, String name, int processBeg,int numProc,Boolean processState, Boolean  init) {
        this.deadline = deadline;
        this.periodo = periodo;
        this.exTime = exTime;
        this.name = name;
        this.processBeg = processBeg;
        this.numProc= numProc;
        this.processState=processState;
        this.queue=new ArrayList<Process>();
        this.init= init;
        
    }

    public Boolean getInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }

    public Boolean getProcessState() {
        return processState;
    }

    public void setProcessState(Boolean processState) {
        this.processState = processState;
    }

    public int getMissedDeadLines() {
        return missedDeadLines;
    }

    public void setMissedDeadLines(int missedDeadLines) {
        this.missedDeadLines = missedDeadLines;
    }

    public int getNumProc() {
        return numProc;
    }

    public void setNumProc(int numProc) {
        this.numProc = numProc;
    }

    

    public int getProcessBeg() {
        return processBeg;
    }

    public void setProcessBeg(int processBeg) {
        this.processBeg = processBeg;
    }

 
    

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExTime() {
        return exTime;
    }

    public void setExTime(int exTime) {
        this.exTime = exTime;
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

    public int getCantPeriods() {
        return cantPeriods;
    }

    public void setCantPeriods(int cantPeriods) {
        this.cantPeriods = cantPeriods;
    }
    
    

    @Override
    public String toString() {
        return "Process{" + "deadline=" + deadline + ", periodo=" + periodo + ", exTime=" + exTime + ", name=" + name + ", processBeg=" + processBeg + ", missedDeadLines=" + missedDeadLines + ", numProc=" + numProc + ", processState=" + processState + ", queue=" + queue + ", init=" + init + '}';
    }
    
    
   

}
