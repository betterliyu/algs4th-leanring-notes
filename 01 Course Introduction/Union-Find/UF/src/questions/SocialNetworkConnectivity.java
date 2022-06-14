package questions;

import uf.PathCompressionQuickUnionUF;

import java.util.Date;

public class SocialNetworkConnectivity {

    static Date getEarliestDate(String[] users, MemberPairs[] pairs) {
        int size = users.length;
        PathCompressionQuickUnionUF uf = new PathCompressionQuickUnionUF(users.length);
        for (int i = 0; i < pairs.length; i++) {
            if (!uf.connected(pairs[i].userA, pairs[i].userB)) {
                uf.union(pairs[i].userA, pairs[i].userB);
                size--;
            }
            if (size == 1) {
                return pairs[i].date;
            }
        }
        return null;
    }


    protected class MemberPairs {
        public int userA;
        public int userB;

        /**
         * connected date
         */
        public Date date;
    }
}
