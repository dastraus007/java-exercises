public class Note extends BaseAdditionDecorator{
    Note(Paper a) {
        super(a);
    }

    @Override
    public String write() {
        return super.write()+" Note";
    }
}
