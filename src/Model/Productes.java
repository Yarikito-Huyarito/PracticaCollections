package Model;

public class Productes {
    protected String nom;
    protected float preu;
    protected int codiBares;

    public Productes(String preu, String nom, String codiBares) throws Exception{
        this.nom = nom;
        setPreu(preu);
        setCodiBares(codiBares);
    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public float getPreu() {return preu;}
    public void setPreu (String preu) throws Exception{
        if(!preu.trim().matches("^(?:0|[1-9]\\d*)(?:\\.\\d+)?$")){
            throw new Exception("Has introduit el preu malament");
        }
        float preuCorect = Float.parseFloat(preu);
        this.preu = preuCorect;
    }

    public int getCodiBares() {return codiBares;}
    public void setCodiBares(String codiBares) throws Exception {
        if(!codiBares.matches("^[1-9]\\d*$")){
            throw new Exception("Has introduit el codi de bares malament");
        }
        int codiBaresCorect = Integer.parseInt(codiBares);
        this.codiBares = codiBaresCorect;
    }
}
