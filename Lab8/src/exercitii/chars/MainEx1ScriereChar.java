package exercitii.chars;

import exceptii.MyException;
import utils.ExceptionManagement;
import utils.FileManagement;
import java.util.Scanner;

import static utils.Constants.*;

public class MainEx1ScriereChar {
    public static void main(String[] args) {
        citireDate();
    }

    public static void citireDate() {
        Scanner scanner = new Scanner(System.in);
        while (true){
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
                String persoana = nume + SEPARATOR + prenume + SEPARATOR + varsta + SEPARATOR + suma + SEPARATOR + valuta;
                FileManagement.scriereFisierChar(FISIER_CHAR, persoana);
            }catch (MyException e){
                System.out.println(e.getMessage());
                System.out.println("Reluare citire date");
            }
            System.out.println("Adaugati persoana noua?[Y/y] ");
            String continuare =  scanner.nextLine();
            if(!continuare.equalsIgnoreCase("Y")){
                break;
            }
        }
    }
}
