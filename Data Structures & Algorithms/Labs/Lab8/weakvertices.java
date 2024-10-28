/*
 * @author: Ali
 */

import java.util.*;
import java.io.*;

class weakvertices {

    //Map & TreeSet
    static Map<Integer, List<Integer>> map;
    static SortedSet<Integer> bad;

    public static void main(String[] args) throws IOException {
        
        //Initialize BR
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        //Take in input n. Do not continue if n = -1
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1) {
                break;
            }
        
            //Initialize HM & TS
            map = new HashMap<>();
            bad = new TreeSet<>();

            //Take in elements based on n number
            for(int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    int element = Integer.parseInt(br.readLine());

                    //Only add the element if = 1
                    if(element == 1) {
                        list.add(j);
                    }
                }
                
                map.put(i, list);
                
                //Evaluate weakness
                boolean weakness = false;

                for(int j : map.get(i)) {
                    for(int k : map.get(j)) {
                        for(@SuppressWarnings("unused") int l : map.get(k)) {
                            if(i == 1) {
                                weakness = true;
                                break;
                            }
                        }

                        if(weakness) {
                            break;
                        }
                    }

                    if(weakness) {
                        break;
                    }
                }

                if(!weakness) {
                    bad.add(i);
                }
            }

            for(int i : bad) {
                System.out.print(i + " ");
            }

            System.out.println();

            br.close();
        }
    }
}

