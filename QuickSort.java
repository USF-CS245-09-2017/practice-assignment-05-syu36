/**
 *
 * Implements SortingAlgorithm interface and contains a sort method using quick sort.
 *
 */
public class QuickSort implements SortingAlgorithm {

	@Override
	public void sort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	/**
	 * Quick sort method. Recursively calls itself, sorting the left and the right sides recursively.
	 * @param arr the array to sort
	 * @param left the left index
	 * @param right the right index
	 */
	private void quicksort (int[] arr, int left, int right) {
		// base case
		if (left < right) {
			int p = partition(arr, left, right);
			quicksort(arr, left, p - 1);
			quicksort(arr, p + 1, right);
		}
	}

	/**
	 * Helper method that partitions (splits) the array by using the first element as a pivot
	 * @param arr the array to sort
	 * @param left the left index
	 * @param right the right index
	 * @return the middle index (where the partition happened)
	 */
	private int partition (int[] arr, int left, int right) {
		if (left < right) {
			int pivot = left;
			int i = left + 1; // Avoids re-sorting the pivot
			int j = right;
			while (i < j) {
				while (i <= right && arr[i] <= arr[pivot]) {
					i++;
				}
				while (j >= i && arr[j] > arr[pivot]) {
					j--;
				}
				if (i <= right && i < j) {
					swap(arr, i, j);
				}
			}
			swap(arr, pivot, j);  // pivot to the middle
			return j;
		}
		return left;
	}


	/**
	 * Swaps two elements in an array
	 * @param a the array
	 * @param i the first index to swap
	 * @param j the second index to swap
	 */
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
