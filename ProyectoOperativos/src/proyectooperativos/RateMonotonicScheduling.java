package proyectooperativos;
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
    private ArrayList<Task> Queue;
    
    public RateMonotonicScheduling()
    {
        Tasks = new ArrayList<>();
        Queue = new ArrayList<>();
    }
    
    public void Add(Task task)
    {
        int i;
        for(i = 0; i < Queue.size(); i++)
            if (Queue.get(i).Period > task.Period)
                break;
        task.EntryTime = TimeElapsed;
        Tasks.add(i, task);
    }
    
    public Status Execute()
    {
        if(Queue.isEmpty())
            return Status.Empty;
        Task task = Queue.get(0);
        if(++task.BurstTime % task.ExecutionTime == 0)
        {
            Queue.remove(0);
            if (task.EntryTime + task.Period < TimeElapsed)
                return Status.Missed;
            return Status.Complete;
        }
        return Status.Ordinary;
    }
    
    private boolean Predict(Task task)
    {
        if((task.BurstTime / task.ExecutionTime + 1) * task.Period - TimeElapsed
                - (task.ExecutionTime - task.BurstTime % task.ExecutionTime) >= 0)
            return true;
        return false;
    }
    
    public Status Run()
    {
        for(TimeElapsed = 0; ;TimeElapsed++)
        {
            for (Task task : Tasks)
                    if ((TimeElapsed - task.ArrivalTime) % task.Period == 0)
                        Add(task);
            Task task = Queue.get(0);
            while(!Predict(task))
            {
                Queue.remove(0);
                Tasks.remove(task);
                if (Queue.isEmpty())
                    break;
                task = Queue.get(0);
            }
            return Execute();
        }
    }
    
    public static ArrayList<Task> ToTaskList(ArrayList<Process> processes)
    {
        ArrayList<Task> result = new ArrayList<>();
        for(Process process : processes)
            result.add(new Task(process.numProc, process.exTime, process.periodo));
        return result;
    }
}
