package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


public class Alimentacio extends Productes {
    private float preuAlimentacio;
    private LocalDate dataCaducitat;

    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public Alimentacio(String preu, String nom, String codiBares, float preuAlimentacio, String dataCaducitat) throws Exception {
        super(preu, nom, codiBares);
        LocalDate dataActual = LocalDate.now();
        this.preuAlimentacio = calcularPreu(dataActual);
        setDataCaducitat(dataCaducitat);
    }

    public float getPreuAlimentacio() { return preuAlimentacio; }
    public void setPreuAlimentacio(int preuAlimentacio) { this.preuAlimentacio = preuAlimentacio; }

    public LocalDate getDataCaducitat() { return dataCaducitat; }
    public void setDataCaducitat(String dataCaducitat) throws Exception {
        if (dataCaducitat == null) throw new Exception("Data null");
        String s = dataCaducitat.trim();
        if (!s.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            throw new Exception("Format incorrecte (dd/MM/aaaa): " + dataCaducitat);
        }
        try {
            this.dataCaducitat = LocalDate.parse(s, F); // aquí valida también fechas reales (STRICT)
        } catch (DateTimeParseException e) {
            throw new Exception("Data inexistent: " + dataCaducitat, e);
        }
    }
    public float calcularPreu(LocalDate dataActual) throws Exception {
        long dies = ChronoUnit.DAYS.between(dataActual, this.dataCaducitat);
        if (dies < 0) throw new Exception("Producte caducat");
        float preuBase = super.getPreu();
        return (float) (preuBase - preuBase * (1.0 / (dies + 1)) + (preuBase * 0.1));
    }
}
