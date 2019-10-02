/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

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
    private int numProc;
    private Boolean processState;

    public Process() {
    }

    public Process(int deadline, int periodo, int exTime, String name, int processBeg,int numProc,Boolean processState) {
        this.deadline = deadline;
        this.periodo = periodo;
        this.exTime = exTime;
        this.name = name;
        this.processBeg = processBeg;
        this.numProc= numProc;
        this.processState=processState;
        
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

    @Override
    public String toString() {
        return "Process{" + "deadline=" + deadline + ", periodo=" + periodo + ", exTime=" + exTime + ", name=" + name + ", numProc=" + numProc+ ", processState="+ processState + ", processBeg=" + processBeg + ", missedDeadLines=" + missedDeadLines + '}';
    }
    

}
