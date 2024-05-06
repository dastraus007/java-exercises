public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;

    Tree(int height, Season season, Color leavesColor){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof Tree) {
            Tree otherTree = (Tree) o;
            // Compare the weights of the two animals
            return Integer.compare(this.height, otherTree.height);
        }
        throw new IllegalArgumentException("Cannot compare an Tree with a non-Tree object");
    }
}
