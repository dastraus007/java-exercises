public class TotalAreaVis implements VisitorTotalArea{
    @Override
    public double Area(Kite k) {
        return (k.length*k.width)/2;
    }

    @Override
    public double Area(Boat k) {
        return (k.length-(k.width/2))*k.width+(k.width/2)*(k.width/2)*Math.PI/2;
    }

    @Override
    public double Area(Flag k) {
        //return 0;
        return k.length*k.width;
    }

    @Override
    public double Area(Tree k) {
        //return 0;
        double a =0;
        a=k.length*k.getWidth()/2;
        return  a;
    }

    @Override
    public double Area(Kid k) {
        // return 0;
        return (k.length-k.width)*k.width+(k.width/2)*(k.width/2)*Math.PI;
    }

    @Override
    public double Area(Lake k) {
        //  return 0;
        return ((k.getWidth()/2)*(k.getWidth()/2)) * Math.PI;
    }

    @Override
    public double Area(Island k) {
        //return 0;
        return ((k.width/2)*(k.width/2))*Math.PI;
    }
}
