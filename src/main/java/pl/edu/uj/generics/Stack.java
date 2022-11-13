package pl.edu.uj.generics;

import java.util.Collection;

public class Stack<E> {

    public Stack() {

    }

    public void push(E e) {

    }

    public E pop() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void pushAll2(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public void popAll2(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }


}