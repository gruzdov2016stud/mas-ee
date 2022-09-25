import homeWork.pr1.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class TestClass {

    MyLinkedList<Integer> list = new MyLinkedList<>();

    @Test
    public void addTest() {
        list.addAll(List.of(5,6,7,8,9));
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        System.out.println(Arrays.toString(list.toArray()));
        for (int i = 0; i <list.size(); i++) {
            Assertions.assertEquals(i, list.get(i));
        }
    }

    @Test
    public void removeByValueTest() {
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        list.remove(Integer.valueOf(5));
        Assertions.assertArrayEquals(new Integer[] {0,1,2,3,4,6,7,8,9}, list.toArray());
    }

    @Test
    public void removeByIndexTest() {
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        list.remove(0);
        list.remove(2);
        Assertions.assertArrayEquals(new Integer[] {1,2,4,5,6,7,8,9}, list.toArray());
    }

    @Test
    public void sizeTest() {
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        Assertions.assertEquals(10, list.size());
    }

    @Test
    public void IsEmptyTest() {
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        list.removeAll(List.of(0,1,2,3,4,5,6,7,8,9));
        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    public void IteratorTest() {
        int i = 0;
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        for (Integer integer: list) {
            Assertions.assertEquals(i, integer);
            i++;
        }
    }

    @Test
    public void containsTest() {
        list.addAll(List.of(0,1,2,3,4,5,6,7,8,9));
        Assertions.assertEquals(false, list.contains(13));
    }

    @Test
    public void indexOfTest() {
        list.addAll(List.of(0,1,2,3,4,55,6,7,8,9));
        Assertions.assertEquals(5, list.indexOf(55));
    }

}
