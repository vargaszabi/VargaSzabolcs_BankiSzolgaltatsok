package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{
    public int hitelKeret;

    public int getHitelKeret() {
        return hitelKeret;
    }

    public HitelSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
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
