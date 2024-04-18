package serializare;

import serializare.model.Nod;
import serializare.model.Persoana;
import utils.FileManagement;

import java.util.Arrays;

public class MainSerializare {

    private static String fisierPersoane = "listaPersoaneSerializable.txt";
    private static String listaSerie = "listaSerie.txt";

    public static void main(String[] args) {

        serializareDemo();

        //Lista circulara Curs 8
        Nod prim = serializareListaCirculara();
        FileManagement.scriereObiecteInFisier(listaSerie, prim);
        Object[] prim2 = FileManagement.citireObiecteDinFisier(listaSerie);
        if(prim2.length == 1) {
            afisareSerieNodCitita((Nod) prim2[0]);
        }
    }

    private static void serializareDemo() {

        Persoana p1 = new Persoana("Pop", "Ioan" , 20);
        Persoana p2 = new Persoana("Preda", "Maria" , 14);

        FileManagement.scriereObiecteInFisier(fisierPersoane, p1, p2);
        Arrays.stream(FileManagement.citireObiecteDinFisier(fisierPersoane)).toList().forEach(p -> System.out.println(p));
    }

    private static Nod serializareListaCirculara() {
        Nod prim = null, ultim = null;

        for(int i = 1 ; i <= 10 ; i++){
            Nod aux = new Nod(i);
            if(prim == null){
                prim = ultim = aux;
            }else{
                ultim.setNext(aux);
                ultim = aux;
            }
        }
        ultim.setNext(prim);

        System.out.println("Lista care va fi serializata:");
        Nod aux = prim;
        do{
            System.out.println(aux.getData() + " ");
            aux = aux.getNext();
        }while (aux != prim);
        return prim;
    }

    private static void afisareSerieNodCitita(Nod prim) {
        System.out.println("Lista deserializata: ");

        Nod aux = prim;
        do{
            System.out.println(aux.getData() + " ");
            aux = aux.getNext();
        }while (aux != prim);
    }

}