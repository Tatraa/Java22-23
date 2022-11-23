package pl.edu.uj.generics;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<T>{
    private final ArrayList<OrderedPair<Integer, T>> list = new ArrayList<>();

    public boolean compare(OrderedPair<Integer, ?> parent, OrderedPair<Integer, ?> child) {
        return parent.getKey() < child.getKey();
    }

    public PriorityQueue(){
        list.add(new OrderedPair<>(0, null));
    }

    public void add(T t, int priority) {
        list.add(new OrderedPair<>(priority,t));

        int childIndex = list.size() - 1;
        int parentIndex = Math.floorDiv(childIndex, 2);

        if(list.size() > 2)
            while((compare(list.get(parentIndex), list.get(childIndex))) && childIndex >= 2) {
                Collections.swap(list, childIndex, parentIndex);

                childIndex = parentIndex;
                parentIndex = Math.floorDiv(childIndex, 2);
            }
    }

    public T get() throws Exception {
        if(list.size() == 1)
            throw new Exception("EmptyQueueException");

        T returnValue = list.get(1).getValue();

        list.set(1, new OrderedPair<>(0, null));

        int blankNode = 1;
        int firstChild = 2;
        int secondChild = 3;
        if(secondChild < list.size() && compare(list.get(firstChild), list.get(secondChild)))
            firstChild = secondChild;

        while(firstChild < list.size() && compare(list.get(blankNode), list.get(firstChild))){
            Collections.swap(list, firstChild, blankNode);

            blankNode = firstChild;
            firstChild = blankNode * 2;
            secondChild = blankNode * 2 + 1;
            if(secondChild < list.size() && compare(list.get(firstChild), list.get(secondChild)))
                firstChild = secondChild;
        }

        list.remove(blankNode);

        return returnValue;
    }
}
