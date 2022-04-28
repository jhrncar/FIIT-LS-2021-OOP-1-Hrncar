package model.zamestnanec;

import java.util.ArrayList;
import model.pristroj.*;
import model.zelezna_ruda.*;

/**
 * Obsluha má na starosti prácu so strojmi, ich udržiavanie a opeŕacie s nimi
 */
public class Obsluha {
    /**
     * Agregovaná pec
     */
    private Pec pec;
    /**
     * Agregovaná rezačka
     */
    private Rezacka rezacka;
    /**
     * Agregovaný lis
     */
    private Lis lis;
    /**
     * Pripravená výstupná "taška"
     */
    ArrayList<Zelezo> taska = new ArrayList<Zelezo>();

    /**
     * Hlavná metóda na vytváranie jednotlivých produktov, vykonáva výrobné procesy pre jednotlivé produkty
     * @param order Objednávka, podľa ktorej obsluha pracuje
     * @param pec Pec, ktorú bude obsluha použivať
     * @param rezacka Rezačka, ktorú bude obsluha použivať
     * @param lis Lis, ktorú bude obsluha použivať
     * @param surovina Suroviny, z ktorých sa budú vytvárať produkty
     * @return Vráti hotovú výstupnú "tašku"
     */
    public ArrayList<Zelezo> zapni_stroje(Objednavka order, Pec pec, Rezacka rezacka,Lis lis,ArrayList<Zelezna_ruda> surovina){
        this.pec = pec;
        this.rezacka = rezacka;
        this.lis = lis;
    
        if (order.zelezo != 0){
            
            this.pec.zapni();
            
            for (int i = 0; i< order.zelezo; i++){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                this.pec.vloz_rudu(surovina.get(0));
                taska.add(this.pec.spracuj());
                surovina.remove(0);
            }

            this.pec.vypni();
        }
        if (order.ocel != 0){
            this.pec.zapni();
            ArrayList<Zelezo> temp = new ArrayList<Zelezo>();
            for (int i = 0; i< order.ocel; i++){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                this.pec.vloz_rudu(surovina.get(0));
                temp.add(this.pec.spracuj());
                surovina.remove(0);
            }
            this.pec.vypni();

            if (order.ocel > 100){
                pec = new Pec_rychla_ocel();//upcasting
            }
            else{
                pec = new Pec_ocel();//upcasting
            }
            this.pec = pec;

            this.pec.zapni();

            for (Zelezo z : temp){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                if (((Pec_ocel) this.pec).getUhlik() == 0){
                    ((Pec_ocel) pec).dopln_uhlik();
                }
                this.pec.vloz_rudu(z);
                taska.add(this.pec.spracuj());
            }
            temp = null;

            this.pec.vypni();

            
        }
        if (order.ocelova_tyc != 0){
            ArrayList<Zelezo> temp = new ArrayList<Zelezo>();
            this.pec.zapni();
            for (int i = 0; i< order.ocelova_tyc; i++){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                this.pec.vloz_rudu(surovina.get(0));
                temp.add(this.pec.spracuj());
                surovina.remove(0);
            }
            this.pec.vypni();

            ArrayList<Zelezo> temp2 = new ArrayList<Zelezo>();
            if (order.ocelova_tyc > 100){
                pec = new Pec_rychla_ocel();//upcasting
            }
            else{
                pec = new Pec_ocel();//upcasting
            }
            this.pec = pec;

            for (Zelezo z : temp){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                if (((Pec_ocel) this.pec).getUhlik() == 0){ //trochu useless upcasting
                    ((Pec_ocel) pec).dopln_uhlik();
                }
                this.pec.vloz_rudu(z);
                temp2.add(this.pec.spracuj());
            }
            temp = null;

            this.pec.vypni();

            int i = 0;
            while (i < order.ocelova_tyc){
                if (this.lis.power){
                    this.lis.vloz(temp2.get(0));
                    temp2.remove(0);
                    taska.add(this.lis.spracuj_ocel());
                    i++;
                }
                else{
                    this.lis.zapni();
                }
            }
            
        }
        if (order.roxor != 0){
            ArrayList<Zelezo> temp = new ArrayList<Zelezo>();
            this.pec.zapni();
            for (int i = 0; i< order.roxor; i++){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                this.pec.vloz_rudu(surovina.get(0));
                temp.add(this.pec.spracuj());
                surovina.remove(0);
            }
            this.pec.vypni();

            int i = 0;
            while (i < order.roxor){
                if (this.lis.power){
                    this.lis.vloz(temp.get(0));
                    temp.remove(0);
                    taska.add(this.lis.spracuj_zelezo());
                    i++;
                }
                else{
                    this.lis.zapni();
                }
            }
            
        }
        if (order.srob != 0){
            ArrayList<Zelezo> temp = new ArrayList<Zelezo>();
            this.pec.zapni();
            for (int i = 0; i< order.srob; i++){
                if (this.pec.getTeplo() <= 4){
                    this.pec.zapni();
                }
                this.pec.vloz_rudu(surovina.get(0));
                temp.add(this.pec.spracuj());
                surovina.remove(0);
            }
            this.pec.vypni();
            
            int i = 0;
            while (i < order.srob){
                if (this.rezacka.power){
                    this.rezacka.vloz(temp.get(0));
                    temp.remove(0);
                    taska.add(this.rezacka.spracuj());
                    i++;
                }
                else{
                    this.rezacka.zapni();
                }
            }
        }

        
        return taska;
    }

}
