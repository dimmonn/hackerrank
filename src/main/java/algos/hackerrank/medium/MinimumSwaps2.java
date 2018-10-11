package algos.hackerrank.medium;

public class MinimumSwaps2 {
    static int minimumSwaps(int[] arr) {
        int swaps=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                int tmp = arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=tmp;
                swaps++;
                i--;
            }
        }
        return swaps;
    }
}
