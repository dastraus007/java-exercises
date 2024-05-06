public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight,season,Color.BROWN);
    }

   @Override
   public String toString() {
       if (this.getCurrentSeason()==Season.WINTER)
       {//Bear. I am sleeping. My weight is: 191 and my color is: BROWN
           String weightAndColorInfo = "Bear. I am sleeping. My weight is: " + this.weight + " and my color is: " + this.color;
           return weightAndColorInfo;
       }
       else {
           String weightAndColorInfo = "Bear. My weight is: " + this.weight + " and my color is: " + this.color;
           return weightAndColorInfo;
       }
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
       double w =0;


       // Update relevant fields based on the current season
       switch (nextSeason) {
           case WINTER:
               // In winter, the bear loses 20% of its weight and sleeps
               w =  (this.weight * 0.8);
               //weight = (int) Math.round(t);
               this.weight = (int) Math.round(w);
               break;
           case SPRING:
               // In spring, the bear loses 25% of its weight
               w =  (weight * 0.75);
               weight = (int) Math.round(w);
               break;
           case SUMMER:
               // In summer, the bear increases by a third of its weight
               w=  (this.weight * 1.3333333333333333);
               //weight = (int) Math.round(t2);
               weight = (int) Math.round(w);
               // Perform additional summer-specific actions if needed
               break;
           case FALL:
               // In fall, the bear gains about 25% of its weight
               w=  (this.weight * 1.25);
               //weight = (int) Math.round(t3);
               weight = (int) Math.round(w);
               // Perform additional fall-specific actions if needed
               break;
       }
   }

}
