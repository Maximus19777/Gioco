import java.util.Scanner;

import static java.lang.System.exit;

public class Avventura {
    private Stanza[] stanze;
    private Personaggio personaggio;
    private int numeroStanze;
    private Scanner sc = new Scanner(System.in);

    // Array di nomi per generare un nome casuale per le armi
    private static final String[] NOMI_ARMI = {"Excalibur", "Spada di Fuoco", "Spada di Ghiaccio", "Spada della Luce", "Spada dell'Oscurità"};

    public Avventura(int numeroStanze) {
        this.numeroStanze = numeroStanze;
        this.stanze = new Stanza[numeroStanze];
    }

    public void inizia() {

        // Creazione del personaggio
        personaggio = new Personaggio("Dhort", 100, 20, 10, 5, 1, 0);

        // Assegna un'arma iniziale al personaggio
        Arma armaIniziale = createRandomWeapon();

        // Aggiungi l'arma al primo equipaggiamento dello zaino (senza armatura)
        Zaino.Equipaggiamento equipaggiamentoIniziale = new Zaino.Equipaggiamento(armaIniziale, null);
        personaggio.getZaino().setEquipaggiamenti(new Zaino.Equipaggiamento[]{equipaggiamentoIniziale, null}); // Imposta l'equipaggiamento

        for (int i = 0; i < numeroStanze; i++) {
            int livelloStanza = i + 1;
            stanze[i] = creaStanza(livelloStanza);
        }

        int stanzaCorrente = 0;
        while (stanzaCorrente < numeroStanze) {
            Stanza stanza = stanze[stanzaCorrente];
            System.out.println("Sei nella stanza: " + stanza.getDescrizione());
            if (stanza.getMostri().length > 0) {
                combattimento(stanza);
            } else {
                System.out.println("Non ci sono mostri in questa stanza.");
            }

            System.out.println("Vuoi avanzare alla stanza successiva? (S/N)");
            String scelta = sc.nextLine();
            if (scelta.equalsIgnoreCase("S")) {
                stanzaCorrente++;
            } else {
                System.out.println(ConsoleColors.RESET+"\n[Torna indietro.]\n"+ConsoleColors.YELLOW_BOLD);
                stanzaCorrente = Math.max(stanzaCorrente - 1, 0);
            }
        }
        System.out.println("Hai completato l'avventura!");
    }

    private Stanza creaStanza(int livelloStanza) {
        Mostro[] mostri = new Mostro[livelloStanza];
        for (int i = 0; i < livelloStanza; i++) {
            mostri[i] = creaMostro(livelloStanza);
        }

        String descrizione = "Stanza di livello " + livelloStanza;
        return new Stanza(descrizione, mostri, mostri.length);
    }

    private Mostro creaMostro(int livelloStanza) {
        String nomeMostro = "Mostro Livello " + livelloStanza;
        int puntiVita = 10 + (int) (Math.random() * 10);
        int forza = 5 + (int) (Math.random() * 10);
        int difesaFisica = 2 + (int) (Math.random() * 5);
        int difesaMagica = 2 + (int) (Math.random() * 5);
        String tipoAttacco = Math.random() > 0.5 ? "fisico" : "magico";
        int esperienza = 10 * livelloStanza;
        Oggetto bottino = creaOggetto();

        return new Mostro(nomeMostro, puntiVita, forza, difesaFisica, difesaMagica, tipoAttacco, esperienza, bottino);
    }

    // Metodo per creare un oggetto (arma, armatura, pozione)
    private Oggetto creaOggetto() {
        int tipoOggetto = (int) (Math.random() * 3);
        switch (tipoOggetto) {
            case 0:
                return createRandomWeapon();  // Crea un'arma casuale
            case 1:
                return new Armatura("Armatura Magica", "Protezione", "Armatura resistente", "magico", 15);
            case 2:
                return new Pozione("Pozione Curativa", "Curativo", "Ripristina 30 punti vita", 30);
            default:
                return null;
        }
    }

    // Metodo per creare un'arma casuale con nome e danno
    private Arma createRandomWeapon() {
        String nomeArma = NOMI_ARMI[(int) (Math.random() * NOMI_ARMI.length)];  // Seleziona un nome casuale
        int danno = 10 + (int) (Math.random() * 15);  // Danno casuale tra 10 e 25
        return new Arma(nomeArma, "Taglio", "Spada potente", "fisico", danno);  // Crea un'arma
    }

