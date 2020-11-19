package encryptdecrypt;

import java.io.*;

public class Coding {
    private String mode;
    private String alg;
    private int key;
    private String data;
    private File input_path;
    private File output_path;
    Coding(String mode, String alg, int key, String data, File input_path, File output_path){
        this.mode = mode;
        this.alg = alg;
        this.key = key;
        this.data = data;
        this.input_path = input_path;
        this.output_path = output_path;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public File getInput_path() {
        return input_path;
    }

    public void setInput_path(File input_path) {
        this.input_path = input_path;
    }

    public File getOutput_path() {
        return output_path;
    }

    public void setOutput_path(File output_path) {
        this.output_path = output_path;
    }

    void switchMode(){

        try (BufferedReader bufferedReader = new BufferedReader(input_path != null && data.equals("") ? new FileReader(input_path) :
                new StringReader(data));                   // если файл существует и нет ввода с консоли,то создаем объект FileReader для объекта
                                                           // input_path, иначе объект StringReader
             BufferedWriter bufferedWriter = new BufferedWriter(output_path != null ? new FileWriter(output_path) :
                     new OutputStreamWriter(System.out)); // если файл для вывода существует,то создаем объект FileWriter для объекта File,
                                                          // иначе OutputStreamWriter для дальнейшего вывода в консоль
        ) {

            if ("enc".equals(mode) && "unicode".equals(alg)) {
                CodingStrategy encryptionUnicode = new EncryptionUnicode();
                encryptionUnicode.performing_coding(bufferedReader, key, bufferedWriter);
            } else if ("enc".equals(mode) && "shift".equals(alg)) {
                CodingStrategy encryptionShift = new EncryptionShift();
                encryptionShift.performing_coding(bufferedReader, key, bufferedWriter);
            } else if ("dec".equals(mode) && "unicode".equals(alg)) {
                CodingStrategy decryptionUncode = new DecryptionUnicode();
                decryptionUncode.performing_coding(bufferedReader, key, bufferedWriter);
            } else if ("dec".equals(mode) && "shift".equals(alg)) {
                CodingStrategy decryptionShift = new DecryptionShift();
                decryptionShift.performing_coding(bufferedReader, key, bufferedWriter);
            }  else System.out.println("ERROR");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


