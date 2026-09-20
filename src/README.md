# Assignment 1: Divide-and-Conquer Algorithm Analysis

## A. Project Overview

This project implements and analyzes four divide-and-conquer algorithms:

- Merge Sort
- Randomized QuickSort
- Deterministic Select (Median-of-Medians)
- Closest Pair of Points

The program measures execution time using `System.nanoTime()`, maximum recursion depth, and the number of comparisons.

---

## B. Algorithm Analysis

### 1. Merge Sort

Merge Sort divides the array into two halves, recursively sorts both halves, and merges them into one sorted array.

**Recurrence:**

`T(n) = 2T(n/2) + O(n)`

Using the Master Theorem:

**Time Complexity:** `O(n log n)`  
**Space Complexity:** `O(n)`

### 2. QuickSort

QuickSort selects a random pivot, partitions the array around it, and recursively sorts the partitions. A randomized pivot reduces dependence on the original input order.

**Average recurrence:**

`T(n) = 2T(n/2) + O(n)`

**Average Time Complexity:** `O(n log n)`  
**Worst Time Complexity:** `O(n²)`  
**Space Complexity:** depends on recursion depth.

### 3. Deterministic Select

Deterministic Select finds the k-th smallest element without sorting the complete array. Elements are divided into groups of five and the median of medians is used as the pivot. Only the partition containing the required element is processed recursively.

**Recurrence:**

`T(n) ≤ T(n/5) + T(7n/10) + O(n)`

This guarantees:

**Worst-case Time Complexity:** `O(n)`

### 4. Closest Pair of Points

The points are sorted by their x-coordinate and recursively divided into two halves. After solving both halves, a strip around the dividing line is checked for a closer pair.

The divide-and-conquer approach avoids checking every possible pair for large datasets.

**Target Time Complexity:** `O(n log n)`  
**Brute-force Complexity:** `O(n²)`

---

## C. Experimental Results

The program uses `System.nanoTime()` to measure execution time.

For every algorithm, the following metrics are collected:

- Execution time in nanoseconds
- Maximum recursion depth
- Number of comparisons

Example output:

```text
MergeSort: time=26073000 ns, maxDepth=18, comparisons=1536211
QuickSort: time=32505400 ns, maxDepth=42, comparisons=2073912
Select: time=18538000 ns, maxDepth=17, comparisons=458932
ClosestPair: time=405990500 ns, maxDepth=17, comparisons=142715
```

Input generators were also implemented for:

- Random arrays
- Sorted arrays
- Reverse-sorted arrays
- Duplicate-heavy arrays
- Random points

---

## D. Discussion

The experiments demonstrate the main difference between divide-and-conquer algorithms and simpler approaches. Merge Sort and randomized QuickSort are designed for approximately `O(n log n)` performance, while Deterministic Select avoids sorting the entire input and guarantees linear worst-case selection.

The structure of the input can affect practical performance. Randomized pivot selection makes QuickSort less dependent on whether the original array is already sorted or reverse-sorted.

Median-of-Medians guarantees linear worst-case time because the selected pivot guarantees that a significant fraction of elements can be discarded after each partition.

For the Closest Pair problem, divide-and-conquer is more efficient for large datasets because it avoids comparing every pair of points as the `O(n²)` brute-force method does.

Practical execution time can differ from theoretical complexity because of JVM warm-up, memory allocation, garbage collection, CPU cache behavior, and random pivot selection.

---

## E. Reflection

This assignment helped me understand how divide-and-conquer algorithms split a large problem into smaller subproblems and combine their results. I also learned that theoretical complexity alone does not completely describe practical performance.

The main challenge was implementing recursion correctly while also collecting metrics such as recursion depth and comparisons. Implementing Median-of-Medians and Closest Pair was especially useful for understanding how careful problem division can improve worst-case performance.

---

## F. Project Structure

```text
src/
├── Main.java
├── MergeSort.java
├── QuickSort.java
├── DeterministicSelect.java
├── ClosestPair.java
├── Point.java
├── Result.java
└── Arraygenerator.java
```