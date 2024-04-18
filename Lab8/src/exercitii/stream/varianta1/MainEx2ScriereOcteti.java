package exercitii.stream.varianta1;

import exceptii.MyException;
import serializare.model.PersoanaExercitiu;
import utils.ExceptionManagement;
import java.io.*;
import java.util.Scanner;
import static utils.Constants.FISIER_OCTETI1;

public class MainEx2ScriereOcteti {
    public static void main(String[] args) {
        citireDate();
    }

    private static void citireDate(){
        Scanner scanner = new Scanner(System.in);

        try(
             FileOutputStream fos = new FileOutputStream(FISIER_OCTETI1, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            while (true) {
                System.out.println("Introduceti nume: ");
                String nume = scanner.nextLine();

                System.out.println("Introduceti prenume: ");
                String prenume = scanner.nextLine();

                System.out.println("Introduceti varsta: ");
                int varsta = scanner.nextInt();

                System.out.println("Introduceti suma: ");
                float suma = scanner.nextFloat();
                scanner.nextLine();
                try {
                    ExceptionManagement.verificareSuma(suma);
                    System.out.println("Introduceti valuta: ");
                    String valuta = scanner.nextLine();
                    PersoanaExercitiu persoanaExercitiu = new PersoanaExercitiu(nume, prenume, varsta, suma, valuta);

                    oos.writeObject(persoanaExercitiu);

                } catch (MyException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Reluare citire date");
                }
                System.out.println("Adaugati persoana noua?[Y/y] ");
                String continuare = scanner.nextLine();
                if (!continuare.equalsIgnoreCase("Y")) {
                    oos.flush();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
