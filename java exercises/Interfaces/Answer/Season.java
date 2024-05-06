public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    public Season getNextSeason() {

        // Get the ordinal value of the current season
        int currentOrdinal = this.ordinal();
        // Calculate the ordinal value of the next season
        int nextOrdinal = (currentOrdinal + 1) % values().length;
        // Update the current instance's season to the next season
        Season nextSeason = values()[nextOrdinal];
        // Return the next season
        return nextSeason;
    }


}
