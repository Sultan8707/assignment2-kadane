
Kadane’s Algorithm — Maximum Subarray
Author: Sultan Muratbek


📘 Overview
This project implements and analyzes Kadane’s Algorithm, which efficiently finds the contiguous subarray with the largest sum.

The implementation is written in Java and includes:

Core algorithm

Performance measurement utility

CLI benchmark tool

Unit tests

⚙️ Project Structure

assignment2-kadane/
├── docs/
│ └── Assignment2DAA.pdf
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── algorithms/
│ │ │ └── KadaneMaxSubarray.java
│ │ ├── cli/
│ │ │ └── BenchmarkRunner.java
│ │ └── metrics/
│ │ └── PerformanceTracker.java
│ └── test/
│ └── java/
│ └── algorithms/
│ └── KadaneMaxSubarrayTest.java
├── pom.xml
├── results-kadane.csv
└── README.md

🧠 Algorithm Description

Kadane’s Algorithm solves the maximum subarray problem in linear time.

Steps:

Initialize maxSoFar and currentMax with the first element.

For each element, update:

currentMax = max(arr[i], currentMax + arr[i])

maxSoFar = max(maxSoFar, currentMax)

Return maxSoFar.

Complexity:

Time: O(n)

Space: O(1)

🧪 Testing
Unit tests are written with JUnit 5.
Run them with:

mvn test


The tests cover:

Single-element arrays

Arrays with all positive values

Arrays with mixed positive/negative values

⚡ Performance Benchmarking
You can run benchmarks using the CLI tool:

mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner" \
-Dexec.args="--sizes 100,1000,10000 --dist random --repeat 3 --out results-kadane.csv"


Metrics collected with PerformanceTracker:

Execution time (nanoseconds)

Comparisons

Array accesses

Assignments

📊 Report
The file docs/analysis-report.md includes:

Algorithm description

Complexity analysis

Real benchmark results

Performance graphs

Conclusions

To generate performance plots from CSV results, run:

python3 plot_results.py results-kadane.csv


This creates .png graphs in the plots/ directory.

🧩 Requirements

Java 17+

Maven 3.8+

JUnit 5

(optional) Python 3.9+ with pandas + matplotlib

Build the project with:

mvn clean install


🧑‍💻 How to Run

Compile:

mvn compile


Run benchmark with defaults:

mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"


🏁 Conclusion
Kadane’s Algorithm demonstrates linear runtime behavior, confirming its theoretical O(n) time complexity.
It is simple, efficient, and widely used for subarray problems due to its constant space usage.