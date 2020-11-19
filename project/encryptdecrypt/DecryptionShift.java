package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DecryptionShift implements  CodingStrategy{
    public void performing_coding(BufferedReader bufferedReader, int key, BufferedWriter bufferedWriter){
        String line;
        char endLetter;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        endLetter = (Character.isUpperCase(c)) ? 'Z' : 'z';
                        bufferedWriter.append((char) (endLetter - (endLetter - c + key) % 26));
                    }  else {
                        bufferedWriter.append((char) c);
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace(); }}}





