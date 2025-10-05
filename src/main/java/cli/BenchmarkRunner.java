package cli;

import algorithms.KadaneMaxSubarray;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        String sizesArg = "100,1000,10000,100000";
        String dist = "random";
        int repeat = 3;
        String out = "results-kadane.csv";

        for (int i=0;i<args.length;i++){
            if ("--sizes".equals(args[i]) && i+1<args.length) sizesArg = args[++i];
            if ("--dist".equals(args[i]) && i+1<args.length) dist = args[++i];
            if ("--repeat".equals(args[i]) && i+1<args.length) repeat = Integer.parseInt(args[++i]);
            if ("--out".equals(args[i]) && i+1<args.length) out = args[++i];
        }

        List<Integer> sizes = new ArrayList<>();
        for (String s : sizesArg.split(",")) sizes.add(Integer.parseInt(s.trim()));
        Random rnd = new Random(42);

        try (PrintWriter pw = new PrintWriter(new FileWriter(out))) {
            pw.println(metrics.PerformanceTracker.csvHeader());
            for (int size : sizes) {
                for (int run = 1; run <= repeat; run++) {
                    int[] arr = generate(size, dist, rnd);
                    PerformanceTracker t = new PerformanceTracker();
                    t.start();
                    KadaneMaxSubarray.maxSubArraySum(arr, t);
                    t.stop();
                    pw.println(t.toCsvRow("kadane", size, dist, run));
                    pw.flush();
                }
            }
        }
        System.out.println("Results saved to " + out);
    }

    private static int[] generate(int n, String dist, Random rnd) {
        int[] a = new int[n];
        switch (dist) {
            case "sorted":
                for (int i=0;i<n;i++) a[i]=i%50;
                Arrays.sort(a);
                break;
            case "reverse":
                for (int i=0;i<n;i++) a[i]=n-i;
                break;
            case "nearly":
                for (int i=0;i<n;i++) a[i]=i%50;
                Arrays.sort(a);
                for (int i=0;i<Math.max(1,n/100);i++){
                    int x = rnd.nextInt(n), y = rnd.nextInt(n);
                    int tmp = a[x]; a[x] = a[y]; a[y] = tmp;
                }
                break;
            default:
                for (int i=0;i<n;i++) a[i] = rnd.nextInt(2001)-1000;
        }
        return a;
    }
}
