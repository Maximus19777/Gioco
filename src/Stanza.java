public class Stanza {
    private String descrizione;
    private Mostro[] mostri;
    int mostriNellaStanza;

    public Stanza(String descrizione, Mostro[] mostri, int mostriNellaStanza) {
        this.descrizione = descrizione;
        this.mostri = mostri;
        this.mostriNellaStanza=mostriNellaStanza;
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "\ndescrizione = '" + descrizione + '\'' +
                "\nmostri Nella Stanza = " + mostriNellaStanza +
                '}';
    }

    public void aggiungiMostro(Mostro mostro){
        mostri[mostriNellaStanza-1]= mostro;
        mostriNellaStanza++;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Mostro[] getMostri() {
        return mostri;
    }

    public void setMostri(Mostro[] mostri) {
        this.mostri = mostri;
    }

    public int getMostriNellaStanza() {
        return mostriNellaStanza;
    }

    public void setMostriNellaStanza(int mostriNellaStanza) {
        this.mostriNellaStanza = mostriNellaStanza;
    }
}
