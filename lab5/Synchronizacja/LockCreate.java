import java.util.concurrent.CopyOnWriteArrayList;

public class LockCreate {
    private int index = 0;
    private CopyOnWriteArrayList<Integer> queue;

    public LockCreate()
    {
        queue = new CopyOnWriteArrayList<>();
    }

    public void addToQueue(int i)
    {
        queue.add(i);
    }

    public int getCurrentQueue()
    {
        if (index >= queue.size()-1){
            index = queue.size()-1;
        }
        return queue.get(index);
    }

    public void incrementQueue()
    {
        if(index < queue.size()-1){
            index++;
        }
        else{
            index = 0;
        }
    }

    public void deleteFromQueue(int i)
    {
        queue.remove(Integer.valueOf(i));
    }
}

