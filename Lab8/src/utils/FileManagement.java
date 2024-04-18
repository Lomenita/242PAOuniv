package utils;

import java.io.*;

public class FileManagement {

    //metoda cu numar variabil de argumente. Vor fi transmise ca un Array
    //dupa tipul obiectului se pun 3 puncte
    public static void scriereObiecteInFisier(String outputFile, Object... obj) {
        try(FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
            oos.flush();
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
}
