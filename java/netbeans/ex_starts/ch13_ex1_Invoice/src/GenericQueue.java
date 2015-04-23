import java.util.LinkedList;

public class GenericQueue<E>
{
    private LinkedList<E> list = new LinkedList<E>();

    public void push(E item)
    {
        list.addFirst(item);
    }

    public E pull()
    {
        return list.removeLast();
    }

    public int size()
    {
        return list.size();
    }

}