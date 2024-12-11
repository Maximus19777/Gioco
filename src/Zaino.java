public class Zaino {
    protected Equipaggiamento[] equipaggiamenti;
    private Pozione[] pozioni;

    public Zaino() {
        this.equipaggiamenti = new Equipaggiamento[2];
        this.pozioni = new Pozione[5];  // Inizializza un array di pozioni con una dimensione appropriata
    }

    public Equipaggiamento[] getEquipaggiamenti() {
        return equipaggiamenti;
    }

    public void setEquipaggiamenti(Equipaggiamento[] equipaggiamenti) {
        this.equipaggiamenti = equipaggiamenti;
    }

    public Pozione[] getPozioni() {
        return pozioni;
    }

    public void setPozioni(Pozione[] pozioni) {
        this.pozioni = pozioni;
    }

    public static class Equipaggiamento {
        private Arma arma;
        private Armatura armatura;

        public Equipaggiamento(Arma arma, Armatura armatura) {
            this.arma = arma;
            this.armatura = armatura;
        }

        public Arma getArma() {
            return arma;
        }

        public void setArma(Arma arma) {
            this.arma = arma;
        }

        public Armatura getArmatura() {
            return armatura;
        }

        public void setArmatura(Armatura armatura) {
            this.armatura = armatura;
        }
    }
}
