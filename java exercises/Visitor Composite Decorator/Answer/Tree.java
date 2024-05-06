import java.util.List;

public class Tree extends Element implements Visitable{

    int leavesAmount;

    public int getLeavesAmount() {
        return leavesAmount;
    }

    public Tree(double width, double height, int leavesAmount, String path) {
        super(width, height, path);
        this.leavesAmount = leavesAmount;
    }

    @Override
     public String getName() {
        return "tree";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
//@Override
  //  public double Area() {
    //    double a =0;
      //  a=this.length*this.getWidth()/2;
        //return  a;
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
