package serializare.model;

import java.io.Serializable;

public class PersoanaExercitiu implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nume;
    private String prenume;
    private int varsta;

    private float suma;
    private String valuta;
    public PersoanaExercitiu(String nume, String prenume, int varsta, float suma, String valuta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.suma = suma;
        this.valuta = valuta;
    }

    @Override
    public String toString() {
        return "PersoanaExercitiu{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", suma=" + suma +
                ", valuta='" + valuta + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }
}
