package material.test.practica1;

import material.Position;
import material.linear.DoubleLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class test for DoubleLinkedList
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro, JD. Quintana
 */

class DoubleLinkedListTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertEquals(0, list.size());
        list.addFirst(1);
        list.addLast(5);
        // [1, 5]
        assertEquals(2, list.size());
        list.addAfter(list.first(), 3);
        list.addBefore(list.last(), 4);
        // [1,3,4,5]
        assertEquals(4, list.size());
        list.remove(list.first());
        list.remove(list.last());
        // [3,4]
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertTrue(list.isEmpty());
        list.addFirst(2);
        assertFalse(list.isEmpty());
        list.remove(list.first());
        assertTrue(list.isEmpty());
    }


    @Test
    public void firstShouldFailWhenEmpty() {
        assertThrows(RuntimeException.class, () -> {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
            list.first();
        }, "Method should fail for an empty list");
    }

    @Test
    void first() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(3);
        Position<Integer> pos = list.first();
        int element = pos.getElement();
        assertEquals(element, 3);
        list.addLast(4);
        pos = list.first();
        element = pos.getElement();
        assertEquals(element, 3);
        list.addFirst(2);
        pos = list.first();
        element = pos.getElement();
        assertEquals(element, 2);
    }

    @Test
    void lastShouldFailWhenEmpty() {
        assertThrows(RuntimeException.class, () -> {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
            list.last();
        }, "Method should fail for an empty list");
    }

    @Test
    public void last() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addLast(3);
        Position<Integer> pos = list.last();
        int element = pos.getElement();
        assertEquals(element, 3);
        list.addFirst(4);
        pos = list.last();
        element = pos.getElement();
        assertEquals(element, 3);
        list.addLast(2);
        pos = list.last();
        element = pos.getElement();
        assertEquals(element, 2);
    }

    @Test
    void prevShouldFailWhenNoPreviousElement() {
        assertThrows(RuntimeException.class, () -> {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
            list.addFirst(1);
            list.prev(list.first());
        }, "Method should fail for the first element");
    }

    @Test
    public void prev() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        Position<Integer> pos = list.addAfter(list.first(), 4);
        // [1,4,2]
        int value = list.prev(list.last()).getElement();
        assertEquals(value, 4);
        value = list.prev(pos).getElement();
        assertEquals(value, 1);
    }

    @Test
    void nextShouldFailWhenNoNextElement() {
        assertThrows(RuntimeException.class, () -> {
            DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
            list.addFirst(1);
            list.next(list.first());
        }, "Method should fail for the last element");
    }

    @Test
    void next() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos2 = list.addAfter(list.first(), 2);
        Position<Integer> pos3 = list.addAfter(pos2, 3);
        Position<Integer> pos4 = list.addAfter(pos3, 4);
        int elem2 = list.next(list.first()).getElement();
        int elem3 = list.next(pos2).getElement();
        int elem4 = list.next(pos3).getElement();
        assertEquals(elem2, 2);
        assertEquals(elem3, 3);
        assertEquals(elem4, 4);
    }

    @Test
    void addBefore() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        int value = list.first().getElement();
        assertEquals(value, 1);
        list.addBefore(list.first(), 3);
        value = list.first().getElement();
        assertEquals(value, 3);
    }

    @Test
    void addAfter() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        int value = list.first().getElement();
        assertEquals(value, 1);
        list.addAfter(list.last(), 3);
        value = list.last().getElement();
        assertEquals(value, 3);
    }

    @Test
    void addFirst() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(2);
        int value = list.first().getElement();
        assertEquals(value, 2);
        list.addFirst(3);
        value = list.first().getElement();
        assertEquals(value, 3);
    }

    @Test
    void addLast() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addLast(2);
        int value = list.last().getElement();
        assertEquals(value, 2);
        list.addLast(3);
        value = list.last().getElement();
        assertEquals(value, 3);
    }

    @Test
    void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.remove(list.first());
        assertTrue(list.isEmpty());
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        int first = list.first().getElement();
        assertEquals(first, 3);
    }

    @Test
    void set() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos2 = list.addLast(2);
        list.addLast(3);
        list.set(pos2, 4);
        int value = pos2.getElement();
        assertEquals(value, 4);
        list.set(list.last(), 5);
        value = list.last().getElement();
        assertEquals(value, 5);
    }

    @Test
    void isFirst() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Position<Integer> pos = list.addFirst(1);
        list.addLast(2);
        assertTrue(list.isFirst(list.first()));
        assertTrue(list.isFirst(pos));
        assertFalse(list.isFirst(list.last()));
    }

    @Test
    void isLast() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos = list.addLast(2);
        assertTrue(list.isLast(list.last()));
        assertTrue(list.isLast(pos));
        assertFalse(list.isLast(list.first()));
    }

    @Test
    void swapElements() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.swapElements(list.first(), list.last());
        int first = list.first().getElement();
        int last = list.last().getElement();
        assertEquals(first, 4);
        assertEquals(last, 1);
    }

//    @Test
//    public void testToString() {
//        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//        list.addFirst(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        String textList = list.toString();
//        assertEquals(textList, "[1,2,3,4]");
//    }

//    @Test
//    public void testIterator() {
//        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//        list.addFirst(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        Iterator<Integer> it = list.iterator();
//        assertEquals((int)it.next(), 1);
//        assertEquals((int)it.next(), 2);
//        assertEquals((int)it.next(), 3);
//        assertEquals((int)it.next(), 4);
//    }


}