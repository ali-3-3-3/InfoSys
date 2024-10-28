/**
 * @author Ali
 */
import java.io.*;
import java.util.*;

public class lostmap {
    public static void main(String[] args) throws IOException {
        
        //Initialize Kattio scanner
        Kattio io = new Kattio(System.in, System.out);

        //Input: n size of grid
        int n = io.getInt();

        //Input: Grid values
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = io.getInt();
            }
        }

        //Initialize EdgeList
        ArrayList<Edge> EL = new ArrayList<Edge>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                EL.add(new Edge(i, j, grid[i][j]));
            }
        }

        //Sort Edgelist
        Collections.sort(EL);

        //Initialize UFDS
        UFDS ufds = new UFDS(n);

        //Iterate through the edgeList
        for (Edge edge : EL) {
            int i = edge.u;
            int j = edge.v;
            
            if (!ufds.isSameSet(i, j)) {
                ufds.unionSet(i, j);
                i++;
                j++;
                io.print(String.format("%d %d\n", i, j));
            }
        }
        
        io.close();
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.w - other.w;
    }
}

class UFDS {
    int[] parent;

    UFDS(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findSet(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = findSet(parent[i]);
            return parent[i];
        }
    }
    
    boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    void unionSet(int i , int j) {
        if (!isSameSet(i, j)) {
            parent[findSet(j)] = findSet(i);
        }
    }
}

/** Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) {
 *    int n = io.getInt();
 *    double d = io.getDouble();
 *    double ans = d*n;
 *
 *    io.println("Answer: " + ans);
 * }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an
 *   exception if there is no more data in the input, so it is generally
 *   a good idea to use hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */
 
class Kattio extends PrintWriter {
     public Kattio(InputStream i) {
     super(new BufferedOutputStream(System.out));
     r = new BufferedReader(new InputStreamReader(i));
     }
     public Kattio(InputStream i, OutputStream o) {
     super(new BufferedOutputStream(o));
     r = new BufferedReader(new InputStreamReader(i));
     }
 
     public boolean hasMoreTokens() {
     return peekToken() != null;
     }
 
     public int getInt() {
     return Integer.parseInt(nextToken());
     }
 
     public double getDouble() { 
     return Double.parseDouble(nextToken());
     }
 
     public long getLong() {
     return Long.parseLong(nextToken());
     }
 
     public String getWord() {
     return nextToken();
     }
 
 
 
     private BufferedReader r;
     private String line;
     private StringTokenizer st;
     private String token;
 
     private String peekToken() {
     if (token == null) 
         try {
         while (st == null || !st.hasMoreTokens()) {
             line = r.readLine();
             if (line == null) return null;
             st = new StringTokenizer(line);
         }
         token = st.nextToken();
         } catch (IOException e) { }
     return token;
     }
 
     private String nextToken() {
     String ans = peekToken();
     token = null;
     return ans;
     }
 }