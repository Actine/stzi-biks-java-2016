package lecture2.encapsulation;

/**
 * Created by Actine on 17.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Kassa privatBankNaPetefi = new Kassa();

        int myHryvnias = 1000;
        int myDollars = 0;

        myDollars += privatBankNaPetefi.buyDollars(myHryvnias);
        myHryvnias = 0;

        System.out.println(String.format(
                "У мене є %d дол, %d грн; у банку є %d дол, %d грн",
                myDollars, myHryvnias,
                privatBankNaPetefi.getDollars(), privatBankNaPetefi.getHryvnias()
        ));

        Kassa privatNaKoriatci = new Kassa(1000, 4000);
        System.out.println(String.format(
                "у касі на Корятці є %d дол, %d грн",
                privatNaKoriatci.getDollars(), privatNaKoriatci.getHryvnias()
        ));

    }

}

class Kassa {
    private int hryvnias;
    private int dollars;

    private int kurs = 27;

    private boolean isOpen;

    public Kassa() {
        hryvnias = 3000;
        dollars = 200;
        isOpen = true;
    }
    
    public Kassa(int initialHryvnias, int initialDollars) {
        hryvnias = initialHryvnias;
        dollars = initialDollars;
        isOpen = true;
    }

    /**
     *
     * @param hryvniasToExchange
     * @return bought dollars
     */
    int buyDollars(int hryvniasToExchange) {
        if (!isOpen) {
            throw new IllegalArgumentException("Каса зараз закрита");
        }

        int dollarsToBuy = hryvniasToExchange / kurs;
        if (dollarsToBuy > dollars) {
            throw new IllegalArgumentException(String.format(
                    "У касі бракує доларів. Ви хочете купити %d, а наявно %d",
                    dollarsToBuy, dollars
            ));
        } else {
            hryvnias += hryvniasToExchange;
            dollars -= dollarsToBuy;
            return dollarsToBuy;
        }
    }

    public int getHryvnias() {
        return hryvnias;
    }

    public int getDollars() {
        return dollars;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
