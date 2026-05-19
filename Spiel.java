import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.

public class Spiel
{

    //werte die überall nutzbar sind
    public static final int BILDHOEHE = 1920;
    public static final int BILDBREITE = 1080;
    public static final int K1 = 5;
    public static final int K2 = 2;
    // Bezugsobjekte
    private View fenster;

    private schwebeDing snapper1;

    private nichtTreffenDingOben[] oben;
    private nichtTreffenDingUnten[] unten;
    //private nichtTreffenDingOben K1;
    //private nichtTreffenDingUnten K2;
    // Attribute

    // Konstruktor
    public Spiel()
    {
        fenster = new View(BILDHOEHE,BILDBREITE,"Das Fischigstegame");
        fenster.setBackgroundColor(Color.BLACK);
        oben = new nichtTreffenDingOben[K1];
        for (int i = 0; i < oben.length; i++) {
            oben[i] = new nichtTreffenDingOben(i);
        }

        /*oben[0] = new nichtTreffenDingOben();
        oben[1] = new nichtTreffenDingOben();*/

        snapper1 = new schwebeDing(oben);
        //K1 = new nichtTreffenDingOben(700,0);
        //K2= new nichtTreffenDingUnten(700,800);
        this.spielen();
    }

    // Dienste
    public void spielen(){
        boolean ende = false;
        while (!ende && !fenster.keyEnterPressed()){
            for (int i = 0; i < oben.length; i++) {
                oben[i].bewege();
            }
            for(int i = 0; i < oben.length; i++){
                if(oben[i].getShapeX() <= 0){
                    oben[i].zuruecksetzen(i);
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