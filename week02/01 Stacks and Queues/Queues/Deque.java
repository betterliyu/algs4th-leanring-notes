/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> added = new Node<Item>(item);
        added.next = head;

        if (isEmpty()) {
            tail = added;
        }
        else {
            head.prev = added;
        }
        head = added;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> node = new Node<Item>(item);
        node.prev = tail;
        if (isEmpty()) {
            head = node;
        }
        else {
            tail.next = node;
        }
        tail = node;
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> removed = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        else {
            head.prev = null;
        }
        size--;
        removed.prev = null;
        removed.next = null;
        return removed.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> removed = tail;
        tail = removed.prev;
        if (tail == null) {
            head = null;
        }
        else {
            tail.next = null;
        }
        size--;
        removed.prev = null;
        removed.next = null;
        return removed.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node<Item> cursor;

        public StackIterator() {
            this.cursor = head;
        }

        public boolean hasNext() {
            return cursor != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item cur = cursor.item;
            cursor = cursor.next;
            return cur;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> prev;
        private Item item;

        public Node() {
        }

        public Node(Item item) {
            this.item = item;
        }
    }


    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        System.out.println("deque is empty: " + deque.isEmpty());
        System.out.println("deque size: " + deque.size);
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addLast("3");

        Iterator<String> it = deque.iterator();
        System.out.println("first item: " + it.next());
        System.out.println("second item: " + it.next());
        System.out.println("third item: " + it.next());
        System.out.println("no more: " + !it.hasNext());

        deque.removeFirst();
        deque.removeLast();

        deque.addFirst("4");
        deque.addLast("5");
        deque.addLast("6");
        System.out.println("deque size: " + deque.size);
        Iterator<String> newIt = deque.iterator();
        System.out.println("first item: " + newIt.next());
        System.out.println("second item: " + newIt.next());
        System.out.println("third item: " + newIt.next());
        System.out.println("no more: " + !newIt.hasNext());
        System.out.println("third item: " + newIt.next());
        System.out.println("no more: " + !newIt.hasNext());


        Deque<Integer> deque2 = new Deque<>();
        deque2.addFirst(1);
        deque2.addFirst(2);
        deque2.addFirst(3);
        deque2.addFirst(4);
        deque2.removeLast();
        deque2.addFirst(6);
        deque2.addFirst(7);
        deque2.removeLast();

    }
}
