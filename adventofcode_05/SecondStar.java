package adventofcode_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecondStar {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\hakku\\Desktop\\input.txt"));
            String line = reader.readLine();
            
            String[] stack = {"BQC", "RQWZ", "BMRLV", "CZHVTW", "DZHBNVG",
                              "HNPCJFVQ", "DGTRWZS", "CGMNBWZP", "NJBMWQFP"};
            
            while (line != null) {
                String strQuantity = "";
                
                line = line.replaceAll("[^0-9]", " ");
                line = line.trim().replaceAll(" +", " ");
                
                for (int i = 0; line.charAt(i) != ' '; i++)
                    strQuantity += line.charAt(i);
                
                
                int quantity = Integer.valueOf(strQuantity);
                int start = (line.charAt(line.length()-3)-'0') - 1;
                int end = (line.charAt(line.length()-1)-'0') - 1;
                
                stack[end] += stack[start].substring(stack[start].length() - quantity);
                stack[start] = stack[start].substring(0, stack[start].length() - quantity);
                
                line = reader.readLine();
            }
            for (int i = 0; i < stack.length; i++) {
                    System.out.print(stack[i].charAt(stack[i].length()-1));
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
        }
    }
}

