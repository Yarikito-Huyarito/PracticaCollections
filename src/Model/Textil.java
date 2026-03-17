package Model;

public class Textil extends Productes{
    private String composicioTextil;

    public Textil(String preu, String nom, String codiBares, String composicioTextil) throws Exception {
        super(preu, nom, codiBares);
        this.composicioTextil = composicioTextil;
    }

    public String getComposicioTextil() {return composicioTextil;}
    public void setComposicioTextil(String composicioTextil) {this.composicioTextil = composicioTextil;}
}
