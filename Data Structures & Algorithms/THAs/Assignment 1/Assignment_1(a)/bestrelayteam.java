import java.util.*;

class bestrelayteam {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Runner> runners = new ArrayList<>(n);
        String[] fastestTeam = new String[4];

        //Input for Runners
        for(int i = 0; i < n; i++){
            String name = sc.next();
            double firstLeg = sc.nextDouble();
            double otherLeg = sc.nextDouble();
            runners.add(new Runner(name, firstLeg, otherLeg));
        }

        Collections.sort(runners);
        double fastestTime = 99999999;

        //Iterating through variations of teams
        for(int i = 0; i < n; i++){
            double time = runners.get(i).firstLeg;

            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    time += runners.get(j).otherLeg;
                    count++;
                }

                if(count == 3){
                    break;
                }
            }

            //Store best time
            if(time < fastestTime){
                fastestTime = time;
                fastestTeam[0] = runners.get(i).name;
                count = 1;
                for(int j = 0; j < n; j++){
                    if(i != j){
                        fastestTeam[count] = runners.get(j).name;
                        count++;
                    }
                    
                    if(count == 4){
                        break;
                    }
                }
                
            }
        }

        //Print
        System.out.println(fastestTime);
        for(int k = 0; k < fastestTeam.length; k++){
                System.out.println(fastestTeam[k]);
        }

        sc.close();
    }
}
