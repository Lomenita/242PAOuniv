package externalizare;

import utils.FileManagement;

import java.util.Arrays;

//Externalizable curs 8
public class MainExternalizare {
    private static String fisierPersoaneExt = "listaPersoaneExternalizabile.txt";
    public static void main(String[] args) {
        PersoanaExternalizable p1 = new PersoanaExternalizable("Ene", "Stefan" , 20);
        PersoanaExternalizable p2 = new PersoanaExternalizable("Anton", "Dana" , 14);

        FileManagement.scriereObiecteInFisier(fisierPersoaneExt, p1, p2);

        Arrays.stream(FileManagement.citireObiecteDinFisier(fisierPersoaneExt)).toList().forEach(pe -> System.out.println(pe));
    }
}
