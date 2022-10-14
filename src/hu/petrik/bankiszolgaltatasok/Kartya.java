package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas{
    private Szamla szamla;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaszam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaszam = kartyaszam;
    }

    private String kartyaszam;

    public String getKartyaszam() {
        return kartyaszam;
    }
    public boolean vasarlas(int osszeg){
        if(szamla.aktualisEgyenleg > osszeg){
            szamla.aktualisEgyenleg-=osszeg;
            return true;
        }
        else{
            return false;
        }
    }
}
