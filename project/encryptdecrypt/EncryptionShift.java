package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class EncryptionShift implements  CodingStrategy{
    public void performing_coding(BufferedReader bufferedReader, int key, BufferedWriter bufferedWriter){
        String line;
        char startLetter;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        startLetter = (Character.isUpperCase(c)) ? 'A' : 'a';
                        bufferedWriter.append((char) (startLetter + (c - startLetter + key) % 26));
                            }  else {
                        bufferedWriter.append((char) c);
                    }
            }


        }
        } catch (IOException e) {
        e.printStackTrace(); }}}





