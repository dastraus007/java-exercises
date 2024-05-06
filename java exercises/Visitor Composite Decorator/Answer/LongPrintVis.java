import java.util.List;

public class LongPrintVis implements VisitorLongPrint{//Short

    @Override
    public void LongPrint(Kite k,List<Element> elementList) {
        System.out.print("A kite of color: "+((Kite)k).getColor().toString().toLowerCase()+". ");

    }

    @Override
    public void LongPrint(Boat k,List<Element> elementList) {
        System.out.print("A boat made of "+((Boat)k).getMaterial().toString().toLowerCase()+" material. ");


    }

    @Override
    public void LongPrint(Flag k,List<Element> elementList) {
        System.out.print("A Flag with color: "+((Flag)k).getColor().toString().toLowerCase()+" of height "+((Flag)k).getCarrierHeight()+". ");

    }

    @Override
    public void LongPrint(Tree k,List<Element> elementList) {
        System.out.print("A tree with an amount of "+((Tree)k).getLeavesAmount()+" leaves. ");


    }

    @Override
    public void LongPrint(Kid k,List<Element> elementList) {
        System.out.print("A "+(2023-((Kid)k).getBirthYear())+" year old kid with "+((Kid)k).getHairColor().toString().toLowerCase()+" hair. ");

    }

    @Override
    public void LongPrint(Lake k, List<Element> elementList) {
        int a=0;
        for (Element element1 : elementList) {
            if (element1.getPath().equals(k.getFullName()))
            {
                a=a+1;
            }
        }
        if (a>=1)
        {
            System.out.print("A lake named "+((Lake)k).getName()+" containing: ");
        }
        else
        {
            System.out.print("A empty lake named "+((Lake)k).getName()+". ");
        }
    }

    @Override
    public void LongPrint(Island k,List<Element> elementList) {
        int a=0;
        for (Element element1 : elementList) {
            if (element1.getPath().equals(k.getFullName()))
            {
                a=a+1;
            }
        }
        if (a>=1)
        {
            System.out.print("An island named "+((Island)k).getName()+" containing: ");
        }
        else
        {
            System.out.print("An empty island named "+((Island)k).getName()+". ");
        }
    }
}
