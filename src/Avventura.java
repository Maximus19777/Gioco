import static java.lang.System.exit;

public class Avventura {
    private Stanza[] stanze;
    private Personaggio personaggio;
    private int nStanze;

    public Avventura(int nStanze){
        this.nStanze=nStanze;
        this.stanze=new Stanza[nStanze];
    }

    public void inizia(){
        System.out.println("Logica inizia");
        exit(-1); //perché non c'è niente mo
        //logica per iniziare
    }

    public void avanzaStanza(){
        //logica per avanzare
    }
    public void indietro(){
        //logica per tornare alla stanza di prima
    }
}
