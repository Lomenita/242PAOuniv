package exercitii.chars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.FISIER_CHAR;
import static utils.Constants.SEPARATOR;

public class MainEx1CitireChar {
    public static void main(String[] args) {
        citireFisierChar(FISIER_CHAR);
    }

    private static void citireFisierChar(String fileName){
        List<String> persoane = new ArrayList<>();

        try (FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null){
                 System.out.println(line);
                 String[] elemente = line.split(";");
                 String persoana = elemente[0] + SEPARATOR + elemente[1];
                 if(!persoane.contains(persoana)) {
                      persoane.add(persoana);
                 }else {
                      System.out.println("Multiple inregistrari pentru: " + elemente[0] + " " + elemente[1]);
                 }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

}
