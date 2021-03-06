package lili.sorting;

/**
 * Created by lili on 2015/3/11.
 * 希尔排序的诞生是由于插入排序在处理大规模数组的时候会遇到需要移动太多元素的问题。
 * 希尔排序的思想是将一个大的数组“分而治之”，划分为若干个小的数组，以 gap 来划分，
 * 比如数组 [1, 2, 3, 4, 5, 6, 7, 8] ，如果以 gap = 2 来划分，可以分为 [1, 3, 5, 7]
 * 和 [2, 4, 6, 8] 两个数组（对应的，如 gap = 3 ，则划分的数组为： [1, 4, 7] 、 [2, 5, 8] 、 [3, 6] ）
 * 然后分别对划分出来的数组进行插入排序，待各个子数组排序完毕之后再减小 gap 值重复进行之前的步骤，
 * 直至 gap = 1 ，即对整个数组进行插入排序，此时的数组已经基本上快排好序了，
 * 所以需要移动的元素会很小很小，解决了插入排序在处理大规模数组时较多移动次数的问题。

 具体实例请参照插入排序。

 希尔排序是插入排序的改进版，在数据量大的时候对效率的提升帮助很大，数据量小的时候建议直接使用插入排序就好了。

 原理：增量缩小排序，先将序列按增量划分为元素个数相同的若干组，使用直接插入排序法进行排序，
 然后不断缩小增量直至为1，最后使用直接插入排序完成排序。
 */
public class ShellSort implements SortUtil.Sort{

	/** (non-Javadoc)
	  */
	public void sort(int[] data) {
		for(int i=data.length/2;i>2;i/=2){
			for(int j=0;j<i;j++){
				insertSort(data,j,i);
			}
		}
		insertSort(data,0,1);
	}

	/**
	 * @param data
	 * @param start
	 * @param inc
	 */
	private void insertSort(int[] data, int start, int inc) {
		int temp;
		for(int i=start+inc;i<data.length;i+=inc){
			for(int j=i;(j>=inc)&&(data[j]<data[j-inc]);j-=inc){
				SortUtil.swap(data,j,j-inc);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{38,17, 16, 16, 7, 31, 39, 32, 2, 11};
		SortUtil.Sort sort = new ShellSort();
		sort.sort(arr);
		System.out.println("after shell sorting:" + arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
	}
}
