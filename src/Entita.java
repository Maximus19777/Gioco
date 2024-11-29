public abstract class Entita {
    private String nome;
    private int puntiVita, forza, difesaFisica, difesaMagica;

    public Entita(String nome, int puntiVita, int forza, int difesaFisica, int difesaMagica){
        this.nome=nome;
        this.puntiVita=puntiVita;
        this.forza=forza;
        this.difesaFisica=difesaFisica;
        this.difesaMagica=difesaMagica;
    }

    public abstract void attaccare(Entita target);
    public abstract void subireDanni(int danniSubiti, String tipoAttacco);

    @Override
    public String toString() {
        return "Entita{" +
                "\nnome = '" + nome + '\'' +
                "\npuntiVita = " + puntiVita +
                "\nforza = " + forza +
                "\ndifesaFisica = " + difesaFisica +
                "\ndifesaMagica = " + difesaMagica +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getDifesaFisica() {
        return difesaFisica;
    }

    public void setDifesaFisica(int difesaFisica) {
        this.difesaFisica = difesaFisica;
    }

    public int getDifesaMagica() {
        return difesaMagica;
    }

    public void setDifesaMagica(int difesaMagica) {
        this.difesaMagica = difesaMagica;
    }
}
