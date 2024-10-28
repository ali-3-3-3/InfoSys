/**
 * @author Ali
 */
import java.io.*;
import java.util.*;

public class dominos {
    public static void main(String[] args) throws IOException {
        
        //Initialize Kattio scanner
        Kattio io = new Kattio(System.in, System.out);
        
        //Input: Number of Cases
        int cases = io.getInt();

        for(int i = 0; i < cases; i++) {

            //Input: m & n for every Case
            int n = io.getInt();
            int m = io.getInt();

            ArrayList<LinkedList<Integer>> AL = new ArrayList<LinkedList<Integer>>();
            
            //Add n number into AL
            for(int j = 0; j < n; j ++) {
                AL.add(new LinkedList<Integer>());
            }
 
            //Input: x & y for every Case
            for(int j = 0; j < m; j++) {
                int x = io.getInt();
                int y = io.getInt();

                AL.get(x - 1).add(y - 1);
            }

            Graph graph = new Graph(AL);

            //Count the number of isolated SCC
            Pair<Integer, int[]> kosarajuResult = graph.kosaraju();
            int nSCC = kosarajuResult.first;
            int[] parent = kosarajuResult.second;
            int result = 0;
            boolean[] checked = new boolean[nSCC + 1];
            for(int k = 0; k < graph.V; k++) {
                LinkedList<Integer> iAdj = graph.AL.get(i);
                for (int v : iAdj) {
                    if (parent[i] != parent[v]) {
                        if (!checked[parent[v]]) {
                            checked[parent[v]] = true;
                            result++; 
                        }
                    }
                }
            }

            int output = nSCC - result;
            io.println(output);
        }

        io.close();
    }
}

class Pair<X, Y> {
    X first;
    Y second;

    Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}

class Graph {
    int V;
    ArrayList<LinkedList<Integer>> AL;

    Graph(ArrayList<LinkedList<Integer>> AL) {
        this.V = AL.size();
        this.AL = AL;
    }

    void updateStack(int u, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[u] = true;

        LinkedList<Integer> uAdj = this.AL.get(u);
        for (int v : uAdj) {
            if (!visited[v]) {
                updateStack(v, visited, stack);
            }
        }
        stack.push(u);
    }

    int[] DFS(int u, boolean[] visited, int[] parent, int nextID) {
        visited[u] = true;
        parent[u] = nextID;

        LinkedList<Integer> uAdj = this.AL.get(u);
        for (int v : uAdj) {
            if (!visited[v]) {
                DFS(v, visited, parent, nextID);
            }
        }
        return parent;
    }

    Graph transpose() {
        ArrayList<LinkedList<Integer>> transposedAL = new ArrayList<LinkedList<Integer>>();
        
        for (int i = 0; i < this.V; i++) {
            transposedAL.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < this.V; i++) {
            for (int j : this.AL.get(i)) {
                transposedAL.get(j).add(i);
            }
        }
        return new Graph(transposedAL);
    }

    Pair<Integer, int[]> kosaraju() {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited1 = new boolean[this.V];
        int[] parent = new int[this.V];

        for (int i = 0; i < this.V; i++) {
            if (!visited1[i]) {
                updateStack(i, visited1, stack);
            }
        }

        Graph transpose = this.transpose();
        boolean[] visited2 = new boolean[this.V];
        int nextID = 0;


        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited2[u]) {
                nextID ++;
                transpose.DFS(u, visited2, parent, nextID);
            }
        }
        return new Pair<Integer, int[]>(nextID, parent);
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