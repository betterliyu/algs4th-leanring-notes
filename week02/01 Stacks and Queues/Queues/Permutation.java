/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> strs = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            strs.enqueue(input);
        }
        Iterator<String> it = strs.iterator();
        while (it.hasNext() && k > 0) {
            System.out.println(it.next());
            k--;
        }

    }
}
