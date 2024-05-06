import java.util.List;

public class Kite extends Element {
    Color color;

    public Kite(double width, double height, Color color, String path) {
        super(width, height, path);
        this.color = color;
    }

     public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
	
    @Override
    public String getName() {
        return "kite";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
    //@Override
             //   public double Area() {
//return (this.length*this.width)/2;
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
