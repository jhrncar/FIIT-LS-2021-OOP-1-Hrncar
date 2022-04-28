package model.pristroj;
import model.zelezna_ruda.*;

/**
 * Rozhranie každého stroja
 */
public interface Stroj {
    /**
     * Stroj sa musí zapnúť
     */
    public void zapni();

    /**
     * Stroj pracuje
     * @return Vráti poddtyp železnej rudy
     */
    public Zelezna_ruda spracuj();

    /**
     * Stroj sa musí vypnúť
     */
    public void vypni();
}
