package sortingClean;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;


import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {

    @Inject
    private @Named("a1") SortingAlgorithm<Integer> quadraticAlgorithm;

    @Inject
    private @Named("a2")SortingAlgorithm<Integer> nlognAlgorithm;//=new BubbleSort();
    @Inject
    private @Named("a3")SortingAlgorithm<Integer> randomAlgorithm1;//=new BubbleSort();
    @Inject
    private @Named("a4")SortingAlgorithm<Integer> randomAlgorithm2;//=new BubbleSort();
    @Inject
    private @Named("a5") int numberOfElements;//=1233;
    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm1.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm2.sort(intsClone);
    }
}
