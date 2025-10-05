package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;
    private long assignments = 0;
    private long startNs = 0;
    private long endNs = 0;

    public void start() { startNs = System.nanoTime(); }
    public void stop() { endNs = System.nanoTime(); }
    public long elapsedNs() { return endNs - startNs; }

    public void incComparisons() { comparisons++; }
    public void incArrayAccesses() { arrayAccesses++; }
    public void incAssignments() { assignments++; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getAssignments() { return assignments; }

    public static String csvHeader() {
        return "algorithm,size,dist,run,elapsedNs,comparisons,arrayAccesses,assignments";
    }
    public String toCsvRow(String algorithm, int size, String dist, int run) {
        return String.format("%s,%d,%s,%d,%d,%d,%d,%d",
                algorithm, size, dist, run, elapsedNs(), comparisons, arrayAccesses, assignments);
    }
}
