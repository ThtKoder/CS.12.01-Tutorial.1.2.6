import java.util.Arrays;

public class Mountain {
    public static boolean isIncreasing(int[] arr, int stop){
        int count = 1;
        while(count < stop){
            if(arr[count] <= arr[count-1]){
                return false;
            }
            count++;
        }
        return true;
    }


    public static boolean isDecreasing(int[] arr, int start){
        int count = start+1;
        while(count < arr.length){
            if(arr[count] >= arr[count-1]){
                return false;
            }
            count++;
        }
        return true;
    }

    public static int getPeakIndex(int[] arr){
        int count = 1;

        while(count < arr.length-1){
            if(arr[count] > arr[count-1] && arr[count] > arr[count+1]){
                return count;
            }
            count++;
        }
        return -1;
    }

    public static boolean isMountain(int[] arr){
        //note, commented out sys.out.println used to debug code

        int peakIndex = getPeakIndex(arr);

        if(arr.length <= 2){
            return false;
        } else if(peakIndex == 0 || peakIndex == -1){
            return false;
        }

        if(!isIncreasing(arr, peakIndex)){
            //System.out.println("IsIncreasing False");
            return false;
        }
        //System.out.println("isIncreasing True");

        int[] decreasingarr = new int[arr.length-peakIndex];

        for(int i = 0; i < decreasingarr.length; i++){
            decreasingarr[i] = arr[peakIndex+i];
        }

        //System.out.println(Arrays.toString(decreasingarr));

        if(!isDecreasing(decreasingarr, peakIndex-1)){
            //System.out.println("isDecreasing False");
            return false;
        }

        //System.out.println("isDecreasing True");

        return true;
    }
}
