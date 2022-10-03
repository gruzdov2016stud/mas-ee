package homeWork.pr1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyPlainArrList <E> implements List<E> {

    private Triplet last;
    private Triplet first;
    private int counter;
    private int indexFromLatsToFirst=5;
    private int length;
    
    public MyPlainArrList() {
        last = new Triplet(null, new Object[5], null);
        first = last;
    }
    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        for (int i=0; i < length; i++) {
            array[i] = get(i);
        }
        return array;
    }

    public void addLast(E t) {
        if (counter < 5) {
            last.items[counter] = t;
            counter++;
        } else {
            Triplet newTriplet = new Triplet(last, new Object[5], null);
            last.next = newTriplet;
            newTriplet.items[0] = t;
            last = newTriplet;
            counter = 1;
        }
        length++;
    }
    @Override
    public boolean add(E t) {
        addLast(t);
        return true;
    }

    public void addFirst(E t) {
        if (indexFromLatsToFirst >= 5) {
            indexFromLatsToFirst = 0;
            Triplet triplet = new Triplet(null, new Object[5], first);
            first.prev = triplet;
            first = triplet;
        }
        first.items[4-indexFromLatsToFirst] = t;
        indexFromLatsToFirst++;
        length++;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        for (Object o: a) {
            add((E) o);
        }
        return true;
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
    public E remove(int index) {
        Triplet triplet = first;
        Object removedObject = get(index);

        if (index > length) {
            return null;
        } else {
            for (int i = 0; i < (index + 5 - indexFromLatsToFirst)/5; i ++) {
                triplet = triplet.next;
            }
            Object[] array = toArray();
            last = triplet;
            triplet.next = null;
            length = index;
            counter = (index + 5 - indexFromLatsToFirst)%5;

            for (int i = index+1; i < array.length; i++) {
                addLast((E) array[i]);
            }
        }
        return (E) removedObject;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int nextIndex;
            @Override
            public boolean hasNext() {
                return nextIndex < length;
            }

            @Override
            public E next() {
                E t = get(nextIndex);
                nextIndex++;
                return t;
            }
        };
    }

    @Override
    public void clear() {
        first = new Triplet(null, new Object[] {}, null);
        length = 0;
        counter = 0;
        indexFromLatsToFirst = 5;
    }

    @Override
    public E get(int index) {
        Triplet triplet = first;
        for (int i = 0; i < (index + 5 - indexFromLatsToFirst)/5; i++) {
            triplet = triplet.next;
        }
        return (E) triplet.items[(index + 5 - indexFromLatsToFirst) % 5];
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i < length; i++) {
            if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
    @Override
    public int size() {
        return length;
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public E set(int index, E element) {
        return null;
    }
    @Override
    public boolean isEmpty() {
        return length == 0;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public void add(int index, E element) {
    }
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
