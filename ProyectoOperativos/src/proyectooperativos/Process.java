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
    private String name;

    public Process() {
    }

    public Process(int deadline, int periodo, String name) {
        this.deadline = deadline;
        this.periodo = periodo;
        this.name = name;
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
    
    
}
