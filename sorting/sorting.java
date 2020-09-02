package sorting;

import java.util.Random;

public class sorting {
  void randomArray(int arr[]) {
    Random r = new Random();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = r.nextInt(200);
    }
  }

  void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  void mergeSort(int arr[], int first, int last) {
    if (first < last) {
      int mid = (first + last) / 2;
      mergeSort(arr, first, mid);
      mergeSort(arr, mid + 1, last);
      merge(arr, first, mid, last);
    }
  }

  void merge(int arr[], int first, int mid, int last) {
    int firstHalf = mid - first + 1;
    int secondHalf = last - mid;
    int L[] = new int[firstHalf];
    int R[] = new int[secondHalf];
    for (int i = 0; i < firstHalf; i++)
      L[i] = arr[first + i];
    for (int j = 0; j < secondHalf; j++)
      R[j] = arr[mid + 1 + j];
    int i = 0, j = 0, k = first;
    while (i < firstHalf && j < secondHalf) {
      if (L[i] > R[j]) {
        arr[k] = R[j];
        j++;
        k++;
      } else {
        arr[k] = L[i];
        i++;
        k++;
      }
    }
    while (i < firstHalf) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < secondHalf) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
  void insertionSort(int arr[]){
    for(int i=1;i<arr.length;i++){
      int key = arr[i];
      int j = i-1;
      while(j>=0 && arr[j]>key){
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void main(String args[]) {
    sorting s = new sorting();
    int arr[] = new int[50];
    s.randomArray(arr);
    s.printArr(arr);
    s.mergeSort(arr, 0, arr.length - 1);
    s.printArr(arr);
    s.insertionSort(arr);
    s.printArr(arr);
  }
}