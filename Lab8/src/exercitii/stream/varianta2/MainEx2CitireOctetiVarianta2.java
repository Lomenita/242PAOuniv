package exercitii.stream.varianta2;

import serializare.model.PersoanaExercitiu;
import utils.FileManagement;
import java.util.ArrayList;
import java.util.List;
import static utils.Constants.FISIER_OCTETI2;

public class MainEx2CitireOctetiVarianta2 {

    public static void main(String[] args) {

        Object[] objects = FileManagement.citireObiecteDinFisier(FISIER_OCTETI2);
        List<Object> list = (List<Object>) objects[0];
        List<PersoanaExercitiu> persoanaExercitiuList = list.stream().map(object -> (PersoanaExercitiu)object).toList();

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
