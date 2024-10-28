/**
 * @author Ali
 */

import java.io.*;
import java.util.*;

class kattissquest {
    public static void main(String[] args) throws IOException {

        //Initialise BufferedReader & PrintWriter

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Initialise TreeMap
        TreeMap<Long, PriorityQueue<Long>> map = new TreeMap<Long, PriorityQueue<Long>>();

        //Take in input n
        Long n = Long.parseLong(br.readLine());

        //Take in n inputs of commands
        for(int i = 0; i < n; i++) {
            String otherLines[] = br.readLine().split(" ");
            String command = otherLines[0];

            //When the command is add: Take in input e & g
            if(command.equals("add")) {
                Long e = Long.parseLong(otherLines[1]);
                Long g = Long.parseLong(otherLines[2]);
                
                //If the TreeMap includes e as a key, add g
                if(map.containsKey(e)) {
                    map.get(e).add(g);
                
                //If not, create new PQ with g, add it to TreeMap
                } else {
                    PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
                    pq.add(g);
                    map.put(e, pq);
                }
            
            //When the command is query: Take in input x
            } else {
                Long x = Long.parseLong(otherLines[1]);
                Long goldEarned = 0L;
                
                //If the TreeMap isn't empty
                if(map.isEmpty() == false) {
                    
                    //Do, while x is greater than/equal to the 1st key, and x is greater than/equal to 0
                    do {

                        /* Get key from greatest value of TreeMap less than or equal to x
                         * Make pq from key
                         * poll() the pq to add to gold earned
                         */
                        Long key = map.floorKey(x);
                        PriorityQueue<Long> pq = map.get(key);
                        goldEarned += pq.poll();
                        
                        //If the pq is empty, remove the key from TreeMap.
                        if(pq.isEmpty()) {
                            map.remove(key);

                        //Else, insert new mapping of the key and pq into TreeMap 
                        } else {
                            map.put(key, pq);
                        }

                        //Minus the key value from x
                        x -= key;

                        //Break from while loop when the TreeMap is empty
                        if(map.isEmpty()) {
                            break;
                        }

                    } while(x >= map.firstKey() && x >= 0);
                }

                //Print goldEarned
                pw.write(goldEarned.toString() + "\n");
            }
        }
        
        br.close();
        pw.close();

   }
}
                    

                                 

