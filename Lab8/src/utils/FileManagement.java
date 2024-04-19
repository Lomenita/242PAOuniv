package utils;

import exercitii.stream.secvential.AppendableObjectOutputStream;
import serializare.model.PersoanaExercitiu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.FISIER_OCTETI1;
import static utils.Constants.SEPARATOR;

public class FileManagement {

    //metoda cu numar variabil de argumente. Vor fi transmise ca un Tablou
    //dupa tipul obiectului se pun 3 puncte
    public static void scriereObiecteInFisier(String outputFile, Object... obj) {
        try(FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //citire sub forma de tablou
    public static Object[] citireObiecteDinFisier(String fileName) {
        Object[] o;
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            o = (Object[]) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return o;
    }


    public static void scriereFisierChar(String fileName, String pers) {

        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw)) {
             bw.write(pers);
             bw.newLine();
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

    /*
    ObjectOutputStream se va inchide si deschide la fiecare persoana noua
    ObjectOutputStream are un header. Va fi copiat cu AppendableObjectOutputStream
    */
    public static void scriereObiecteInFisierSecvential(String outputFile, Object obj) {
        File file = new File(outputFile);
        boolean append = file.exists();
        try(FileOutputStream fos = new FileOutputStream(outputFile, append);
            AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, append);){
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void citireFisier(String fileName){
        List<String> persoane = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream reader = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    PersoanaExercitiu persoana = (PersoanaExercitiu) reader.readObject();
                    String pers = persoana.getNume() + SEPARATOR + persoana.getPrenume();
                    if (persoane.contains(pers)) {
                        System.out.println("Multiple inregistrari pentru " + persoana.getNume() + " " + persoana.getPrenume());
                    }else{
                        persoane.add(pers);
                    }
                    System.out.println(persoana);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
