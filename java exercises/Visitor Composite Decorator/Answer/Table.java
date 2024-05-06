public class Table extends BaseAdditionDecorator {
    Table(Paper a) {
        super(a);
    }

    @Override
    public String write() {
        return super.write()+" Table";
    }
}
