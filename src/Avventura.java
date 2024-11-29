import static java.lang.System.exit;

public class Avventura {
    private Stanza[] stanze;
    private Mostro[] mostri;
    private Personaggio personaggio;
    private int nStanze;

    public Avventura(int nStanze){
        this.nStanze=nStanze;
        this.stanze=new Stanza[nStanze];
    }

    public void inizia() {
        int mostriNellaStanza = (int) (Math.random() * 10);
        mostri = new Mostro[mostriNellaStanza];
        for(int i =0;i<mostri.length;i++) {
            creazioneMostro(i);
        }
        //placeHolder nomi
        stanze[0]=new Stanza("test descrizione", mostri, mostriNellaStanza);

    }

    private void creazioneMostro(int mostroCorrente){
        int puntiVita = (int) (Math.random() * 100);
        int esperienza = (int) (Math.random() * 100);
        int forza = (int) (Math.random() * 30);
        int difesaFisica = (int) (Math.random() * 15);
        int difesaMagica =(int) (Math.random() * 15);
        int moneta = (int) (Math.random() * 1);
        String tipoAttacco;
        if(moneta==1) {
            tipoAttacco = "magico";
        }else{
            tipoAttacco = "fisico";
        }
        //placeHolder nome da fare lista di nomi math random
        mostri[mostroCorrente] = new Mostro("Varisco", puntiVita, forza, difesaFisica, difesaMagica, tipoAttacco, esperienza, creazioneOggetto());

    }

    private Oggetto creazioneOggetto(){
        Oggetto oggetto=null;
        int random = (int) (Math.random() * 3);
        switch (random){
            case 1:
                String tipoAttacco;
                int danno = (int) (Math.random() * 30);
                random = (int) (Math.random() * 1);
                if(random==1) {
                    tipoAttacco = "magico";
                }else{
                    tipoAttacco = "fisico";
                }
                //placeHolder nomi
                oggetto = new Arma("Spada di Varisco", "Variscosa", "Molto varisco", tipoAttacco, danno);

                break;
            case 2:
                String tipoDifesa;
                int difesa = (int) (Math.random() * 30);

                random = (int) (Math.random() * 1);
                if(random==1) {
                    tipoDifesa = "magico";
                }else{
                    tipoDifesa = "fisico";
                }
                //placeHolder nomi
                oggetto = new Armatura("Armatura di Varisco", "Variscosa", "Molto varisco", tipoDifesa, difesa);

                break;
            case 3:
                int puntiGuarigione = (int) (Math.random() * 30);
                //placeHolder nomi
                oggetto = new Pozione("Pozione di Varisco", "Variscosa", "Molto varisco", puntiGuarigione);

                break;
        }
        return oggetto;

    }

    public void avanzaStanza(){
        //logica per avanzare
    }
    public void indietro(){
        //logica per tornare alla stanza di prima
    }
}
