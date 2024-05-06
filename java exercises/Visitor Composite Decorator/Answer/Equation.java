public class Equation extends BaseAdditionDecorator{
    Equation(Paper a) {
        super(a);
    }

    @Override
    public String write() {
        return super.write()+" Equation";
    }
}
