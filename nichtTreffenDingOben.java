import sas.*; // Import der SAS-Bibliothek
import java.awt.Color; // Import der Klasse Color, um einfacher auf die Farben zuzugreifen.


public class nichtTreffenDingOben 
{
    // Bezugsobjekte
    protected Picture Korralle;
    
    // Attribute

    // Konstruktor
    public nichtTreffenDingOben(double pX)
    {
        double x = Math.random() * (Spiel.BILDBREITE-40);
        double y = - Math.random() * Spiel.BILDHOEHE; 
        Korralle = new Picture(1800 + (pX +100) ,0,"Koralle1.png");
        //Korralle.turn(180);
    }
    public void bewege() {
        Korralle.move(-2,0);
        if (Korralle.getShapeY() > Spiel.BILDHOEHE+60) {
            //zuruecksetzen();
        }
    }
    
    public void zuruecksetzen(double pX) { 
        Korralle.moveTo(1800 + (pX +100),0);
    }
    
    public Picture getShape() {
        return Korralle;
    }
    private void drehen(){
        //K1.turn(180);
    
    }
    
    public double getShapeX(){
    return Korralle.getShapeX();
    }
    // Dienste

}