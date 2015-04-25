package testsuite;

import heaps.HeapException;
import heaps.MaxHeap;

import java.io.IOException;
import java.util.Scanner;

public class HeapTestsuite {

  public static void main(String[] args) throws IOException {
    Scanner sr = new Scanner(System.in);
    while (sr.hasNext()) {
      Integer[] data_ = new Integer[1000];
      int next = 0;
      String[] strs = sr.nextLine().split(" ");
      for (String s : strs) {
        try {
          data_[next] = Integer.parseInt(s);
          next++;
        } finally {

        }
      }
      Integer[] data = new Integer[next];
      for (int i = 0; i < data.length; i++) data[i] = data_[i];
      heapSort(data);
    }

  }

  private static void heapSort(Integer[] data) {
    System.out.println("-----------------------------------");
    try {
      data = heapSortIteration(data);
    } catch (HeapException e) {
      System.out.println("Unknown error with heap!");
    }
    System.out.println("-----------------------------------");
  }

  private static Integer[] heapSortIteration(Integer[] data) throws HeapException {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();
    for (int i : data) {
      heap.insert(new Integer(i));
    }
    Integer[] out = heap.toArray();
    printArray(out);
    return out;
  }

  private static void printArray(Integer[] data) {
    StringBuilder s = new StringBuilder();
    s.append("HEAP:\n[");
    boolean comma = false;
    for (int i : data) {
      if (comma) {
        s.append(", " + i + " ");
      } else {
        s.append(" " + i + " ");
        comma = true;
      }
    }
    s.append("]");
    System.out.println(s.toString());
  }

}
