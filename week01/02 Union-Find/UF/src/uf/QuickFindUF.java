package uf;

/**
 * 快速查找
 */

public class QuickFindUF extends UF {

    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }


    @Override
    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                ids[i] = qid;
            }
        }
    }
}
