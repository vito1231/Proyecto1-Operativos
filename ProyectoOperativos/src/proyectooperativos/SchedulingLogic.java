package Scheduling;

import java.util.ArrayList;

/*
 * @author Jefferson Lezcano
*/
public class SchedulingLogic
{
    public static enum Status
    {
        Empty,
        Ordinary,
        Complete,
        Missed
    }
    
    public static ArrayList<Task> Tasks = new ArrayList<>();
    public static int TimeElapsed = 0;
    public static Queue Queue = new Queue();
    
    public static void Run()
    {
        for(TimeElapsed = 0; ;TimeElapsed++)
        {
            for (Task task : Tasks)
                    if (TimeElapsed - task.ArrivalTime % task.Period == 0)
                        Queue.Add(task);
            Execute();
        }
    }
    
    public static Status Execute()
    {
        if(Queue.Tasks.isEmpty())
            return Status.Empty;
        Task task = Queue.Tasks.get(0);
        if(++task.BurstTime % task.Period == 0)
        {
            Queue.Tasks.remove(0);
            if (task.EntryTime + task.Period <= TimeElapsed)
                return Status.Missed;
            return Status.Complete;
        }
        return Status.Ordinary;
    }
}
