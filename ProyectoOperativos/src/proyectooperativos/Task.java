package Scheduling;

import static Scheduling.SchedulingLogic.Tasks;
import static Scheduling.SchedulingLogic.TimeElapsed;

/*
 * @author Jefferson Lezcano
*/
public class Task
{
    public int Id;
    public int ArrivalTime;
    public int EntryTime;
    public int ExecutionTime;
    public int Period;
    public int BurstTime;
    public int Deadline;
    
    public void Task(int id, int executionTime, int period, int deadline)
    {
        Id = Tasks.isEmpty() ? 1 : Tasks.get(Tasks.size() - 1).Id + 1;
        Deadline = deadline;
        ExecutionTime = executionTime;
        Period = period;
        ArrivalTime = TimeElapsed;
        BurstTime = ExecutionTime;
    }
    
    public String ToString()
    {
        return "\n" + "Proccess Id: " + Id + "\n" +
                "Execution time: " + ExecutionTime + "\n" +
                "Period: " + Period + "\n" +
                "Deadline: " + Deadline + "\n" +
                "Arrival Time : " + ArrivalTime + "\n" +
                "Remaining : " + BurstTime + "\n";
    }
}
