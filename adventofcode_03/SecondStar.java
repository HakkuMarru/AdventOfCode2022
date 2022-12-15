package adventofcode_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SecondStar {

    public static void main(String[] args) {
        int sum = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\hakku\\Desktop\\input.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] strArray_1 = line.split("");
                int first_length = line.length();
                char[] first_array = new char[first_length];
                for (int i = 0; i < first_length; i++)
                    first_array[i] = line.charAt(i);
                
                line = reader.readLine();
                String[] strArray_2 = line.split("");
                char[] second_array = new char[line.length()];
                for (int i = 0; i < line.length(); i++)
                    second_array[i] = line.charAt(i);
                
                line = reader.readLine();
                String[] strArray_3 = line.split("");
                char[] third_array = new char[line.length()];
                for (int k = 0; k < line.length(); k++)
                    third_array[k] = line.charAt(k);
                
                for (int i = 0; i < first_length; i++) {
                    if (Arrays.stream(strArray_2).anyMatch(strArray_1[i]::equals) &&
                        Arrays.stream(strArray_3).anyMatch(strArray_1[i]::equals)) {
                        if ((int) first_array[i] >= 97) sum += ((int) first_array[i] - 96);
                        else sum += ((int) first_array[i] - 38);
                        break;
                    }
                }
                line = reader.readLine();
            }
            System.out.println(sum);
            reader.close();
        } catch (IOException e) {}
    }
}