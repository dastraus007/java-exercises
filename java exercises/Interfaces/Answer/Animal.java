public abstract class Animal implements Seasonable,Comparable{
    protected int weight;
    private Season season;
    protected Color color;

    Animal(int weight, Season season, Color color){
        this.weight =weight;
        this.season =season;
        this.color =color;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Animal) {
            Animal otherAnimal = (Animal) o;
            // Compare the weights of the two animals
            return Integer.compare(this.weight, otherAnimal.weight);
            //return Integer.compare( otherAnimal.weight,this.weight);
        }
        throw new IllegalArgumentException("Cannot compare an Animal with a non-Animal object");
    }
    @Override
    public void changeSeason() {
        // Change the current season to the next season
        this.season = season.getNextSeason();
    }
    public void setSeason(Season s) {
        // Change the current season to the next season
        this.season = s;
    }



}
