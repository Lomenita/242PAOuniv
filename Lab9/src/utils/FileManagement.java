package utils;

import java.io.*;
public class FileManagement {
    public static void scriereFisierChar(String fileName, String row) {

        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
             bw.write(row);
             bw.newLine();
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
