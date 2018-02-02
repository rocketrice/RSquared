package Coins;

import DataHandling.BinanceAdapters.BinancePriceDataAccessor;
import Gui.GUITest;
import org.knowm.xchange.currency.Currency;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import static java.lang.System.out;

public class DataChecker {

    //CONSTANTS
    private static final double TOP_THRESHHOLD = .01;
    private static final double BOTTOM_THRESHHOLD = .1;

    //can return buy sell or hold
    public static String checkCoin(boolean potentialBuy, double prevWorth, double currWorth, double buyPrice, Currency currency){
        try {
            double value = BinancePriceDataAccessor.getValueInBTC(currency);

            //we have skin in the game
            if (buyPrice > 0){
                //if we are at threshold sell
                if ((value > buyPrice+(buyPrice*TOP_THRESHHOLD)) || (value < buyPrice*BOTTOM_THRESHHOLD)){
                    return "sell";
                }
                return "hold";
            }


            //potential buy and the price is up
            if (potentialBuy && currWorth > prevWorth){
                return "buy";
            }

            //price is down
            else if (currWorth < prevWorth){
                return "hold";
            }
        } catch (Exception e){
            out.println(e);
        }
        return "hold";
    }


}
