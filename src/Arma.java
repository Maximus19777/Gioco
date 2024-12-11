public class Arma extends Oggetto{
    private String tipoDanno; //magia o fisica
    private int danno;

    public Arma(String nome, String categoria, String descrizione, String tipoDanno, int danno) {
        super(nome, categoria, descrizione);
        this.tipoDanno = tipoDanno;
        this.danno = danno;
    }

    @Override
    public String toString() {
        return super.getNome()+" {" +
                "\ntipoDanno = '" + tipoDanno + '\'' +
                "\ndanno = " + danno +
                "\n}";
    }

    public String getTipoDanno() {
        return tipoDanno;
    }

    public void setTipoDanno(String tipoDanno) {
        this.tipoDanno = tipoDanno;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
}
