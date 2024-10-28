/**
 * @author Ali
 */

import java.util.*;
import java.io.*;

class workstations {
    public static void main(String[] args) throws IOException {
        
        //Initialise BufferedReader to take in big input numbers
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        //Input: First Line
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        //Input: Following Lines
        PriorityQueue<Researcher> researchers = new PriorityQueue<Researcher>(new 
                ResearcherComparator());

        for(int i = 0; i < n; i++) {
            String[] otherLines = br.readLine().split(" ");
            int a = Integer.parseInt(otherLines[0]);
            int s = Integer.parseInt(otherLines[1]);
            researchers.add(new Researcher(a, s));
        }


        //Initialise PriorityQueue for timing of the workstations
        PriorityQueue<Integer> workStationTimes = new PriorityQueue<Integer>();

        //Do-while loop to run through the PriorityQueue of researchers & timings
        
        int numberOfUnlocks = 0;

        do {

            //Get work station timing of the upcoming researcher
            Researcher upcomingResearcher = researchers.poll();
            workStationTimes.add(upcomingResearcher.getArrivalTime() + 
                    upcomingResearcher.getStayTime());
            
            //If the arrival time is less than the work station timing
            if(!(upcomingResearcher.getArrivalTime() < workStationTimes.peek())) {

                do {

                    //Calculate unlock timing                    
                    int unlockTime = upcomingResearcher.getArrivalTime() - 
                        workStationTimes.poll();
                    
                    //If unlock timing is less than the inactivity timing
                    if(unlockTime < m) {

                        // If the unlock timing is less than 0, add to work station timing
                        if(unlockTime < 0) {
                            workStationTimes.add(workStationTimes.poll());
                            break;

                        //If the unlock timing is bigger than 0, then add to output
                        } else {
                            numberOfUnlocks++;
                            break;
                        }
                    }

                } while(workStationTimes.isEmpty() == false);
            }

        } while(researchers.isEmpty() == false);
        
        //Print output
        System.out.println(numberOfUnlocks);
}
    }



        

