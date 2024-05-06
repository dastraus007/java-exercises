// TODO: Implement Composite (change this file).

import java.util.List;

public class Island extends Element {
    @Override
    public double acceptTotalArea(VisitorTotalArea a) {
        return a.Area(this);
    }

    @Override
    public int acceptCountElements(VisitorCountElements a) {
        return a.CountElements();
    }

    private String name;
    public Island(String name, double diameter, String path) {
        //TODO: fix
      //  super(0,0,null);
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
        return Habitat.AQUATIC;
    }
  //  @Override
    //public double Area() {
      //  return ((this.width/2)*(this.width/2))*Math.PI;
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


}
