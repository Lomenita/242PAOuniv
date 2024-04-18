package exercitii;

import serializare.model.PersoanaExercitiu;
import utils.FileManagement;

import java.util.ArrayList;
import java.util.List;

import static utils.Constants.FISIER_OCTETI;

public class MainEx2CitireOctetiVarianta2 {

    public static void main(String[] args) {

        List<PersoanaExercitiu> persoanaExercitiuList = FileManagement.citireObiecteDinFisier2(FISIER_OCTETI)
                     .stream() .map(obj -> (PersoanaExercitiu) obj) // Conversie la Persoana
                     .toList();
        System.out.println(persoanaExercitiuList);

        List<String> persoaneLista = new ArrayList<>();
        for(PersoanaExercitiu p: persoanaExercitiuList) {
            System.out.println(p);
            String persCrt = p.getNume() + ";" + p.getPrenume();
            if(persoaneLista.contains(persCrt)){
                System.out.println("Multiple inregistrari pentru " + p.getNume() + " " + p.getPrenume());
            }else{
                persoaneLista.add(persCrt);
            }
        }
    }
}
