public class Armatura extends Oggetto{
    private String tipoDifesa; //magia o fisica
    private int difesa;

    public Armatura(String nome, String categoria, String descrizione, String tipoDifesa, int difesa) {
        super(nome, categoria, descrizione);
        this.tipoDifesa = tipoDifesa;
        this.difesa = difesa;
    }

    @Override
    public String toString() {
        return "Armatura{" +
                "\ntipoDifesa = '" + tipoDifesa + '\'' +
                "\ndifesa = " + difesa +
                '}';
    }

    public String getTipoDifesa() {
        return tipoDifesa;
    }

    public void setTipoDifesa(String tipoDifesa) {
        this.tipoDifesa = tipoDifesa;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }
}
