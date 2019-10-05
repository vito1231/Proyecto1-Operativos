/*
 * @author Jefferson Lezcano
*/
public class Task
{
    public int Id;
    public int ArrivalTime;
    public int BurstTime;
    public int EntryTime;
    public int ExecutionTime;
    public int Period;
    
    public Task(int id, int executionTime, int period)
    {
        Id = id;
        ExecutionTime = executionTime;
        Period = period;
        ArrivalTime = TimeElapsed;
        BurstTime = 0;
    }
    
    public String ToString()
    {
        return "\n" + "Proccess Id: " + Id + "\n" +
                "Execution time: " + ExecutionTime + "\n" +
                "Period: " + Period + "\n" +
                "Arrival Time : " + ArrivalTime + "\n" +
                "Burst Time : " + BurstTime + "\n";
    }
}
