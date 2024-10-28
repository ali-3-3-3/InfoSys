/*
 * @author Nur Aliya Bte Mohd Wari A0264656U
 */

import java.io.*;

class joinstrings {
    public static void main(String[] args) throws IOException {

        //Initializing BufferedReader
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
        //Input: Number of Strings
        String firstline = br.readLine();
        int n = Integer.parseInt(firstline);
        
        //Initializing Tailed Linked Lists
        TailedLinkedList[] listOfArrays = new TailedLinkedList[n + 1];

        for(int i = 1; i < n + 1; i++) {

            //Input: Strings
            TailedLinkedList strings = new TailedLinkedList();
            strings.addBack(br.readLine());
            listOfArrays[i] = strings;
        }

        //Iterating through the strings using a & b inputs
        
        int index = 1;

        for(int i = 1; i < n; i++) {
            
            //Input: a & b
            String[] abLines = br.readLine().split(" ");
            int a = Integer.parseInt(abLines[0]);
            int b = Integer.parseInt(abLines[1]);

            //Iteration
            listOfArrays[a].addList(listOfArrays[b]);
            index = a;
        }

        //Output
        listOfArrays[index].print();

        //Close BufferedReader
        br.close();
            

    }

}   
