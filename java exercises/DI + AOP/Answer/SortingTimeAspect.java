package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class SortingTimeAspect {
    private Map<String, Integer> algorithmInvocationCount = new HashMap<>();
    private Map<String, Long> algorithmTotalTime = new HashMap<>();
    private long totalTime = 0;
    private long startTime;

    @Before("execution(void sortingClean.SortingAlgorithm.sort(..))")
    public void beforeSort(JoinPoint joinPoint) {
        String algorithmName = joinPoint.getSignature().getDeclaringTypeName();
        startTime = System.currentTimeMillis();
        algorithmInvocationCount.put(algorithmName, algorithmInvocationCount.getOrDefault(algorithmName, 0) + 1);
    }

    @After("execution(void sortingClean.SortingAlgorithm.sort(..))")
    public void afterSort(JoinPoint joinPoint) {
        String algorithmName = joinPoint.getSignature().getDeclaringTypeName();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        algorithmTotalTime.put(algorithmName, algorithmTotalTime.getOrDefault(algorithmName, 0L) + executionTime);
        totalTime += executionTime;
    }
 /*   @Before("execution(void sortingClean.AlgorithmRunner.runAlgorithms(..))")
    public void Beforef(JoinPoint joinPoint) {
       // this.randomAlgorithm1
       // joinPoint.randomAlgorithm1
    }

  */

    @After("execution(void sortingClean.AlgorithmRunner.runAlgorithms())")
    public void afterf(JoinPoint joinPoint) {
        /*       System.out.println("Total time of running all sort functions was " + this.totalTime + " ms");
        System.out.println("In detail:");
        for (String algorithmName : this.algorithmInvocationCount.keySet()) {
            int count = this.algorithmInvocationCount.getOrDefault(algorithmName, 0);
            long time = this.algorithmTotalTime.getOrDefault(algorithmName, 0L);
            System.out.println("Function sort in " + algorithmName + " ran " + count + " times and took in total " + time + " ms");
        }
        //        for (int i=0;i<this.algorithmInvocationCount.size();i++ )
        //    {
        //       System.out.println("Function sort in " + this.algorithmInvocationCount[i] algorithmName + " ran " + count + " times and took in total " + time + " ms");

        //   }

         */


    }

    @After("execution(void AlgorithmRunner.runAlgorithms())")
    public void afterf1(JoinPoint joinPoint) {
        System.out.println("Total time of running all sort functions was " + this.totalTime + " ms");

        System.out.println("In detail:");
        for (String algorithmName : this.algorithmInvocationCount.keySet()) {
            int count = this.algorithmInvocationCount.getOrDefault(algorithmName, 0);
            long time = this.algorithmTotalTime.getOrDefault(algorithmName, 0L);
            System.out.println("Function sort in " + algorithmName + " ran " + count + " times and took in total " + time + " ms");
        }
    }


    public Map<String, Integer> getAlgorithmInvocationCount() {
        return algorithmInvocationCount;
    }

    public Map<String, Long> getAlgorithmTotalTime() {
        return algorithmTotalTime;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
