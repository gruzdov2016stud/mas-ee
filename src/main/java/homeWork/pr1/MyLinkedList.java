package homeWork.pr1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    private Node last;
    private Node first;
    private int counter;
    private int inverseCounter=5;
    private int size;

    public static class Node {
        Object [] items;
        Node next;
        Node prev;

        Node(Node prev, Object [] items, Node next) {
            this.items = items;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        last = new Node(null, new Object[5], null);
        first = last;
    }

    public void addFirst(T t) {
        if (inverseCounter >= 5) {
            inverseCounter = 0;
            Node node = new Node(null, new Object[5], first);
            first.prev = node;
            first = node;
        }
        first.items[4-inverseCounter] = t;
        inverseCounter++;
        size++;
    }

    public void addLast(T t) {
        if (counter < 5) {
            last.items[counter] = t;
            counter++;
        } else {
            Node newNode = new Node(last, new Object[5], null);
            last.next = newNode;
            newNode.items[0] = t;
            last = newNode;
            counter = 1;
        }
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int nextIndex;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                T t = get(nextIndex);
                nextIndex++;
                return t;
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i=0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        for (Object o: a) {
            addLast((T) o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (Object o: objects) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = new Node(null, new Object[] {}, null);
        size = 0;
        counter = 0;
        inverseCounter = 5;
    }

    @Override
    public T get(int index) {
        Node node = first;
        for (int i = 0; i < (index + 5 - inverseCounter)/5; i++) {
            node = node.next;
        }
        return (T) node.items[(index + 5 - inverseCounter) % 5];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        Node node = first;
        Object removedObject = get(index);

        if (index > size) {
            return null;
        } else {
            for (int i = 0; i < (index + 5 - inverseCounter)/5; i ++) {
                node = node.next;
            }
            Object[] array = toArray();
            last = node;
            node.next = null;
            size = index;
            counter = (index + 5 - inverseCounter)%5;

            for (int i = index+1; i < array.length; i++) {
                addLast((T) array[i]);
            }
        }
        return (T) removedObject;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i < size; i++) {
            if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
