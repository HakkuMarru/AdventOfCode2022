package adventofcode_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FirstStar {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\hakku\\Desktop\\input.txt"));
            String line = reader.readLine();
            
            String marker = "";
            
            for (int i = 0; i < line.length(); i++) {
                boolean isRepeated = false;
                marker = line.substring(i, i + 4);
                for (int j = 0; j < 3; j++) {
                    for (int k = j+1; k < 4; k++) {
                        if (marker.charAt(j) == marker.charAt(k)) {
                            isRepeated = true;
                            break;
                        }
                    }
                    if (isRepeated) {
                        break;
                    }
                }
                if (!isRepeated) { 
                    System.out.println(i+4);
                    break;
                }
            }
            
            reader.close();
        } catch (IOException e) {
        }
    }
    
}
