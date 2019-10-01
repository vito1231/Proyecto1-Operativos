package Scheduling;

import static Scheduling.SchedulingLogic.TimeElapsed;
import java.util.ArrayList;

/*
 * @author Jefferson Lezcano
*/
public class Queue
{
    public ArrayList<Task> Tasks;
    
    public void Queue()
    {
        Tasks = new ArrayList<>();
    }
    
    public void Add(Task task)
    {
        int i;
        for(i = 0; i < Tasks.size(); i++)
            if (Tasks.get(i).Period > task.Period)
                break;
        task.EntryTime = TimeElapsed;
        Tasks.add(i, task);
    }
}
