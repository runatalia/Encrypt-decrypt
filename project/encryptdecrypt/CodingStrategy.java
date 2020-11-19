package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public interface CodingStrategy {
    void performing_coding(BufferedReader bufferedReader, int key, BufferedWriter bufferedWriter) throws IOException;
}
