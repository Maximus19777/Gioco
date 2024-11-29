public class Pozione extends Oggetto{
    private int puntiGuarigione;

    public Pozione(String nome, String categoria, String descrizione, int puntiGarigione) {
        super(nome, categoria, descrizione);
        this.puntiGuarigione = puntiGarigione;
    }

    @Override
    public String toString() {
        return "Pozione{" +
                "\npuntiGuarigione = " + puntiGuarigione +
                '}';
    }

    public int getPuntiGuarigione() {
        return puntiGuarigione;
    }

    public void setPuntiGurigione(int puntiGuarigione) {
        this.puntiGuarigione = puntiGuarigione;
    }
}
