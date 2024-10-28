import java.util.*;

class sortofsorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 1;

        while(n > 0){
            n = sc.nextInt();
            sc.nextLine();
            String[] nameArray = new String[n];
    
            for(int i = 0; i < n; i++) {
                nameArray[i] = sc.nextLine();
            }

            int[] firstcharacter = new int[n];
            for(int i = 0; i < n; i++) {
                firstcharacter[i] = (int) nameArray[i].charAt(0);
            }

            int[] secondcharacter = new int[n];
            for(int i = 0; i < n; i++) {
                secondcharacter[i] = (int) nameArray[i].charAt(1);
            }

            for(int i = 1; i < n; i++){
                for(int j = 0; j < n - i; j++){
                    if(firstcharacter[j] > firstcharacter[j+1]) {
                        swapStr(nameArray, j);
                        swapChar(firstcharacter, j);
                        swapChar(secondcharacter, j);
                    }

                    if(firstcharacter[j] == firstcharacter[j+1]){
                        if(secondcharacter[j] > secondcharacter[j+1]){
                            swapStr(nameArray, j);
                            swapChar(firstcharacter, j);
                            swapChar(secondcharacter, j);
                        }
                    }                
                }
            }

            for(int i = 0; i < n; i++){
                System.out.println(nameArray[i]);
            }
        }

        sc.close();
    }

    public static void swapStr(String[] arr, int pos){
        String temp = arr[pos];
        arr[pos] = arr[++pos];
        arr[pos] = temp;
    }

    public static void swapChar(int[] arr, int pos){
        int temp = arr[pos];
        arr[pos] = arr[++pos];
        arr[pos] = temp;
    }
}