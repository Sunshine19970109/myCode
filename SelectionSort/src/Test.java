import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		
		Integer[] nums = SortTestHelper.generateRandomArray(11, 0, 10);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"   ");
		}
		System.out.println("开始");
		Student[] sts = new Student[110];
		selectionSort(sts, 10,sts[0] );
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"   ");
		}
		System.out.println("结束");
	}
	public static<T extends Comparator<T>>  Integer selectionSort(
			T[] arr,Integer n,Comparator<T> com){
		for(int i=0;i<n;i++){
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(com.compare(arr[minIndex],arr[j])<0){
					//记录下标
					minIndex = j;
				}
			}
			//交换
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return 0;
	}
}
