public abstract class BaseAdditionDecorator implements Paper
{
    private final Paper addi;
    BaseAdditionDecorator(Paper a)
    {
        this.addi=a;
    }
    BaseAdditionDecorator()
    {
        addi=null;
    }
    @Override
    public String write() {
        return this.addi.write();
    }
}
