import java.util.List;

public class Lake extends Element {
    private String name;
    public Lake(String name, double diameter, String path) {
        //TODO: fix
        super(diameter,diameter,path);
        this.name=name;
    }

    @Override
    public String getName() {
        //TODO: fix
        return this.name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
 //   @Override
   // public double Area() {
     //   double pi = ((this.getWidth()/2)*(this.getWidth()/2)) * Math.PI;
       // return pi;
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
