import java.util.Arrays;

public class ArrayDuplicates {

    public static void main(String[] args) {
        System.out.println("In main");
        int[] in = createInputArray(Integer.parseInt(args[0]));
        //System.out.println("inpput : "+Arrays.toString(in));
        long start = System.currentTimeMillis();
        System.out.println("Dup element is : "+duplicatesByNaive(in));
        long end = System.currentTimeMillis();
        System.out.println("time taken : "+ (end - start)/1000.0);
    }

    public static int[] createInputArray(int arraySize) {
        int[] testArray = new int[arraySize];
        int i;
        for(i=0; i<arraySize-1;i++) {
            testArray[i] = i+1;
        }
        testArray[i] = i;
        return testArray;
    }

    public static int duplicatesByNaive(int[] inputArray){
        for (int i=0; i< inputArray.length-1;i++){
            for(int j=i+1;j<inputArray.length; j++){
                if(inputArray[i] == inputArray[j]){
                    return inputArray[i];
                }
            }
        }
        return -1;
    }

    public static int duplicatesByArrayPattern(int [] inputArray) {
        byte[] referenceArray = new byte[inputArray.length];
        for (int i=0; i<inputArray.length;i++){
            if(referenceArray[inputArray[i]] == 0) {
                referenceArray[inputArray[i]] = 1;
            }
            else
                return inputArray[i];
        }
        return -1;
    }

    public static int duplicatesByInLineModification(int[] inputArray) {
        for(int i=0; i<inputArray.length;i++){
            int indexAt = Math.abs(inputArray[i]);
            if(inputArray[indexAt] < 0)
                return inputArray[i] < 0? inputArray[i] * -1:inputArray[i];
            else {
                inputArray[indexAt] = inputArray[indexAt] * -1;
            }
        }
        return -1;
    }



    public static int duplicatesBySortAndCompare(int[] inputArray) {
        Arrays.sort(inputArray);
        for(int i = 0; i<inputArray.length;i++) {
            if(inputArray[i] == inputArray[i+1])
                return inputArray[i];
        }
        return -1;
    }
}
