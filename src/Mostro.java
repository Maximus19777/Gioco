public class Mostro extends Entita{
    private String tipoAttacco; //magia o fisico
    private int esperienza;
    private Oggetto bottino; //oggetto casuale

    public Mostro(String nome, int puntiVita, int forza, int difesaFisica, int difesaMagica, String tipoAttacco, int esperienza, Oggetto bottino) {
        super(nome, puntiVita, forza, difesaFisica, difesaMagica);
        this.tipoAttacco = tipoAttacco;
        this.esperienza = esperienza;
        this.bottino = bottino;
    }

    @Override
    public void attaccare(Entita target) {
        target.subireDanni(super.getForza(), tipoAttacco);
    }
    @Override
    public void subireDanni(int danniSubiti, String tipoAttacco){
        if(tipoAttacco=="fisico") {
            danniSubiti=danniSubiti-super.getDifesaFisica();
            int newPuntiVita = super.getPuntiVita() - danniSubiti;
            super.setPuntiVita(newPuntiVita);
        }else{ //magico
            danniSubiti=danniSubiti-super.getDifesaMagica();
            int newPuntiVita = super.getPuntiVita() - danniSubiti;
        }

    }

    @Override
    public String toString() {
        return "Mostro{" +
                "\ntipoAttacco = " + tipoAttacco + '\'' +
                "\nesperienza = " + esperienza +
                "\nbottino = " + bottino.toString() +
                '}';
    }

    public String getTipoAttacco() {
        return tipoAttacco;
    }

    public void setTipoAttacco(String tipoAttacco) {
        this.tipoAttacco = tipoAttacco;
    }

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

    public Oggetto getBottino() {
        return bottino;
    }

    public void setBottino(Oggetto bottino) {
        this.bottino = bottino;
    }


}
