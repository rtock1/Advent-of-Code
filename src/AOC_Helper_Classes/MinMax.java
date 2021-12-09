package AOC_Helper_Classes;

public class MinMax {
    public static int min(int[] nums){
        int currMin = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]<currMin){
                currMin = nums[i];
            }
        }
        return currMin;
    }
    public static int max(int[] nums){
        int currMax = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]>currMax){
                currMax = nums[1];
            }
        }
        return currMax;
    }
    public static int minIndex(int[] nums){
        int currMin = nums[0];
        int index = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<currMin){
                currMin = nums[i];
                index = i;
            }
        }
        return index;
    }
    public static int maxIndex(int[] nums){
        int currMax = nums[0];
        int index = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>currMax){
                currMax = nums[i];
                index = i;
            }
        }
        return index;
    }
    public static int[] removeMin(int[] nums){
        int[] end = new int[nums.length-1];
        int minIndex = minIndex(nums);
        for (int i=0;i<nums.length;i++){
            if (i<minIndex){
                end[i] = nums[i];
            } else if (i>minIndex){
                end[i-1] = nums[i];
            }
        }
        return end;
    }
    public static int[] removeMax(int[] nums){
        int[] end = new int[nums.length-1];
        int maxIndex = maxIndex(nums);
        for (int i=0;i<nums.length;i++){
            if (i<maxIndex){
                end[i] = nums[i];
            } else if (i>maxIndex){
                end[i-1] = nums[i];
            }
        }
        return end;
    }
}
