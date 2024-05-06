 

public class PaperFactory {
   // public addition addi;
    //  public Paper p;

    public static Paper createPaper(String code){
        if (code.equals("ac"))
        {
            return new AcademicPaper();

        } else if (code.equals("cn")) {
            return new Contract();
        } else if (code.equals("jr")) {//ERORR PR NOT JR
            return new JournalArticle();
        } else if ( code.equals("bk")) {
            return new Book();
        }else
        {
            throw new RuntimeException("wrong PaperType");
        }
        //TODO: fix
        //throw new RuntimeException("wrong PaperType");
    }
    public static Paper add(String code,Paper p1){
        if (code.equals("tb"))
        {
            return new Table(p1);
        } else if (code.equals("eq")) {
            return new Equation(p1);
        } else if (code.equals("d")) {
            return new Diagram(p1);
        } else if (code.equals("nt")) {
            return new Note(p1);
        }
        throw new RuntimeException("wrong PaperType");

    }
}
