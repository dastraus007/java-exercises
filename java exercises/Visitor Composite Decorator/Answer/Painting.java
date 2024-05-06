 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.round;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }
    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            Element containingElement = pathToElementMap.get(element.getPath());
			//TODO: add element as a child of containingElement
            if (containingElement instanceof Lake) {
                if (element instanceof Boat) {
                    elementList.add(element);
                } else if (element instanceof Kid) {
                    elementList.add(element);
                } else if (element instanceof Island) {
                    elementList.add(element);
                }

                if (element instanceof Kite ) {
                    System.out.println(containingElement.getFullName()+" cannot contain Kite");
                } else if (element instanceof Flag) {
                    System.out.println(containingElement.getFullName()+" cannot contain Flag");
                } else if (element instanceof Tree) {
                    System.out.println(containingElement.getFullName()+" cannot contain Tree");
                }else if (element instanceof Lake) {
                    System.out.println(containingElement.getFullName()+" cannot contain Lake");
                }

            }else if (containingElement instanceof Island) {
                if (element instanceof Kite) {
                    elementList.add(element);
                } else if (element instanceof Flag) {
                    elementList.add(element);
                } else if (element instanceof Tree) {
                    elementList.add(element);
                } else if (element instanceof Kid) {
                    elementList.add(element);
                } else if (element instanceof Lake) {
                    elementList.add(element);
                }

                if (element instanceof Boat ) {
                    System.out.println(containingElement.getFullName()+" cannot contain Boat");
                } else if (element instanceof Island) {
                    System.out.println(containingElement.getFullName()+" cannot contain Island");
                }

            }
        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


    public void getc() {
       // System.out.println( this.elementList.size());
        int c=0;
        for (Element element : elementList) {
            CountElementsVis a=new CountElementsVis();
            c = c+ element.acceptCountElements(a);
        }
        System.out.println(c);
    }
    public void getlp() {
        for (Element element : elementList) {
            LongPrintVis a=new LongPrintVis();
            element.acceptLongPrint(a,elementList);
        }
        System.out.println();

       /*     List<String> elementNames = new ArrayList<>();
            for (Element element : elementList) {//Boat Flag Tree Kid Lake Island
                if (element instanceof Kite ) {
                    System.out.print("A kite of color: "+((Kite)element).getColor().toString().toLowerCase()+". ");
                } else if (element instanceof Boat) {//A boat made of timber material.
                    System.out.print("A boat made of "+((Boat)element).getMaterial().toString().toLowerCase()+" material. ");
                } else if (element instanceof Flag) {
                    System.out.print("A Flag of color: "+((Flag)element).getColor().toString().toLowerCase()+" poleHeight"+((Flag)element).getCarrierHeight()+". ");
                } else if (element instanceof Tree) {//A tree with an amount of 2500 leaves.
                    System.out.print("A tree with an amount of "+((Tree)element).getLeavesAmount()+" leaves. ");
                } else if (element instanceof Kid) {
                    System.out.print("A "+(2023-((Kid)element).getBirthYear())+" year old kid with "+((Kid)element).getHairColor().toString().toLowerCase()+" hair. ");
                }else if (element instanceof Lake) {//A lake named Grand containing:
                    int a=0;
                    for (Element element1 : elementList) {
                        if (element1.getPath().equals(element.getFullName()))
                        {
                            a=a+1;
                        }
                    }
                    if (a>=1)
                    {
                        System.out.print("A lake named "+((Lake)element).getName()+" containing: ");
                    }
                    else
                    {
                        System.out.print("A empty lake named "+((Lake)element).getName()+". ");
                    }
                } else if (element instanceof Island) {//An empty island named Madagascar.
                    // An island named Glover containing:
                    int a=0;
                    for (Element element1 : elementList) {
                        if (element1.getPath().equals(element.getFullName()))
                        {
                            a=a+1;
                        }
                    }
                    if (a>=1)
                    {
                        System.out.print("An island named "+((Island)element).getName()+" containing: ");
                    }
                    else
                    {
                        System.out.print("An empty island named "+((Island)element).getName()+". ");
                    }
                }

            }

        */
    }
    public void getsh() {

        List<String> elementNames = new ArrayList<>();
        for (Element element : elementList) {
          //  System.out.println(element.getFullName());
            ShortPrintVis a=new ShortPrintVis();
            element.acceptShortPrint(a);
        }
    }
    public void getta() {

        List<String> elementNames = new ArrayList<>();
        double a=0;
        double b=0;
        for (Element element : elementList) {
            TotalAreaVis c=new TotalAreaVis();
            b= element.acceptTotalArea(c);
            //b=element.Area();
            a=a+b;
        }
        System.out.println(round(a));
    }


}