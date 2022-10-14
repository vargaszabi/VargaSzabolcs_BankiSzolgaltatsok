package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla{
    private double kamat;

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public double getKamat() {
        return kamat;
    }

    public static double alapKamat = 1.1;
    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat=alapKamat;
    }

    public void kamatJovairas(){
        aktualisEgyenleg*=alapKamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if(aktualisEgyenleg<osszeg){
            return false;
        }
        else{
            aktualisEgyenleg-=osszeg;
            return true;
        }
    }
}
