import java.util.List;

public interface Visitable {
    public Void acceptLongPrint(VisitorLongPrint a,List<Element> elementList);
    public Void acceptShortPrint(VisitorShortPrint a);//VisitorShortPrint
    public double acceptTotalArea(VisitorTotalArea a);
    public int acceptCountElements(VisitorCountElements a);

}
