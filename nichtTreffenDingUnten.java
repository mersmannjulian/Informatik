import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.


public class nichtTreffenDingUnten
{
    // Bezugsobjekte
    
    private Picture K2;
    // Attribute

    // Konstruktor
    public nichtTreffenDingUnten(double pX, double pY )
    {
        K2 = new Picture(pX, pY,"Koralle2.png");
    }

    public void bewege() {
        K2.move(-2,0);
    }

    public void setzePosition(double pX, double pY) {
        K2.moveTo(pX, pY);
    }

    public Picture getShape() {
        return K2;
    }

    public double getShapeX(){
        return K2.getShapeX();
    }

    public double getBreite(){
        return K2.getShapeWidth();
    }
    // Dienste

}
