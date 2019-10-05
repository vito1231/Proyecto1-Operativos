<<<<<<< HEAD
package proyectooperativos;
=======
package Scheduling;

import static Scheduling.RateMonotonicScheduling.ElapsedTime;

>>>>>>> 575a1ea29589fa62abaec9f20a658bea572da6b4
/*
 * @author Jefferson Lezcano
*/
public class Task
{
    public int Id;
    public int ArrivalTime;
    public int EntryTime;
    public int ExecutionTime;
    public int MissedDeadline;
    public int Period;
    public int PeriodCounter;
    public int BurstTime;
    
    public Task(int id, int executionTime, int period)
    {
        Id = id;
        ArrivalTime = ElapsedTime;
        BurstTime = 0;
        ExecutionTime = executionTime;
        MissedDeadline = 0;
        Period = period;
        PeriodCounter = 0;
    }
    
    public String ToString()
    {
        return "\n" + "Proccess Id: " + Id + "\n" +
                "Execution time: " + ExecutionTime + "\n" +
                "Period: " + Period + "\n" +
                "Arrival Time : " + ArrivalTime + "\n" +
                "Total time executed : " + BurstTime + "\n";
    }
}
