package model.zamestnanec;

import java.util.ArrayList;

import model.pristroj.Objednavka;
import model.zelezna_ruda.*;

/**
 * Skladník má za úlohy vytvoriť zoznam surovín, z ktorého sa následne budú vytvárať hotové produkty
 */
public class Skladnik {
    /**
     * Jediná metóda, v ktorej vykonáva svoju prácu
     * @param order Na základe danej objednávky pripraví suroviny.
     * Každá hodnota je rovnocenná ( teda 1 šrób sa vyrobí z 1 železa, ktor´=e sa vyrobí z 1 železnej rudy)
     * @return Vráti pripravenú dodávku surovín
     */
    public ArrayList<Zelezna_ruda> priprav(Objednavka order){
        ArrayList<Zelezna_ruda> surovina = new ArrayList<Zelezna_ruda>();

        
        for (int i = 0; i< order.ocel; i++){
            surovina.add(new Zelezna_ruda());
        }

        for (int i = 0; i< order.zelezo; i++){
            surovina.add(new Zelezna_ruda());
        }

        for (int i = 0; i< order.srob; i++){
            surovina.add(new Zelezna_ruda());
        }

        for (int i = 0; i< order.roxor; i++){
            surovina.add(new Zelezna_ruda());
        }

        for (int i = 0; i< order.ocelova_tyc; i++){
            surovina.add(new Zelezna_ruda());
        }

        return surovina;
    }

}
