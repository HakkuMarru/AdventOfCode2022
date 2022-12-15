package adventofcode_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SecondStar {
    
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\hakku\\Desktop\\input.txt"));
            String line = reader.readLine();
            int finCounter = 0;
            while (line != null) {
                boolean contains = true;
                int firstNum, secondNum, thirdNum, fourthNum, counter = 0;
                String string = "";
                char[] char_array = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    char_array[i] = line.charAt(i);
                }

                for (; char_array[counter] != '-'; counter++) {
                    string += char_array[counter];
                }
                firstNum = Integer.parseInt(string);
                string = "";
                counter++;

                for (; char_array[counter] != ','; counter++) {
                    string += char_array[counter];
                }
                secondNum = Integer.parseInt(string);
                string = "";
                counter++;

                for (; char_array[counter] != '-'; counter++) {
                    string += char_array[counter];
                }
                thirdNum = Integer.parseInt(string);
                string = "";
                counter++;

                for (; counter < char_array.length; counter++) {
                    string += char_array[counter];
                }
                fourthNum = Integer.parseInt(string);

                int[] firstArray = new int[secondNum - firstNum + 1];
                String[] firstString = new String[secondNum - firstNum + 1];
                for (int i = firstNum, j = 0; i <= secondNum; i++, j++) {
                    firstArray[j] = i;
                    firstString[j] = Integer.toString(i);
                }

                int[] secondArray = new int[fourthNum - thirdNum + 1];
                String[] secondString = new String[fourthNum - thirdNum + 1];
                for (int i = thirdNum, j = 0; i <= fourthNum; i++, j++) {
                    secondArray[j] = i;
                    secondString[j] = Integer.toString(i);
                }

                if (firstArray.length <= secondArray.length) {
                    for (int i = 0; i < firstArray.length; i++) {
                        if (Arrays.stream(secondString).anyMatch(firstString[i]::equals)) {
                            contains = false;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < secondArray.length; i++) {
                        if (Arrays.stream(firstString).anyMatch(secondString[i]::equals)) {
                            contains = false;
                            break;
                        }
                    }
                }
                if (!contains)
                    finCounter++;

                line = reader.readLine();
            }
            System.out.println(finCounter);
            reader.close();
        } catch (IOException e) {
        }
    } 
}
