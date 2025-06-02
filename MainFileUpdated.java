import java.io.*;
import java.util.*;

public class MainFileUpdated {
    
    public static final int ARR_1_LEN = 5;
    public static final int ARR_2_LEN = 1000;
    public static final int ARR_3_LEN = 100000;
    public static final int BOUND = 50000;

    public static PrintWriter printer;
    
    public static int numCompArr1;
    public static int numCompArr2;
    public static int numCompArr3;
    
    public static int[] arr1;
    public static int[] arr2;
    public static int[] arr3;
    
    public static void main(String[] args) throws IOException {

        printer = new PrintWriter("analysis.csv");

        arr1 = new int[ARR_1_LEN];
        arr2 = new int[ARR_2_LEN];
        arr3 = new int[ARR_3_LEN];

        populateArrays();
        
       
        int searchTarget = -1; 

  
        numCompArr1 = linearSearch(arr1, searchTarget);
        numCompArr2 = linearSearch(arr2, searchTarget);
        numCompArr3 = linearSearch(arr3, searchTarget);
        printToFile("Linear Search: ");


        numCompArr1 = binarySearch(arr1, searchTarget);
        numCompArr2 = binarySearch(arr2, searchTarget);
        numCompArr3 = binarySearch(arr3, searchTarget);
        printToFile("Binary Search: ");



   
        numCompArr1 = selectionSort(arr1);
        numCompArr2 = selectionSort(arr2);
        numCompArr3 = selectionSort(arr3);
        printToFile("Selection Sort: ");


       
        populateArrays();

        numCompArr1 = bubbleSort(arr1);
        numCompArr2 = bubbleSort(arr2);
        numCompArr3 = bubbleSort(arr3);
        printToFile("Bubble Sort: ");


    
        populateArrays();

        numCompArr1 = mergeSort(arr1, 0, arr1.length-1);
        numCompArr2 = mergeSort(arr2, 0, arr2.length-1);
        numCompArr3 = mergeSort(arr3, 0, arr3.length-1);
        printToFile("Merge Sort: ");


      

        populateArrays();

        numCompArr1 = quickSort(arr1, 0, arr1.length-1);
        numCompArr2 = quickSort(arr2, 0, arr2.length-1);
        numCompArr3 = quickSort(arr3, 0, arr3.length-1);
        printToFile("Quick Sort: ");
        
        printer.close();
        
    }


public static int bubbleSort(int arr[]) {
  boolean madeASwap = true;
  int comparison = 0;
  for (int maxID = arr.length - 1; maxID > 0 && madeASwap; maxID--) {
      madeASwap = false;
      for (int index = 0; index < maxID; index++) {
          comparison++; 

          if (arr[index] > arr[index + 1]) {
              int temp = arr[index];
              arr[index] = arr[index + 1];
              arr[index + 1] = temp;
              madeASwap = true;
          }
      }
  }
  return comparison; 
}
public static int storageOperations = 0;

public static int mergeSort(int arr[], int l, int r) {
  int operations = 0; 

  if (l < r) {
    int m = l + (r - l) / 2;

    
    operations += mergeSort(arr, l, m);
    operations += mergeSort(arr, m + 1, r);

    
    operations += merge(arr, l, m, r);
  }

  
  return operations;
}

public static int merge(int arr[], int p, int q, int r) {
  int operations = 0; 

  int n1 = q - p + 1;
  int n2 = r - q;

  int[] L = new int[n1];
  int[] M = new int[n2];

  
  for (int i = 0; i < n1; i++) {
    L[i] = arr[p + i];
    operations++; 
  }
  for (int j = 0; j < n2; j++) {
    M[j] = arr[q + 1 + j];
    operations++; 
  }

  int i = 0, j = 0, k = p;

  while (i < n1 && j < n2) {
    if (L[i] <= M[j]) {
      arr[k] = L[i];
      i++;
    } else {
      arr[k] = M[j];
      j++;
    }
    operations++; 
    k++;
  }


  while (i < n1) {
    arr[k] = L[i];
    i++;
    k++;
    operations++;
  }

  while (j < n2) {
    arr[k] = M[j];
    j++;
    k++;
    operations++;
  }

  
  return operations;
}

    public static int linearSearch(int[] arr, int target) {
        int numComp = 0;
        for(int i = 0; i < arr.length; i++) {
            numComp++;
            if(arr[i] == target)
                return numComp;
        }
        return numComp;
    }

    public static int binarySearch(int[] arr, int value) {
        int numComp = 0,
        first = 0,           
        last = arr.length - 1,  
        middle; 

        while (first <= last) {
            numComp++;
            middle = (first + last) / 2;    
            if (arr[middle] == value)     
                return numComp; 
            else if (arr[middle] > value) 
                last = middle - 1;
            else
                first = middle + 1;         
        }
        return numComp;
    }


    public static int selectionSort(int arr[]){
        int minIndex, minValue, numComp = 0;
        for (int start = 0; start < (arr.length - 1); start++){
           minIndex = start;
           minValue = arr[start];
           for (int index = start + 1; index < arr.length; index++){
              numComp++;
              if (arr[index] < minValue){
                 minValue = arr[index];
                 minIndex = index;
              }
           }
           int temp = arr[minIndex];
           arr[minIndex] = arr[start];
           arr[start] = temp;
        }
        return numComp;
    }


    public static int quickSort(int arr[], int start, int end) {

        int numComp = 0;

        if (start < end) {
     
          int[] result = partition(arr, start, end);
          int pivot = result[0];
          numComp += result[1];
     
             
          numComp += quickSort(arr, start, pivot - 1);
             
     
          numComp += quickSort(arr, pivot + 1, end);
        }
        return numComp;
    }


    public static int[] partition(int arr[], int start, int end) {

        int numComp = 0;

        int pivotValue = arr[start];
        int pivotPosition = start;
     
        
        for (int pos = start + 1; pos <= end; pos++) {
            
            numComp++;
            if (arr[pos] < pivotValue) {  
                
                int temp = arr[pivotPosition+1];
                arr[pivotPosition+1] = arr[pos];
                arr[pos] = temp;
     
               
                temp = arr[pivotPosition+1];
                arr[pivotPosition+1] = arr[pivotPosition];
                arr[pivotPosition] = temp;
     
                pivotPosition++;
            }
       }	

       int[] result = {pivotPosition, numComp};
       return result;
    }

    public static void populateArrays() {
        Random rand = new Random();

        for( int i = 0; i < ARR_1_LEN; i++)
            arr1[i] = rand.nextInt(BOUND);

        for( int i = 0; i < ARR_2_LEN; i++)
            arr2[i] = rand.nextInt(BOUND);
        
        for( int i = 0; i < ARR_3_LEN; i++)
            arr3[i] = rand.nextInt(BOUND);
    }

    
    public static void printToFile( String algo ) 
                           throws IOException{
        printer.println(algo);
        printer.println("# Elements: , # Operations: ");
        printer.println(ARR_1_LEN + ", " + numCompArr1);
        printer.println(ARR_2_LEN + ", " + numCompArr2);
        printer.println(ARR_3_LEN + ", " + numCompArr3);
        printer.println();
    }

}