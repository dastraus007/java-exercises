public class Diagram extends BaseAdditionDecorator{
    Diagram(Paper a) {
        super(a);
    }

    @Override
    public String write() {
        return super.write()+" Diagram";
    }
}
