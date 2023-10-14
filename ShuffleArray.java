/* Shuffle Array */
public class ShuffleArray {
    public static void main(String[] args) {
        final int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        ShuffleArrayClass shuffleArrayClass = new ShuffleArrayClass(nums);
        int[] shuffleArray = shuffleArrayClass.shuffleArray();
        shuffleArrayClass.print(shuffleArray);
    }
}

class ShuffleArrayClass {
    private final int[] nums;

    public ShuffleArrayClass(final int[] nums) {
        this.nums = nums;
    }

    public int[] shuffleArray() {
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int random = (int) (Math.random() * 10) % nums.length;
            int swap = clone[i];
            clone[i] = clone[random];
            clone[random] = swap;
        }
        return clone;
    }

    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i + 1 != nums.length) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[j] = nums[i];
        nums[i] = swap;
    }
}


