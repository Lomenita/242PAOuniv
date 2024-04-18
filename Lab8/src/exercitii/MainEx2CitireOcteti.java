package exercitii;

import serializare.model.PersoanaExercitiu;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.FISIER_OCTETI;
import static utils.Constants.SEPARATOR;

public class MainEx2CitireOcteti {

    public static void main(String[] args) {
        citireFisier();
    }

    private static void citireFisier(){
        List<String> persoane = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FISIER_OCTETI);
             ObjectInputStream reader = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    PersoanaExercitiu o = (PersoanaExercitiu) reader.readObject();
                    String pers = o.getNume() + SEPARATOR + o.getPrenume();
                    if (persoane.contains(pers)) {
                        System.out.println("Multiple inregistrari pentru " + o.getNume() + " " + o.getPrenume());
                    }else{
                        persoane.add(pers);
                    }
                    System.out.println(o);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
