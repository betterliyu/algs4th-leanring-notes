/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int index = 0;
        String champion = null;
        while (!StdIn.isEmpty()) {
            index++;
            String cur = StdIn.readString();
            double p = 1.0 / index;
            if (StdRandom.bernoulli(p)) {
                champion = cur;
            }
        }
        StdOut.println(champion);
    }
}
