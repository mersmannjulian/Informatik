import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.

public class schwebeDing
{
    // Bezugsobjekte
    private Picture snapperBild;
    private Picture Backfisch;
    private nichtTreffenDingOben[] dieHindernisse;
    // Attribute
    //private boolean aktiv;
    // Konstruktor
    public  schwebeDing(nichtTreffenDingOben[] pK1)
    {
        snapperBild = new Picture(500 , 500,"snapper.png");
        Backfisch = new Picture(0,-100,"explosion.png");
        Backfisch.setHidden(false);
        //aktiv = true;
        dieHindernisse = pK1;
    }
    
        public void bewegeOben() {
        //snapperBild.move(0,-1);
        if (snapperBild.getShapeX() > 1) {
            snapperBild.move(0,-1);
        }
    }
    public void bewegeUnten() {
        //snapperBild.move(0,1);
        if (snapperBild.getShapeX() < Spiel.BILDBREITE-snapperBild.getShapeWidth()-1) {
            snapperBild.move(0,1);
        }
    }
    
    public boolean pruefeKollision() {
        boolean ergebnis = false;
        for (int i = 0; i < dieHindernisse.length; i++) {
            if (snapperBild.intersects(dieHindernisse[i].getShape())) {
                ergebnis = true;
            }
        }
        if (ergebnis) {
            snapperBild.setHidden(true);
            Backfisch.moveTo(snapperBild.getShapeX()-5, snapperBild.getShapeY());
            Backfisch.setHidden(false);
        }
        return ergebnis;
    }
    // Dienste

}