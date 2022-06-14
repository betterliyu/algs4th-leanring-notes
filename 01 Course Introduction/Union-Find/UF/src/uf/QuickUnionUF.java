package uf;

/**
 * 快速合并
 */

public class QuickUnionUF extends UF {

    public QuickUnionUF(int n) {
        super(n);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        ids[pRoot] = qRoot;
    }

    private int root(int q) {
        while(ids[q] != q) {
            q = ids[q];
        }
        return q;
    }

}
