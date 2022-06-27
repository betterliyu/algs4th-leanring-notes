/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue = (Item[]) new Object[1];
    private int size = 0;

    // construct an empty deque
    public RandomizedQueue() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        queue[size++] = item;
        if (size == queue.length) {
            changeSize(size + 2);
        }

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(0, size);
        Item removed = queue[index];
        queue[index] = queue[--size];
        queue[size] = null;
        if (size == queue.length / 4) {
            changeSize(queue.length / 2);
        }
        return removed;
    }

    private void changeSize(int capility) {
        Item[] temp = (Item[]) new Object[capility];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }


    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(0, size);
        Item sample = queue[index];
        return sample;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int cursor = size - 1;
        private int[] orders = new int[size];


        public QueueIterator() {
            for (int i = 0; i < size; i++) {
                orders[i] = i;
            }
            StdRandom.shuffle(orders);
        }

        public boolean hasNext() {
            return cursor >= 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return queue[orders[cursor--]];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        // RandomizedQueue<String> queue = new RandomizedQueue<String>();
        // System.out.println("queue is empty: " + queue.isEmpty());
        // System.out.println("queue size: " + queue.size);
        // queue.enqueue("1");
        // queue.enqueue("2");
        // queue.enqueue("3");
        //
        // Iterator<String> it = queue.iterator();
        // System.out.println("first item: " + it.next());
        // System.out.println("second item: " + it.next());
        // System.out.println("third item: " + it.next());
        // System.out.println("no more: " + !it.hasNext());
        //
        // System.out.println("dequeue: " + queue.dequeue());
        // System.out.println("dequeue: " + queue.dequeue());
        //
        // queue.enqueue("4");
        // queue.enqueue("5");
        // queue.enqueue("6");
        // System.out.println("queue size: " + queue.size);
        // Iterator<String> newIt = queue.iterator();
        // System.out.println("first item: " + newIt.next());
        // System.out.println("second item: " + newIt.next());
        // System.out.println("third item: " + newIt.next());
        // System.out.println("no more: " + !newIt.hasNext());
        // System.out.println("third item: " + newIt.next());
        // System.out.println("no more: " + !newIt.hasNext());
        //
        //
        // int n = 5;
        // RandomizedQueue<Integer> queue1 = new RandomizedQueue<Integer>();
        // for (int i = 0; i < n; i++) {
        //     queue1.enqueue(i);
        // }
        // for (int a : queue1) {
        //     for (int b : queue1) {
        //         StdOut.print(a + "-" + b + " ");
        //     }
        //     StdOut.println();
        // }

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.size();
        queue.isEmpty();
        queue.isEmpty();
        queue.enqueue(257);
        queue.dequeue();
        queue.size();
        queue.size();
        queue.size();
        queue.enqueue(353);

    }
}
