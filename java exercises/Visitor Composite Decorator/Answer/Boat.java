import java.util.List;

public class Boat extends Element {
    @Override
    public int acceptCountElements(VisitorCountElements a) {
        return a.CountElements();
    }

    Material material;
    public Boat(double width, double length, Material m, String path) {
        super(width, length, path);
        this.material=m;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return "boat";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
  //  @Override
    //public double Area() {
      //  return (this.length-(this.width/2))*this.width+(this.width/2)*(this.width/2)*Math.PI/2;
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
}
