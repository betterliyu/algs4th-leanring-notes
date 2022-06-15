package questions;

public class Successor {

    private int N;
    private int[] num;
    private boolean[] isRemove;

    public Successor(int n){
        N = n;
        num = new int[N];
        isRemove = new boolean[N];
        for(int i = 0;i < N;i++){
            num[i] = i;
            isRemove[i] = false;
        }
    }

    public int find(int i){
        while(i != num[i]){
            i = num[i];
        }
        return i;
    }

    public void remove(int index){
        isRemove[index] = true;
        if(index - 1 >= 0&&isRemove[index - 1]){
            union(index,index - 1);
        }else if(index + 1 < N&&isRemove[index + 1]){
            union(index,index + 1);
        }
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }
        if(i < j){
            num[i] = j;
        }else {
            num[j] = i;
        }
    }

    public int getSuccessor(int x){
        int num = find(x) + 1;
        if(num < N){
            return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        Successor successor = new Successor(10);
        successor.remove(3);
        System.out.println("successor: " + successor.getSuccessor(3));
        successor.remove(6);
        System.out.println("successor: " + successor.getSuccessor(6));
        successor.remove(5);
        System.out.println("successor: " + successor.getSuccessor(5));
        successor.remove(7);
        System.out.println("successor: " + successor.getSuccessor(7));
    }

}
