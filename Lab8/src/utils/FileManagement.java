package utils;

import java.io.*;
import java.util.List;

public class FileManagement {

    //metoda cu numar variabil de argumente. Vor fi transmise ca un Array
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

    //citire cu ObjectInputStream a unor obiecte scrise sub forma de List
    public static List<Object> citireObiecteDinFisier2(String fileName) {
        List<Object> o ;
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            o = (List<Object>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    //scriere cu ObjectOutputStream a unor obiecte sub forma de List
    public static void scriereObiecteInFisier2(String outputFile, Object... obj) {
        try(FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Object o : obj) {
                oos.writeObject(o);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
