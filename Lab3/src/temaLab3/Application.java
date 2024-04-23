package temaLab3;

import temaLab3.service.BibliotecaService;
import temaLab3.service.PersonService;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        PersonService personService = new PersonService();

        BibliotecaService bibliotecaService = new BibliotecaService();

        while (true){ //acesta va rula la infinit pana apare comanda return (care iese din metoda main)
                      // sau break in main
            menu();

            String command = scanner.nextLine().toLowerCase();
            System.out.println("Command received: " + command);
            switch (command){
                case "create":
                    personService.create(scanner);
                    break;
                case "read":
                    personService.read(scanner);
                    break;
                case "delete":
                    personService.delete(scanner);
                    break;
                case "update":
                    personService.update(scanner);
                    break;
                case "quit":
                    System.out.println("Exiting");
                    return; // acesta va opri programul; va iesi din metoda main
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    private static void menu() {
        System.out.println("Available commands:");
        System.out.println("create");
        System.out.println("read");
        System.out.println("update");
        System.out.println("delete");
        System.out.println("quit");
        System.out.println("Enter command:");
    }
}