import javax.lang.model.type.NullType;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height,season,null);

        if(this.season== Season.WINTER)
        {
            this.leavesColor=null;
        } else if (this.season == Season.SUMMER||this.season== Season.SPRING) {
            this.leavesColor=Color.GREEN;
        }
        else
        {
            this.leavesColor = Color.YELLOW;
        }
        Season nextSeason = this.season;

    }

    //Fig tree. I give fruit. My height is: 244 and my color is: GREEN
    @Override
    public String toString() {
        if (this.season==Season.SUMMER) {
            return "Fig tree. I give fruit. My height is: " + this.height + " and my color is: " + this.leavesColor;

        } else if (this.season==Season.WINTER) {
            return "Fig tree. My height is: " + this.height + " and I have no leaves";
//Fig tree. My height is: 204 and I have no leaves
        } else
        {
            return "Fig tree. My height is: " + this.height + " and my color is: " + this.leavesColor;

        }
    }
    //Fig tree. My height is: 164 and my color is: YELLOW

   @Override
   public void changeSeason() {
       // Get the next season
       //Season nextSeason = this.season.getNextSeason();
      // this.season=nextSeason;
      // season = nextSeason;
       if(this.season== Season.WINTER)
       {
           this.season=Season.SPRING;
       } else if (this.season== Season.SPRING) {
           this.season=Season.SUMMER;
       } else if (this.season== Season.SUMMER) {
           this.season=Season.FALL;
       }
       else
       {
           this.season = Season.WINTER;
       }
       Season nextSeason = this.season;

       // Update relevant fields based on the current season
       switch (nextSeason) {
           case WINTER:
               // In winter, the height increases by 20 cm, and there are no leaves
               height += 20;
               leavesColor = null;  // No leaves in winter
               break;
           case SPRING:
               // In spring, the height increases by 30 cm, and green leaves grow
               height += 30;
               leavesColor = Color.GREEN;
               break;
           case SUMMER:
               // In summer, the height increases by 30 cm, and the tree bears fruit (assuming it's a fig tree)
               height += 30;
               // Assume the tree bears fruit only if it's a fig tree (you may adjust this logic)
               break;
           case FALL:
               // In autumn, the height increases by 20 cm, and the color of the leaves turns yellow
               height += 20;
               leavesColor = Color.YELLOW;
               break;
       }
   }

}
