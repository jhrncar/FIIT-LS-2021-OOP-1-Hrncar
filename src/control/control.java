package control;
import java.util.ArrayList;

import model.pristroj.Objednavka;
import model.zamestnanec.*;

/**
 * Prvotné nastavenia a funkcie tlačidiel
 */
public class control {

    Manazer m1 = new Manazer();
    Obsluha o1 = new Obsluha();
    Skladnik s1 = new Skladnik();
    ArrayList<Objednavka> order;

    /**
     * Udržiava databázu nespracovaných objednávok
     */
    public control(){
        this.order = new ArrayList<Objednavka>();
    }

    /**
     * Funkcionalita tlačidla "vytvor"
     * @param zelezo Počet železa, zadaný od užívateľa v GUI
     * @param ocel Počet ocele, zadaný od užívateľa v GUI
     * @param roxor Počet roxorov, zadaný od užívateľa v GUI
     * @param ocelova_tyc Počet oceľovýcg tyčí, zadaný od užívateľa v GUI
     * @param srob Počet Šróbov, zadaný od užívateľa v GUI
     * @return Vracia správu o úspešnom vytvorení objednávky
     * @throws Invalid_input Ak sú vŠetky vstupy 0, vráti error
     */
    public String vytvor(int zelezo, int ocel, int roxor, int ocelova_tyc, int srob) throws Invalid_input{
        
        if (zelezo <= 0 && ocel <= 0 && roxor <= 0 && ocelova_tyc <= 0 && srob <= 0){
            throw new Invalid_input("Vstup musi byt vacsi ako 0");
        }
        else{
            Objednavka order_lokal = m1.vytvor_objednavku(zelezo,ocel,srob,ocelova_tyc,roxor);
            order.add(order_lokal);
            return "Objednavka cislo " +order_lokal.cislo + " spracovana!\n";
        }
        
    }

    /**
     * Funkcionalita tlačidla "spracuj"
     * @return Vracia správu o úspešnom vytvorení objednávky
     * @throws Invalid_input Ak nie je žiadna objednávka v zásobníku, vráti error
     * @throws NullPointerException
     */
    public String spracuj() throws Invalid_input,NullPointerException{
        if (this.order.size() != 0) {
            Objednavka order_lokal=m1.spracuj_objednavku(o1,s1);
            if (order_lokal.zelezo == 0 && order_lokal.ocel == 0 && order_lokal.ocelova_tyc == 0 && order_lokal.roxor == 0 && order_lokal.srob == 0 ){
                m1.order.remove(order_lokal);
                order.remove(order_lokal);
                return "Objednavka cislo "+ order_lokal.cislo + " bola vybavena. Vystupna trieda je serializovana pod nazvom taska\n";
            }
            return "Objednavka nebola vybavena\n";
        }
        else{
            throw new Invalid_input("Nebola zadana ziadna objednavka");
        }
        
    }

    /**
     * Funkcionalita tlačidla "vypis", vypíše všetky objednávky v zásobníku
     * @return Vytvorený StringBuilder, v ktorom sú všetky objednávky pripravené na výpis
     */
    public String vypis(){
        StringBuilder string = new StringBuilder();
        for (Objednavka o : order){
            string.append("Caka na spracovanie: objednavka cislo "+o.cislo+" s obsahom:\nZelezo: "+o.zelezo+"\nOcel: "+o.ocel+"\nRoxor: "+o.roxor+"\nOcelova tyc: "+o.ocelova_tyc+"\nSrob: "+o.srob+"\n\n");
        }
        return string.toString();
    }

    /**
     * Funkcionalita tlačidla "posun", posunie vybranú objednávku na začiatok zásobníku
     * @param cislo Číslo objednávky
     * @return Vráti spŕavu o úspešnom posune
     * @throws NumberFormatException AK nie je spŕavny vstup, vypíše chybu
     */
    public String posun(int cislo) throws NumberFormatException{
        int index = -1;
        for(Objednavka o : order){
            if (o.cislo == cislo){
                index = order.indexOf(o);
                break;
            }
        }
        if (index != -1){
            Objednavka temp = order.get(index);
            order.remove(temp);
            m1.order.remove(temp);
            order.add(0, temp);
            m1.order.add(0,temp);
            return "Objednavka "+temp.cislo+" sa posunula na zaciatok\n";
        }
        else{
            return "Objednavka sa nenasla\n";
        }
        
    }

    
}
