package temaLab3.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

public class FileManagement {
    public static void scriereFisierChar(String fileName, String row) {

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
             bw.write(row);
             bw.write(";");
             bw.write(System.currentTimeMillis() + "" );
             bw.newLine();
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
