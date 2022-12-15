package adventofcode_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FirstStar {

    public static void main(String[] args) {
        int sum = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\hakku\\Desktop\\input.txt"));
            String line = reader.readLine();
            while (line != null) {
                char[] array = new char[line.length()];
                for (int i = 0; i < line.length(); i++)
                    array[i] =  line.charAt(i);
                boolean isFound = false;
                for (int i = 0; i < array.length / 2; i++) {
                    for (int j = array.length / 2; j < array.length; j++) {
                        if ((int) array[i] == (int) array[j]) {
                            if((int) array[i] >= 97) {
                                sum += ((int) array[i] - 96);
                                isFound = true;
                                break;
                            } else {
                                sum += ((int) array[i] - 38);
                                isFound = true;
                                break;
                            }
                        }
                    }
                    if (isFound) break;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
            reader.close();
        } catch (IOException e) {
        }
    }
}
