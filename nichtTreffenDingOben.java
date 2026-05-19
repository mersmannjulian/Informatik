import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.


public class nichtTreffenDingOben 
{
    // Bezugsobjekte
    protected Picture Korralle;
    
    // Attribute

    // Konstruktor
    public nichtTreffenDingOben(double pX, double lueckenStart)
    {
        Korralle = new Picture(pX,0,"Koralle1.png");
        setzePosition(pX, lueckenStart);
    }
    public void bewege() {
        Korralle.move(-2,0);
    }
    
    public void setzePosition(double pX, double lueckenStart) { 
        Korralle.moveTo(pX, lueckenStart - Korralle.getShapeHeight());
    }
    
    public Picture getShape() {
        return Korralle;
    }
    
    public double getShapeX(){
        return Korralle.getShapeX();
    }

    public double getBreite(){
        return Korralle.getShapeWidth();
    }
    // Dienste

}
