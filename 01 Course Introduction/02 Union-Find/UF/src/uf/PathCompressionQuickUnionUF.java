package uf;

public class PathCompressionQuickUnionUF extends UF {
    protected int[] size = null;

    public PathCompressionQuickUnionUF(int n) {
        super(n);
        size = new int[n];
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (size[pRoot] == size[qRoot]) {
            return;
        } else if (size[pRoot] > size[qRoot]) {
            ids[qRoot] = pRoot;
            size[pRoot] = size[pRoot] + size[qRoot];
        } else {
            ids[pRoot] = qRoot;
            size[qRoot] = size[pRoot] + size[qRoot];
        }

    }

    public int root(int p) {
        while (ids[p] != p) {
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }

}
