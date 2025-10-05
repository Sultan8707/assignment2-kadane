package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KadaneMaxSubarrayTest {
    @Test
    public void testSingle() {
        int[] a = {5};
        var r = KadaneMaxSubarray.maxSubArraySum(a, new PerformanceTracker());
        assertEquals(5, r);
    }

    @Test
    public void testPositive() {
        int[] a = {1,2,3,4};
        assertEquals(10, KadaneMaxSubarray.maxSubArraySum(a, new PerformanceTracker()));
    }

    @Test
    public void testMixed() {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, KadaneMaxSubarray.maxSubArraySum(a, new PerformanceTracker()));
    }
}
