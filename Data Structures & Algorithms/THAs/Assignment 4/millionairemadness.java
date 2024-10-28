/**
 * @author Ali
 */
import java.io.*;
import java.util.*;

public class millionairemadness {
    public static void main(String[] args) throws IOException {
        //Initialize Kattio scanner
        Kattio io = new Kattio(System.in, System.out);
        
        //Input: m & n
        int m = io.getInt();
        int n = io.getInt();

        //Initialize grid
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        //Input: Grid values
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = io.getInt();
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        //Inialize PQ
        PriorityQueue<Pair> pq = new 
        PriorityQueue<Pair>(new PairComparator());

        //Start adding into PQ
        pq.add(new Pair(0, 0, grid[0][0], 0));
        visited[0][0] = true;
        int result = 0;

        //Iterate through PQ
        while(!pq.isEmpty() && !visited[m -1][n - 1]) {
            Pair now = pq.poll();
            visited[now.x][now.y] = true;
            result = Math.max(now.difference, result);

            for(int i = 0; i < 4; i++) {
                int nextX = now.x + directions[i][0];
                int nextY = now.y + directions[i][1];
                if (nextX > -1 && nextY > -1 && nextX < m && nextY < n && !visited[nextX][nextY]) {
                    int nextHeight = grid[nextX][nextY];
                    int nextDifference = nextHeight - now.height;
                    Pair next = new Pair(nextX, nextY, nextHeight, nextDifference);
                    pq.add(next);
                }
            }
        }

        //Output: Print
        io.println(Integer.toString(result));
        io.close();
    }
}

class Pair {
    int x;
    int y;
    int height;
    int difference;

    Pair(int x, int y, int height, int difference) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.difference = difference;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        int weightDiff = p1.difference - p2.difference;
        return weightDiff;
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

