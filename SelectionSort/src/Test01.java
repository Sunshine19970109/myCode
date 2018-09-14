import java.util.Arrays;
import java.util.Comparator;

public class Test01 {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1,5,6,3,8,9,12,4};
		mySort(arr);
		System.out.println(Arrays.toString(arr));

	}
	public static<T extends Comparable<T>> void mySort(T[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i].compareTo(arr[j])>0){
					T temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}
