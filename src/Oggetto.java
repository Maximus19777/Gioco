public class Oggetto {
    private String nome, categoria, descrizione;

    public Oggetto(String nome, String categoria, String descrizione) {
        this.nome = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Oggetto{" +
                "\nnome = '" + nome + '\'' +
                "\ncategoria = '" + categoria + '\'' +
                "\ndescrizione = '" + descrizione + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
