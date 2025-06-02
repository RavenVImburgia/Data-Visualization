public class UpdatedFile1 {

    public int bubbleSort(int arr[]) {
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
}

