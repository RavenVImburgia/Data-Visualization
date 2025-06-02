public class UpdatedFile2 {
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
}