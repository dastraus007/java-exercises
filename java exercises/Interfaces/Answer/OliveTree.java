public class OliveTree extends Tree {


    OliveTree(int height, Season season) {
        super(height,season,Color.GREEN);
    }

    @Override
    public String toString() {
        if(this.getCurrentSeason()==Season.FALL) {
            return "Olive tree. I give fruit. My height is: " + this.height + " and my color is: " + this.leavesColor;
        }
        else
        {
            return "Olive tree. My height is: " + this.height + " and my color is: " + this.leavesColor;
        }
    }
    @Override
    public void changeSeason() {
        // Get the next season
    //    public enum Season {
     //       WINTER, SPRING, SUMMER, FALL;
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
        //Season nextSeason = this.season.getNextSeason();
        //this.season = nextSeason;
        Season nextSeason = this.season;
        // Update relevant fields based on the current season
        switch (nextSeason) {
            case WINTER:
                // In winter, the height increases by 5 cm
                height += 5;
                break;
            case SPRING:
                // In spring, the height increases by 10 cm
                height += 10;
                break;
            case SUMMER:
                // In summer, the height increases by 10 cm
                height += 10;
                break;
            case FALL:
                // In autumn, the height increases by 5 cm, and the tree bears fruit (assuming it's an olive tree)
                height += 5;
                // Assume the tree bears fruit only if it's an olive tree (you may adjust this logic)
                break;
        }
    }
}
