import java.util.*;

class coconut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfSyllables = sc.nextInt();
        int noOfPlayers = sc.nextInt();

        List<Player> players = new LinkedList<Player>();
        for(int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(i, 1));
        }

        int index = 0;

        while (players.size() > 1){
            index = (index + noOfSyllables - 1) % players.size();

            Player player = players.get(index);

            if (player.foldedHands()) {
                player.nextState();
                Player fist = new Player(player.getPlayerNo(), 2);
                players.add(players.indexOf(player) + 1, fist);
            
            } else if (player.fist()) {
                player.nextState();
                index++;
            
            } else {
                player.nextState();
                players.remove(player);

            }
        }

        System.out.println(players.get(0).getPlayerNo() + 1);
        sc.close();
        
    }
}