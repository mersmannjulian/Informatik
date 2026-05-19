import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.

public class schwebeDing
{
    // Bezugsobjekte
    private Picture snapperBild;
    private Picture Backfisch;
    private nichtTreffenDingOben[] dieHindernisseOben;
    private nichtTreffenDingUnten[] dieHindernisseUnten;
    // Attribute
    //private boolean aktiv;
    // Konstruktor
    public  schwebeDing(nichtTreffenDingOben[] pOben, nichtTreffenDingUnten[] pUnten)
    {
        snapperBild = new Picture(Spiel.BILDBREITE - 200 , Spiel.BILDHOEHE / 2,"snapper.png");
        Backfisch = new Picture(0,-100,"explosion.png");
        Backfisch.setHidden(false);
        //aktiv = true;
        dieHindernisseOben = pOben;
        dieHindernisseUnten = pUnten;
    }
    
    public void bewegeOben() {
        if (snapperBild.getShapeY() > 1) {
            snapperBild.move(0,-1);
        }
    }
    public void bewegeUnten() {
        if (snapperBild.getShapeY() < Spiel.BILDHOEHE-snapperBild.getShapeHeight()-1) {
            snapperBild.move(0,1);
        }
    }
    
    public boolean pruefeKollision() {
        boolean ergebnis = false;
        for (int i = 0; i < dieHindernisseOben.length; i++) {
            if (snapperBild.intersects(dieHindernisseOben[i].getShape())) {
                ergebnis = true;
            }
            if (snapperBild.intersects(dieHindernisseUnten[i].getShape())) {
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
