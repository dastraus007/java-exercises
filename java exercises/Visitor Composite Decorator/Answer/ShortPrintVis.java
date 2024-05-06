public class ShortPrintVis implements VisitorShortPrint{
    @Override
    public void ShortPrint(Kite k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void ShortPrint(Boat k) {
        System.out.println(k.getFullName());

    }

    @Override
    public void ShortPrint(Flag k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void ShortPrint(Tree k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void ShortPrint(Kid k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void ShortPrint(Lake k) {
        System.out.println(k.getFullName());
    }

    @Override
    public void ShortPrint(Island k) {
        System.out.println(k.getFullName());
    }
}
