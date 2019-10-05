<<<<<<< HEAD
package proyectooperativos;
=======
package Scheduling;

>>>>>>> 575a1ea29589fa62abaec9f20a658bea572da6b4
import java.util.ArrayList;

/*
 * @author Jefferson Lezcano
*/
public class RateMonotonicScheduling
{
    public static enum Status
    {
        Empty,
        Ordinary,
        Complete,
        Missed
    }
    
    public ArrayList<Task> Tasks;
    private int Time;
    public ArrayList<Integer> Timeline;
    private ArrayList<Task> Queue;
    public static int ElapsedTime;
    
    public RateMonotonicScheduling(int time)
    {
        Tasks = new ArrayList<>();
        Time = time;
        Timeline = new ArrayList<>();
        Queue = new ArrayList<>();
        ElapsedTime = 0;
    }
    
    public void Add(Task task)
    {
        int i;
        for(i = 0; i < Queue.size(); i++)
            if (Queue.get(i).Period > task.Period)
                break;
        task.EntryTime = ElapsedTime;
        task.PeriodCounter++;
        Queue.add(i, task);
    }
    
    public Status Execute()
    {
        if(Queue.isEmpty())
            return Status.Empty;
        Task task = Queue.get(0);
        if(++task.BurstTime % task.ExecutionTime == 0)
        {
            Queue.remove(0);
            if (task.EntryTime + task.Period < ElapsedTime)
                return Status.Missed;
            return Status.Complete;
        }
        return Status.Ordinary;
    }
    
    private boolean Predict(Task task)
    {
        if((task.BurstTime / task.ExecutionTime + 1) * task.Period - ElapsedTime
                - (task.ExecutionTime - task.BurstTime % task.ExecutionTime) >= 0)
            return true;
        return false;
    }
    
    public void Run()
    {
        for(ElapsedTime = 0; ElapsedTime < Time; ElapsedTime++)
        {
            for (Task task : Tasks)
                if ((ElapsedTime - task.ArrivalTime) % task.Period == 0)
                    Add(task);
            if (Queue.isEmpty())
            {
                Timeline.add(-1);
                continue;
            }
            Task task = Queue.get(0);
            while(!Predict(task))
            {
                task.MissedDeadline++;
                Queue.remove(0);
                if (Queue.isEmpty())
                    break;
                task = Queue.get(0);
            }
            Timeline.add(task.Id);
            Execute();
        }
    }
    
    public static ArrayList<Task> ToTaskList(ArrayList<Process> processes)
    {
        ArrayList<Task> result = new ArrayList<>();
        for(Process process : processes)
            result.add(new Task(process.getNumProc(), process.getExTime(), process.getPeriodo()));
        return result;
    }
    
    public static ArrayList<Process> ToProcessList(ArrayList<Task> Tasks)
    {
        ArrayList<Process> result = new ArrayList<>();
        for(Task task : Tasks)
            result.add(new Process(0, task.Period, task.ExecutionTime, "", 0, task.Id, true, true));
        return result;
    }
}
