package sortingClean;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Named;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Random;

public class MainApp {
    static WeldContainer container = new Weld().initialize();
    public static void main(String[] args) {
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.runAlgorithms();
    }
    @Produces
    public @Named("a1") SortingAlgorithm<Integer>a1() {
        return container.select(BubbleSort.class).get();
    }
    @Produces
    public @Named("a2") SortingAlgorithm<Integer>a2() {
        return container.select(QuickSort.class).get();
    }
    @Produces
    public @Named("a3") SortingAlgorithm<Integer>a3() {
        return makeRandomSortingAlgorithm();
    }
    @Produces
    public @Named("a4") SortingAlgorithm<Integer>a4() {
        return makeRandomSortingAlgorithm();
    }
    @Produces
    public @Named("a5") int a5() {
        return 1000;
    }
    private static SortingAlgorithm<Integer> makeRandomSortingAlgorithm(){
        Random random = new Random(System.currentTimeMillis());
        SortingAlgorithm<Integer> sortAlg= null;
        switch (random.nextInt(4)){
            case 0: sortAlg =container.select(QuickSort.class).get();
                break;
            case 1: sortAlg =container.select(MergeSort.class).get();
                break;
            case 2: sortAlg =container.select(BubbleSort.class).get();
                break;
            case 3: sortAlg =container.select(InsertionSort.class).get();
        }
        return sortAlg;
    }
}
