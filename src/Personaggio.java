import java.util.Arrays;
import java.util.Scanner;
public class Personaggio extends Entita {
    private int livello, esperienza;
    private Arma[] armi;
    private Armatura[] armature;
    private Pozione[] pozioni;

    private Scanner sc = new Scanner(System.in);

    public Personaggio(String nome, int puntiVita, int forza, int difesaFisica, int difesaMagica, int livello, int esperienza, Arma[] armi, Armatura[] armature, Pozione[] pozioni) {
        super(nome, puntiVita, forza, difesaFisica, difesaMagica);
        this.livello = livello;
        this.esperienza = esperienza;
        this.armi = armi;
        this.armature = armature;
        this.pozioni = pozioni;
    }


    @Override
    public void attaccare(Entita target) {
        System.out.println("Scegliere arma:\n");
        for (int i = 0; i < armi.length; i++) {
            int j = i + 1;
            System.out.println(j + ")\n" + armi[i].toString());
        }
        int scelta = sc.nextInt();
        scelta = scelta + 1;
        if (scelta > 0 && scelta < armi.length) {
            target.subireDanni(armi[scelta].getDanno(), armi[scelta].getTipoDanno());
        } else {
            System.out.println("Non esiste quell'arma");
        }
    }

    @Override
    public void subireDanni(int danniSubiti, String tipoAttacco) {
        if (tipoAttacco == "fisico") {
            if(armature[0].getTipoDifesa()=="fisico") {
                danniSubiti = (danniSubiti - getDifesaFisica()) - armature[0].getDifesa();
            }else{
                danniSubiti = danniSubiti - getDifesaFisica();
            }
            int newPuntiVita = danniSubiti;
            super.setPuntiVita(newPuntiVita);
        } else {//magia
            if(armature[0].getTipoDifesa()=="magia") {
                danniSubiti = (danniSubiti - getDifesaMagica()) - armature[0].getDifesa();
            }else{
                danniSubiti = danniSubiti - getDifesaMagica();
            }
            int newPuntiVita = danniSubiti;
            super.setPuntiVita(newPuntiVita);

        }

    }

    @Override
    public String toString() {
        return "Personaggio{" +
                "\nlivello = " + livello +
                "\nesperienza = " + esperienza +
                "\narmi = " + Arrays.toString(armi) +
                "\narmature = " + Arrays.toString(armature) +
                "\npozioni = " + Arrays.toString(pozioni) +
                '}';
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

    public Arma[] getArmi() {
        return armi;
    }

    public void setArmi(Arma[] armi) {
        this.armi = armi;
    }

    public Armatura[] getArmature() {
        return armature;
    }

    public void setArmature(Armatura[] armature) {
        this.armature = armature;
    }

    public Pozione[] getPozioni() {
        return pozioni;
    }

    public void setPozioni(Pozione[] pozioni) {
        this.pozioni = pozioni;
    }
}