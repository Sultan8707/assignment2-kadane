package algorithms;

import metrics.PerformanceTracker;

public class KadaneMaxSubarray {

    public static int maxSubArraySum(int[] arr, PerformanceTracker t) {

        int maxSoFar = arr[0];
        int currentMax = arr[0];
        t.incArrayAccesses();

        for (int i = 1; i < arr.length; i++) {
            t.incArrayAccesses();
            if (currentMax < 0)
                currentMax = arr[i];
            else
                currentMax = currentMax + arr[i];

            if (currentMax > maxSoFar) maxSoFar = currentMax;
            t.incComparisons();
        }
        return maxSoFar;
    }
}

