import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.

public class Spiel
{

    //werte die überall nutzbar sind
    public static final int BILDHOEHE = 1920;
    public static final int BILDBREITE = 1080;
    public static final int ANZAHL_KORALLEN = 100;
    public static final int LUECKE = 200;
    public static final int ABSTAND_X = 300;
    // Bezugsobjekte
    private View fenster;

    private schwebeDing snapper1;

    private nichtTreffenDingOben[] oben;
    private nichtTreffenDingUnten[] unten;
    // Attribute

    // Konstruktor
    public Spiel()
    {
        fenster = new View(BILDHOEHE,BILDBREITE,"Das Fischigstegame");
        fenster.setBackgroundColor(Color.BLACK);

        oben = new nichtTreffenDingOben[ANZAHL_KORALLEN];
        unten = new nichtTreffenDingUnten[ANZAHL_KORALLEN];
        for (int i = 0; i < ANZAHL_KORALLEN; i++) {
            double x = BILDBREITE + i * ABSTAND_X;
            double lueckenStart = zufallsLueckeStart();
            oben[i] = new nichtTreffenDingOben(x, lueckenStart);
            unten[i] = new nichtTreffenDingUnten(x, lueckenStart + LUECKE);
        }

        snapper1 = new schwebeDing(oben, unten);
        this.spielen();
    }

    private double zufallsLueckeStart() {
        double rand = Math.random() * (BILDHOEHE - LUECKE - 200);
        return 100 + rand;
    }

    private double aktuellesMaxX() {
        double maxX = 0;
        for (int i = 0; i < oben.length; i++) {
            if (oben[i].getShapeX() > maxX) {
                maxX = oben[i].getShapeX();
            }
        }
        return maxX;
    }

    private void resetPaar(int i) {
        double x = aktuellesMaxX() + ABSTAND_X;
        double lueckenStart = zufallsLueckeStart();
        oben[i].setzePosition(x, lueckenStart);
        unten[i].setzePosition(x, lueckenStart + LUECKE);
    }

    // Dienste
    public void spielen(){
        boolean ende = false;
        while (!ende && !fenster.keyEnterPressed()){
            for (int i = 0; i < oben.length; i++) {
                oben[i].bewege();
                unten[i].bewege();
            }
            for(int i = 0; i < oben.length; i++){
                if(oben[i].getShapeX() + oben[i].getBreite() < 0){
                    resetPaar(i);
                }
            }
            if (fenster.keyUpPressed()) {
                snapper1.bewegeOben();
            }

            if (fenster.keyDownPressed()) {
                snapper1.bewegeUnten();
            }
            if (snapper1.pruefeKollision()) {
                ende = true;
            }
            fenster.wait(5);
        }
    }
}
