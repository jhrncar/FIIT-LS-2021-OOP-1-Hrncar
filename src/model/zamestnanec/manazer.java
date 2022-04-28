package model.zamestnanec;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import control.Invalid_input;
import model.pristroj.*;
import model.zelezna_ruda.*;

/**
 * Pravdepodobne najdôležitejšia trieda, koordinuje životný cyklus objednávky
 */
public class Manazer{
    /**
     * Udržiava zásobník objednávok
     */
    public ArrayList<Objednavka> order = new ArrayList<>();
    /**
     * Vytvára vyśtupný zoznam vytvorených tried
     */
    ArrayList<Zelezo> taska;

    /**
     * Zoberie objednávku na začiaktu zásobníka a spracuje ju, následne ju uzatvorí.
     * Musi vyhodnotiť, či sa budú použivať rýchle a presné stroje, alebo len základné modely
     * @param o1 Zamestnanec - obsluha strojov
     * @param s1 Zamestnanec - skladník
     * @return Vráteni objdnávku s vynulovanými - vybavenými - požiadavkami
     * @throws Invalid_input Ak je objednávka od začiatku prázdna, vyhodí chybu
     */
    public Objednavka spracuj_objednavku(Obsluha o1, Skladnik s1) throws Invalid_input{
        if (order.get(0).zelezo <= 0 && order.get(0).ocel <= 0 && order.get(0).roxor <= 0 && order.get(0).ocelova_tyc <= 0 && order.get(0).srob <= 0){
            throw new Invalid_input("Vstup musi byt vacsi ako 0");
        }
        
        Pec pec;
        Rezacka rezacka;
        Lis lis;
        if (order.get(0).zelezo > 100 || order.get(0).ocel > 100 ){
            pec = new Pec_rychla_zelezo();
        }
        else{
            pec = new Pec();
        }

        if (order.get(0).srob > 100){
            pec = new Pec_rychla_zelezo();//upcasting
            rezacka = new Rezacka_presna();
        }
        else{
            rezacka = new Rezacka();
        }

        if (order.get(0).ocelova_tyc > 100 || order.get(0).roxor > 100){
            lis = new Lis_presny();
            pec = new Pec_rychla_zelezo();
        }
        else{
            lis = new Lis();
        }
        ArrayList<Zelezna_ruda> surovina = s1.priprav(order.get(0));
        taska = o1.zapni_stroje(order.get(0),pec,rezacka,lis,surovina); //obsluha bude observovat 
        this.uzavri_objednavku();
        return order.get(0);
    }

    /**
     * Vytvorí objednávku na základe špecifikácie od užívateľa v GUI
     * @param zelezo Požadovaný počet z GUI
     * @param ocel Požadovaný počet z GUI
     * @param srob Požadovaný počet z GUI
     * @param ocelova_tyc Požadovaný počet z GUI
     * @param roxor Požadovaný počet z GUI
     * @return Vráti vytvorenú objednávku, pripravenú na spracovanie
     */
    public Objednavka vytvor_objednavku(int zelezo, int ocel,int srob , int ocelova_tyc, int roxor){
        Objednavka order_lokal = new Objednavka(zelezo, ocel, srob, ocelova_tyc, roxor);
        this.order.add(order_lokal);
        return order_lokal;
    }

    /**
     * Cez RTTI skontroluje, či je objednávka vybavená a ak je, tak to serialujem a odovzdám uživateľovi
     */
    public void uzavri_objednavku(){ //cez RTTI spocita a uzavrie

        for (Zelezo tovar : taska) {
            if (order.get(0).zelezo != 0 && tovar instanceof Zelezo){
                order.get(0).zelezo--;
            }
            if (order.get(0).ocel != 0 && tovar instanceof Ocel){
                order.get(0).ocel--;
            }
            if (order.get(0).ocelova_tyc != 0 && tovar instanceof Ocelova_tyc){
                order.get(0).ocelova_tyc--;
            }
            if (order.get(0).roxor != 0 && tovar instanceof Roxor){
                order.get(0).roxor--;
            }
            if (order.get(0).srob != 0 && tovar instanceof Srob){
                order.get(0).srob--;
            }
        }

        if (order.get(0).zelezo == 0 && order.get(0).ocel == 0 && order.get(0).ocelova_tyc == 0 && order.get(0).roxor == 0 && order.get(0).srob == 0){
            try{ //taska sa serialuzuje na konci, aby ju program mohol posunut do ineho programu na spracovanie
                FileOutputStream fos = new FileOutputStream("taska");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(taska);
                oos.close();
                fos.close();
            }
            catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}