/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int trials;
    private final double[] thresholds;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        this.trials = trials;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            thresholds[i] = 0;
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                // got a random site which is not opened
                int randomIndex = StdRandom.uniform(1, n * n + 1);
                int row = randomIndex % n == 0 ? randomIndex / n : randomIndex / n + 1;
                int col = randomIndex % n == 0 ? n : randomIndex % n;
                while (percolation.isOpen(row, col)) {
                    randomIndex = StdRandom.uniform(1, n * n + 1);
                    row = randomIndex % n == 0 ? randomIndex / n : randomIndex / n + 1;
                    col = randomIndex % n == 0 ? n : randomIndex % n;
                }
                // open site
                percolation.open(row, col);
            }
            // log threshold if it is percolates
            thresholds[i] = percolation.numberOfOpenSites() / (n * n * 1.0);

        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - (CONFIDENCE_95 / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + (CONFIDENCE_95 / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);

        System.out.println("mean\t = " + percolationStats.mean());
        System.out.println("stddev\t = " + percolationStats.stddev());
        System.out.println("95% confidence interval\t = [ " + percolationStats.confidenceLo() + ", "
                                   + percolationStats.confidenceHi() + " ]");
    }
}
