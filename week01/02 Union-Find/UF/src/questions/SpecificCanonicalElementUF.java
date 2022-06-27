package questions;




public class SpecificCanonicalElementUF {
    protected int[] size = null;

    protected int[] ids;

    public SpecificCanonicalElementUF(int n) {
        ids = new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }


    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
           return;
        } else if (pRoot > qRoot) {
            ids[qRoot] = pRoot;
        } else {
            ids[pRoot] = qRoot;
        }

    }

    public int root(int p) {
        while (ids[p] != p) {
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }

    public int find(int p) {
        return root(p);
    }

}
