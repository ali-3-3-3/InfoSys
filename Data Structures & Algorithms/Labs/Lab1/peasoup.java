import java.util.*;

class peasoup {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String output = " ";

        for(int i = 1; i < n; i++){
            int k = sc.nextInt();
            String restaurant_name = sc.next();
            String menu_items = " ";
            
            for(int j = 1; j < k; j++){
                String item = sc.next();
                menu_items.concat(item);
                sc.nextLine();
            }
            
            if(menu_items.contains("pea soup") && menu_items.contains("pancakes")){
                output.concat(restaurant_name + "\n");
            }
        }

        if(output.isEmpty()){
            System.out.println("Anywhere is fine I guess");
        } else {
                System.out.print(output);
        }
        sc.close();
    }
}