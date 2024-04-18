package exercitii.stream.secvential;

import exceptii.MyException;
import serializare.model.PersoanaExercitiu;
import utils.ExceptionManagement;
import utils.FileManagement;
import java.util.Scanner;
import static utils.Constants.FISIER_OCTETI_SECVENTIAL;


/*
ObjectOutputStream se va inchide si deschide la fiecare persoana noua
ObjectOutputStream are un header. Va fi copiat cu AppendableObjectOutputStream
 */
public class MainEx2ScriereOctetiSecvential {
    public static void main(String[] args) {
        citireDate();
    }

    private static void citireDate(){
        Scanner scanner = new Scanner(System.in);
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
                    PersoanaExercitiu persoanaCurenta = new PersoanaExercitiu(nume, prenume, varsta, suma, valuta);

                    FileManagement.scriereObiecteInFisierSecvential(FISIER_OCTETI_SECVENTIAL, persoanaCurenta);

                } catch (MyException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Reluare citire date");
                }
                System.out.println("Adaugati persoana noua?[Y/y] ");
                String continuare = scanner.nextLine();
                if (!continuare.equalsIgnoreCase("Y")) {
                    break;
                }
            }

    }
}
