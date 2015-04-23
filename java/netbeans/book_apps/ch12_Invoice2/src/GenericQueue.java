import java.util.LinkedList;

public class GenericQueue<E>
{
    private LinkedList<E> list = new LinkedList<>();

    public void push(E item)
    {
        list.addLast(item);
    }

    public E pull()
    {
        return list.removeFirst();
    }

    public int size()
    {
        return list.size();
    }

}