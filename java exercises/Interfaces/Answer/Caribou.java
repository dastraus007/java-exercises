public class Caribou extends Animal {

    Caribou(int weight, Season season) {

        super(weight, season, null);


        if(season== Season.WINTER)
        {
            this.color=Color.WHITE;
        }
        else
        {
            this.color=Color.BROWN;
        }
        Season nextSeason = this.getCurrentSeason();



    }

   @Override
   public void changeSeason() {
       Season thisSeason = this.getCurrentSeason();
       if(thisSeason== Season.WINTER)
       {
           this.setSeason(Season.SPRING);
       } else if (thisSeason== Season.SPRING) {
           this.setSeason(Season.SUMMER);
       } else if (thisSeason== Season.SUMMER) {
           this.setSeason(Season.FALL);
       }
       else
       {
           this.setSeason(Season.WINTER);
       }
       Season nextSeason = this.getCurrentSeason();

       // Update relevant fields based on the current season
       switch (nextSeason) {
           case WINTER:
               // In winter, the caribou changes its color to white and migrates south
               this.color = Color.WHITE;
               // Perform additional winter-specific actions if needed
               // For example, migrateSouth();
               break;
           case SPRING:
               // In spring, the caribou changes its color to brown
               this.color = Color.BROWN;
               // Perform additional spring-specific actions if needed
               break;
           case SUMMER:
               this.color = Color.BROWN;
               // In summer, the caribou migrates north
               // Perform additional summer-specific actions if needed
               // For example, migrateNorth();
               break;
           case FALL:
               this.color = Color.BROWN;
               // In fall, no change
               // Perform additional fall-specific actions if needed
               break;
       }
   }
    @Override
    public String toString() {
        // Describe the change in season for the bear
        //Bear. My weight is: 239 and my color is: BROWN
        //Caribou: My weight is: 208 and my color is: BROWN
      //  String seasonDescription = "It is currently " + this.getCurrentSeason() + ". ";
        //Caribou: I am migrating south. My weight is: 208 and my color is: WHITE
        //Caribou: I am migrating north. My weight is: 208 and my color is: BROWN
        if (this.getCurrentSeason()==Season.WINTER)
        {
            String weightAndColorInfo = "Caribou: I am migrating south. My weight is: " + this.weight + " and my color is: " + this.color;
            return weightAndColorInfo;

        } else if (this.getCurrentSeason()==Season.SUMMER) {
            String weightAndColorInfo = "Caribou: I am migrating north. My weight is: " + this.weight + " and my color is: " + this.color;
            return weightAndColorInfo;
        }
        else
        {
            String weightAndColorInfo = "Caribou: My weight is: " + this.weight + " and my color is: " + this.color;
            return weightAndColorInfo;
        }

        // Provide information about the bear's weight and color
//        String weightAndColorInfo = "Caribou: My weight is: " + this.weight + " and my color is: " + this.color;

        // Combine the season description and object data
  //      return weightAndColorInfo;
    }

}
