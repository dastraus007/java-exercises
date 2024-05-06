import java.util.List;

public class Kid extends Element {
    private int birthYear;
    private Color hairColor;

    public Kid(double width, double height, int birthYear, Color hairColor, String path) {
        super(width, height, path);
        this.birthYear = birthYear;
        this.hairColor = hairColor;
    }

 
    public int getBirthYear() {
        return birthYear;
    }

    public Color getHairColor() {
        return hairColor;
    }

    @Override
    public String getName() {
        return "kid";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AMPHIBIAN;
    }
   // @Override
   // public double Area() {
     //   return (this.length-this.width)*this.width+(this.width/2)*(this.width/2)*Math.PI;
    //}
    @Override
    public Void acceptLongPrint(VisitorLongPrint a, List<Element> elementList) {
        a.LongPrint(this,elementList);
        return null;
    }
    @Override
    public Void acceptShortPrint(VisitorShortPrint a) {
        a.ShortPrint(this);
        return null;
    }

    @Override
    public double acceptTotalArea(VisitorTotalArea a) {
        return a.Area(this);
    }

    @Override
    public int acceptCountElements(VisitorCountElements a) {
        return a.CountElements();
    }
}
