package homeWork.pr1;

public class Triplet {
    Object [] items;
    Triplet next;
    Triplet prev;

    Triplet(Triplet prev, Object [] items, Triplet next) {
        this.items = items;
        this.next = next;
        this.prev = prev;
    }
}
