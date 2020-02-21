package multiThreadedHS.util;

import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;


public class MergeSort{

/**
 * @param array and length of an array
 * This method performs mergesort and calls merge fubction
 * Citations: https://www.baeldung.com/java-merge-sort
 */  

public static synchronized Integer[] mergeSort(Integer[] a, int n) {
    if (n < 2) {
        return a;
    }
    int mid = n / 2;
    Integer[] l = new Integer[mid];
    Integer[] r = new Integer[n - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
 
    merge(a, l, r, mid, n - mid);

    try {
        Thread.sleep(400);
      }
      catch(Exception e) {
        System.out.println(e);
      }
    return a;
}


public static void merge(
  Integer[] a, Integer[] l, Integer[] r, int left, int right) {
  
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
}