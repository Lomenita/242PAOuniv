package exercitii.stream.varianta2;

import exceptii.MyException;
import serializare.model.PersoanaExercitiu;
import utils.ExceptionManagement;
import utils.FileManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static utils.Constants.FISIER_OCTETI2;

/*
scrierea in forma de ArrayList - vezi persoanaExercitiuList
In FileManagement.scriereObiecteInFisier2(FISIER_OCTETI, persoanaExercitiuList);
persoanaExercitiuList este List, deci tot in acelasi format va fi citit in MainEx2CitireOcteti2
 */
public class MainEx2ScriereOctetiVarianta2 {
    public static void main(String[] args) {
        citireDate();
    }

    private static void citireDate(){
        Scanner scanner = new Scanner(System.in);

        List<PersoanaExercitiu> persoanaExercitiuList = new ArrayList<>();
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

                    persoanaExercitiuList.add(persoanaExercitiu);

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
           //persoanaExercitiuList este List, deci cand va fi citit va fi tot cu List
           FileManagement.scriereObiecteInFisier(FISIER_OCTETI2, persoanaExercitiuList);
        }


}
