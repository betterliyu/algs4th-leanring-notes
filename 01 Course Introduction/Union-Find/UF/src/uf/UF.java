package uf;

public abstract class UF {
    protected int[] ids;

    public UF(int n) {
        ids = new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }

    public abstract boolean connected(int p, int q);

    public abstract void union(int p, int q);

}