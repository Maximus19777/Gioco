import java.util.Scanner;

public class Personaggio extends Entita {
    private int livello, esperienza;
    private Zaino zaino = new Zaino();
    private Scanner sc = new Scanner(System.in);

    public Personaggio(String nome, int puntiVita, int forza, int difesaFisica, int difesaMagica, int livello, int esperienza) {
        super(nome, puntiVita, forza, difesaFisica, difesaMagica);
        this.livello = livello;
        this.esperienza = esperienza;
    }

    @Override
    public void attaccare(Entita target) {
        System.out.println("Scegliere arma:\n"+ConsoleColors.RESET);

        Zaino.Equipaggiamento[] equipaggiamenti = zaino.getEquipaggiamenti();
        for (int i = 0; i < equipaggiamenti.length; i++) {
            int j = i + 1;
            if (equipaggiamenti[i] != null && equipaggiamenti[i].getArma() != null) {
                System.out.println(j + ") " + equipaggiamenti[i].getArma().getNome());
            }
        }

        int scelta = sc.nextInt();
        scelta = scelta - 1;
        if (scelta >= 0 && scelta < equipaggiamenti.length && equipaggiamenti[scelta] != null && equipaggiamenti[scelta].getArma() != null) {
            Arma armaScelta = equipaggiamenti[scelta].getArma();
            int dannoInflitto = armaScelta.getDanno();
            System.out.println(ConsoleColors.GREEN+"Hai inflitto " + dannoInflitto+ConsoleColors.YELLOW_BOLD);
            target.subireDanni(dannoInflitto, armaScelta.getTipoDanno());
        } else {
            System.out.println(ConsoleColors.RED_BRIGHT+"Non esiste quell'arma"+ConsoleColors.YELLOW_BOLD);
        }
    }

    @Override
    public void subireDanni(int danniSubiti, String tipoAttacco) {
        Zaino.Equipaggiamento[] equipaggiamenti = zaino.getEquipaggiamenti();
        if (equipaggiamenti[0] != null) {
            Armatura armatura = equipaggiamenti[0].getArmatura();
            int danniDopoDifesa = danniSubiti;

            if (armatura != null) {
                if (tipoAttacco.equals("fisico")) {
                    if (armatura.getTipoDifesa().equals("fisico")) {
                        danniDopoDifesa = (danniSubiti - getDifesaFisica()) - armatura.getDifesa();
                    } else {
                        danniDopoDifesa = danniSubiti - getDifesaFisica();
                    }
                } else {
                    if (armatura.getTipoDifesa().equals("magia")) {
                        danniDopoDifesa = (danniSubiti - getDifesaMagica()) - armatura.getDifesa();
                    } else {
                        danniDopoDifesa = danniSubiti - getDifesaMagica();
                    }
                }
            } else {
                if (tipoAttacco.equals("fisico")) {
                    danniDopoDifesa = danniSubiti - getDifesaFisica();
                } else {
                    danniDopoDifesa = danniSubiti - getDifesaMagica();
                }
            }

            System.out.println(ConsoleColors.RED+"Hai subito " + danniDopoDifesa+ConsoleColors.YELLOW_BOLD);
            super.setPuntiVita(super.getPuntiVita()-danniDopoDifesa);
        } else {
            System.out.println("Equipaggiamento mancante, impossibile calcolare danni.");
        }
    }

    @Override
    public String toString() {
        Zaino.Equipaggiamento[] equipaggiamenti = zaino.getEquipaggiamenti();
        String armiString = "";
        String armatureString = "";

        for (Zaino.Equipaggiamento equip : equipaggiamenti) {
            if (equip != null) {
                if (equip.getArma() != null) {
                    armiString += equip.getArma().toString() + "\n";
                }
                if (equip.getArmatura() != null) {
                    armatureString += equip.getArmatura().toString() + "\n";
                }
            }
        }

        return "Personaggio{" +
                "\nlivello = " + livello +
                "\nesperienza = " + esperienza +
                "\narmi = " + armiString +
                "\narmature = " + armatureString +
                "\nzaino.getPozioni() = " + zaino.getPozioni() +
                '}';
    }

    public Zaino getZaino() {
        return zaino;
    }

    public void setZaino(Zaino zaino) {
        this.zaino = zaino;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }
}