    private void combattimento(Stanza stanza) {
        for (Mostro mostro : stanza.getMostri()) {
            System.out.println("Inizia combattimento con: " + mostro.getNome()+"\n");
            while (personaggio.getPuntiVita() > 0 && mostro.getPuntiVita() > 0) {

                System.out.println(ConsoleColors.BLUE_BOLD+"TURNO GIOCATORE"+ConsoleColors.YELLOW_BOLD+"\nVita attuale("+personaggio.getPuntiVita()+")\nCosa vuoi fare? (1) Attacca (2) Usa Pozione");
                int scelta = sc.nextInt();
                sc.nextLine();

                if (scelta == 1) {
                    personaggio.attaccare(mostro);
                    if (mostro.getPuntiVita() > 0) {
                        System.out.println(ConsoleColors.RED_BRIGHT+"TURNO MOSTRO"+ConsoleColors.YELLOW_BOLD);
                        mostro.attaccare(personaggio);
                    }
                } else if (scelta == 2) {
                    usaPozione();
                    if (mostro.getPuntiVita() > 0) {
                        System.out.println(ConsoleColors.RED_BRIGHT+"TURNO MOSTRO"+ConsoleColors.YELLOW_BOLD);
                        mostro.attaccare(personaggio);
                    }
                }

                if (personaggio.getPuntiVita() <= 0) {
                    System.out.println(ConsoleColors.RED+"Sei stato sconfitto!");
                    exit(0);
                }
            }

            if (mostro.getPuntiVita() <= 0) {
                System.out.println(ConsoleColors.GREEN+"Mostro sconfitto!"+ConsoleColors.YELLOW_BOLD);
                personaggio.setEsperienza(personaggio.getEsperienza() + mostro.getEsperienza());
                System.out.println("Hai guadagnato " + mostro.getEsperienza() + " punti esperienza.");
                if (Math.random() < 0.5) {
                    System.out.println("Il mostro ha lasciato un bottino!");
                    // Aggiungi il bottino nello zaino del personaggio
                    Oggetto bottino = mostro.getBottino();
                    if (bottino != null) {
                        aggiungiBottinoNelloZaino(bottino);
                    }
                }
            }
        }
    }

    public void aggiungiBottinoNelloZaino(Oggetto bottino) {
        if (bottino instanceof Arma) {
            // Aggiungi l'arma nello zaino
            Arma arma = (Arma) bottino;
            Zaino.Equipaggiamento[] equipaggiamenti = personaggio.getZaino().getEquipaggiamenti();

            int numArmi = 0;
            for (Zaino.Equipaggiamento equip : equipaggiamenti) {
                if (equip != null && equip.getArma() != null) {
                    numArmi++;
                }
            }

            if (numArmi < 2) {  // Controllo se ci sono già 2 armi
                boolean aggiunto = false;
                for (int i = 0; i < equipaggiamenti.length; i++) {
                    if (equipaggiamenti[i] == null) {
                        equipaggiamenti[i] = new Zaino.Equipaggiamento(arma, null);
                        aggiunto = true;
                        break;
                    }
                }

                if (aggiunto) {
                    System.out.println("Hai trovato un'arma: " + arma.getNome() + ". È stata aggiunta al tuo zaino.");
                }
            } else {
                System.out.println("Il tuo zaino è pieno, non puoi aggiungere l'arma: " + arma.getNome());
            }
        } else if (bottino instanceof Armatura) {
            // Aggiungi l'armatura nello zaino
            Armatura armatura = (Armatura) bottino;
            Zaino.Equipaggiamento[] equipaggiamenti = personaggio.getZaino().getEquipaggiamenti();

            int numArmature = 0;
            for (Zaino.Equipaggiamento equip : equipaggiamenti) {
                if (equip != null && equip.getArmatura() != null) {
                    numArmature++;
                }
            }

            if (numArmature < 2) {  // Controllo se ci sono già 2 armature
                boolean aggiunto = false;
                for (int i = 0; i < equipaggiamenti.length; i++) {
                    if (equipaggiamenti[i] == null) {
                        equipaggiamenti[i] = new Zaino.Equipaggiamento(null, armatura);
                        aggiunto = true;
                        break;
                    }
                }

                if (aggiunto) {
                    System.out.println("Hai trovato un'armatura: " + armatura.getNome() + ". È stata aggiunta al tuo zaino.");
                }
            } else {
                System.out.println("Il tuo zaino è pieno, non puoi aggiungere l'armatura: " + armatura.getNome());
            }
        }
        // (gestione delle pozioni rimane invariata)
    }



    private void usaPozione() {
        Pozione[] pozioni = personaggio.getZaino().getPozioni();
        System.out.println("Scegli una pozione:");
        for (int i = 0; i < pozioni.length; i++) {
            if (pozioni[i] != null) {
                System.out.println((i + 1) + ") " + pozioni[i].toString());
            }
        }
        int scelta = sc.nextInt();
        sc.nextLine();

        if (scelta > 0 && scelta <= pozioni.length && pozioni[scelta - 1] != null) {
            Pozione pozione = pozioni[scelta - 1];
            personaggio.setPuntiVita(personaggio.getPuntiVita() + pozione.getPuntiGuarigione());
            if(personaggio.getPuntiVita()>100){
                personaggio.setPuntiVita(100);
            }
            pozioni[scelta - 1] = null;
            System.out.println("Hai usato " + pozione.getNome() + " e hai guadagnato " + pozione.getPuntiGuarigione() + " punti vita.");
        } else {
            System.out.println("Pozione non disponibile.");
        }
    }
}
