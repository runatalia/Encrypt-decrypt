package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class EncryptionUnicode implements CodingStrategy{
    public void performing_coding(BufferedReader bufferedReader, int key, BufferedWriter bufferedWriter){
        {

            String line;
            try {
            while ((line = bufferedReader.readLine()) != null) {
                for (char c : line.toCharArray()) {

                        bufferedWriter.append((char) (c + key));
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }}}}
