import java.util.Random;

public class SortTestHelper {
	/**
	 * 生成n个元素的随机数组
	 * @param n
	 * @param rangL
	 * @param rangR
	 * @return
	 */
	public static Integer[] generateRandomArray(int n,int rangL,int rangR){
		if(rangR<rangL){
			return null;
		}
		Random random = new Random();
		Integer[] nums = new Integer[n];
		int num = rangR-rangL;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rangL+random.nextInt(num);
		}
		return nums;
	}
}
