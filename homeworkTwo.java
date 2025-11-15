import java.util.Arrays;
import java.util.Random;



public class homeworkTwo{
    public static int swapCount = 0;
    //start of bubble sort implement

    public static void bubbleSort(int[] arr, int n) {
        if (n == 1) return; // Base case: one element is already sorted

        // One pass of bubble sort
        bubblePass(arr, 0, n);

        // Recursive call for remaining array
        bubbleSort(arr, n - 1);
    }

    private static void bubblePass(int[] arr, int i, int n) {
        if (i >= n - 1) return;

        if (arr[i] > arr[i + 1]) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            swapCount++;
        }

        bubblePass(arr, i + 1, n); // Continue inner pass
    }
    //gods chosen programer




    //start of insertion sort implement

    public static void insertionSort(int[] arr, int n) {
        if (n <= 1){
            return;
        }

        insertionSort(arr, n - 1);
        int last = arr[n - 1];
        insert(arr, n - 2, last);
    }

    private static void insert(int[] arr, int j, int value) {
        if (j < 0 || arr[j] <= value) {
            arr[j + 1] = value;
            swapCount++; 
            return;
        }
        arr[j + 1] = arr[j];
        swapCount++;
        insert(arr, j - 1, value);
    }

    //start of selection sort implement

    public static void selectionSort(int[] arr, int start) {
        if (start >= arr.length) {
            return;
        }

        int minIdx = findMin(arr, start + 1, start);
        int temp = arr[start];
        arr[start] = arr[minIdx];
        arr[minIdx] = temp;
        swapCount++;

        selectionSort(arr, start + 1);
    }

    private static int findMin(int[] arr, int i, int minIndex) {
        if (i >= arr.length) {
            return minIndex;
        }
        if (arr[i] < arr[minIndex]) minIndex = i;{
            return findMin(arr, i + 1, minIndex);
        }
    }
    //start of shell sort implement
    
    public static void shellSort(int[] arr, int gap) {
        if (gap == 0) {
            return;
        }
        gapInsertionSort(arr, gap, gap);
        shellSort(arr, gap / 2);
    }

    private static void gapInsertionSort(int[] arr, int i, int gap) {
        if (i >= arr.length) {
            return;
        }
        int temp = arr[i];
        shiftAndInsert(arr, i, gap, temp);

        gapInsertionSort(arr, i + 1, gap);
    }

    private static void shiftAndInsert(int[] arr, int j, int gap, int value) {
        if (j >= gap && arr[j - gap] > value) {
            arr[j] = arr[j - gap];
            swapCount++;
            shiftAndInsert(arr, j - gap, gap, value);
        } else {
            arr[j] = value;
            swapCount++;
        }
    }

    //start of merge sort implement
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        if (left.length == 0) {
            return right;
            }
        if (right.length == 0) {
            return left;
            }

        int[] merged;
        if (left[0] < right[0]) {
            merged = concat(new int[]{left[0]}, merge(Arrays.copyOfRange(left, 1, left.length), right));
        } else {
            merged = concat(new int[]{right[0]}, merge(left, Arrays.copyOfRange(right, 1, right.length)));
        }

        swapCount++;

        return merged;
    }

    private static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    

    public static int[] generateRandomArray(){
        Random random = new Random();
        int randomSize = random.nextInt(5000-50+1)+1;
        int[] array = new int [randomSize];        

        for(int i = 0; i < randomSize; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }


    public static void main(String[] args) {
   
    int newArray[] = generateRandomArray();
    long startTime, endTime;
    
    System.out.println("Array size: " + newArray.length);
    

    startTime = System.nanoTime();
    bubbleSort(newArray, newArray.length);
    endTime = System.nanoTime();
    System.out.println("Bubble sort: "+ (endTime - startTime) /1_000_000.0 + " milliseconds");
    System.out.println("Number of swaps: " + swapCount);
    swapCount = 0;

    startTime = System.nanoTime();
    insertionSort(newArray, newArray.length);
    endTime = System.nanoTime();
    System.out.println("Insertion sort: "+ (endTime - startTime) /1_000_000.0 + " milliseconds");
    System.out.println("Number of swaps: " + swapCount);
    swapCount = 0;

    startTime = System.nanoTime();
    selectionSort(newArray,0);
    endTime = System.nanoTime();
    System.out.println("Selection sort: "+ (endTime - startTime) /1_000_000.0 + " milliseconds");
    System.out.println("Number of swaps: " + swapCount);
    swapCount = 0;

    startTime = System.nanoTime();
    shellSort(newArray, newArray.length);
    endTime = System.nanoTime();
    System.out.println("Shell sort: "+ (endTime - startTime) /1_000_000.0 + " milliseconds");
    System.out.println("Number of swaps: " + swapCount);
    swapCount = 0;

    startTime = System.nanoTime();
    mergeSort(newArray);
    endTime = System.nanoTime();
    System.out.println("Merge sort: "+ (endTime - startTime) /1_000_000.0 + " milliseconds");
    System.out.println("Number of swaps: " + swapCount);
    
    }
}