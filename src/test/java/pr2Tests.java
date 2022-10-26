//import homeWork.pr1.MyPlainArrList;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class pr2Tests {
//
//    MyPlainArrList<Integer> list = new MyPlainArrList<>();
//    List<Integer> example = List.of(0,1,2,3,4,5,6,7,8,9);
//
//    @Test
//    public void addTest() {
//        List<Integer> example = List.of(1,2,3,4,5);
//        list.addAll(example);
//        list.addFirst(0);
//        list.addLast(6);
//        for (int i = 0; i <list.size(); i++) {
//            Assertions.assertEquals(i, list.get(i));
//        }
//    }
//    @Test
//    public void sizeTest() {
//        list.addAll(example);
//        Assertions.assertEquals(10, list.size());
//    }
//
//    @Test
//    public void IsEmptyTest() {
//        list.addAll(example);
//        list.clear();
//        Assertions.assertTrue(list.isEmpty());
//    }
//
//
//    @Test
//    public void removeByValueTest() {
//        list.addAll(example);
//        list.remove(Integer.valueOf(0));
//        Assertions.assertFalse(list.contains(0));
//    }
//
//    @Test
//    public void removeByIndexTest() {
//        list.addAll(example);
//        list.remove(0);
//        Assertions.assertFalse(list.contains(0));
//    }
//
//
//    @Test
//    public void IteratorTest() {
//        int i = 0;
//        list.addAll(example);
//        for (Integer integer: list) {
//            Assertions.assertEquals(i, integer);
//            i++;
//        }
//    }
//
//    @Test
//    public void indexOfTest() {
//        list.addAll(example);
//        Assertions.assertEquals(2, list.indexOf(2));
//    }
//
//}
