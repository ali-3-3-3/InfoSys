/*
 * @author Ali
 */

import java.io.*;

//Main class
class almostunionfind {
    public static void main(String[] args) throws IOException {

        //Initialize scanner
        Kattio io = new Kattio(System.in, System.out);
        
        //Input n & m
        while (io.hasMoreTokens()) {
            int n = io.getInt();
            int m = io.getInt();
            
            //Initialize UFDS data structure
            UFDS ufds = new UFDS(n);
            
            //Take in p & q depending on operation
            int i = 0;
            while(i < m) {
                int operation = io.getInt();
                int p;
                int q;

                switch(operation) {
                    case 1:
                        p = io.getInt();
                        q = io.getInt();
                        if (!ufds.isSameSet(p, q)) {
                            ufds.unionSet(p, q);
                        }

                    case 2:
                        p = io.getInt();
                        q = io.getInt();
                        if (!ufds.isSameSet(p, q)) {
                            ufds.moveSet(p, q);
                        }

                    case 3:
                        p = io.getInt();
                        int noOfElements = ufds.noOfElements(p);
                        long sumOfElements = ufds.sumOfElements(p);

                        //Print number of elements and the sum of elementd
                        io.write(noOfElements + " " + sumOfElements + "\n");
                }

                i++;
            }
        }

        //Close scanner
        io.close();
    }
}

//UFDS Data Structure
class UFDS {
    int[] parent;
    int[] next;
    int[] count;
    long[] sum;

    //Constructor
    UFDS(int n) {
        this.parent = new int[n + 1];
        this.next = new int[n + 1];
        this.count = new int[n + 1];
        this.sum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i + 1] = i + 1;
            next[i + 1] = i + 1;
            count[i + 1] = 1;
            sum[i + 1] = i + 1;
        }

    }

    int findSet(int p) {
        int nextParent = next[p];
        while (nextParent != parent[nextParent]) {
            nextParent = parent[nextParent];
        }
        
        next[p] = nextParent;
        return nextParent;
    }

    boolean isSameSet(int p, int q) {
        return findSet(p) == findSet(q);
    }

    int noOfElements(int p) {
        return count[findSet(p)];
    }

    long sumOfElements(int p) {
        return sum[findSet(p)];
    }

    void unionSet(int p, int q) {
        int x = findSet(p);
        int y = findSet(q);
        parent[x] = y;
        next[p] = y;
        count[y] += count[x];
        sum[y] += sum[x];
    }

    //Move p to the set containing q
    void moveSet(int p, int q) {
        int x = findSet(p);
        int y = findSet(q);

        next[p] = y;

        count[x] -= 1;
        count[y] += 1;

        sum[x] -= p;
        sum[y] += p;
    }

}
