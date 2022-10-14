package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{
    public int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (hitelKeret+aktualisEgyenleg<osszeg){
            return false;
        }
        else {
            aktualisEgyenleg-=osszeg;
            return true;
        }
    }
}
