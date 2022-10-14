package hu.petrik.bankiszolgaltatasok;

import com.sun.source.tree.InstanceOfTree;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlalista;
    public Bank(){
        this.szamlalista = new ArrayList<>();
    }
    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        if(hitelKeret > 0){
            HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos,hitelKeret);
            szamlalista.add(hitelSzamla);
            return new HitelSzamla(tulajdonos, hitelKeret);
        }else if(hitelKeret == 0){
            MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
            szamlalista.add(megtakaritasiSzamla);
            return new MegtakaritasiSzamla(tulajdonos);
        }else{
            throw new IllegalArgumentException("A hitelkeret nme lehet negatív");
        }
    }
    public int getOsszEgyenleg(Tulajdonos tulajdonos){
        int ossz = 0;
        for (Szamla aktualis : szamlalista){
            if (aktualis.getTulajdonos() == tulajdonos){
                ossz+=aktualis.getAktualisEgyenleg();
            }
        }
        return ossz;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        Szamla legagynobb = null;
        for (Szamla aktualis : szamlalista){
            if (legagynobb == null && aktualis.getTulajdonos() == tulajdonos){
                legagynobb = aktualis;
            }
            if (aktualis.getTulajdonos() == tulajdonos){
                if(aktualis.getAktualisEgyenleg()>legagynobb.aktualisEgyenleg){
                    legagynobb = aktualis;
                }
            }
        }
        return legagynobb;
    }
    public long getOsszHitelkeret(){
    long ossz = 0;
        for (Szamla aktualis : szamlalista){
            if (szamlalista instanceof HitelSzamla){
                ossz += ((HitelSzamla) aktualis).getHitelKeret();
            }
        }
        return ossz;
    }
}
