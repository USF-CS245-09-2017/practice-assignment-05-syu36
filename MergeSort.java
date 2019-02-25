import java.util.Arrays;

/**
 *
 * Implements SortingAlgorithm interface and contains a sort method using merge sort.
 *
 */
public class MergeSort implements SortingAlgorithm {

	@Override
	public void sort(int[] a) {
		int[] left = getLeft(a);
		int[] right = getRight(a);
		if (left.length > 1) {
			sort(left);
		}
		if (right.length > 1) {
			sort(right);
		}
		merge(a, left, right);
	}

	/**
	 * Merges two arrays together, sorting as they merge
	 * @param array the array to sort
	 * @param left the left split of the array
	 * @param right the right split of the array
	 */
	private void merge(int[] array, int[] left, int[] right) {
		int lefti = 0;
		int righti = 0;
		int arrayi = 0;
		while (lefti < left.length && righti < right.length) {
			if(left[lefti] <= right[righti]) {
				array[arrayi++] = left[lefti++];
			} else {
				array[arrayi++] = right[righti++];
			}
		}

		while (lefti < left.length) {
			array[arrayi++] = left[lefti++];
		}

		while (righti < right.length) {
			array[arrayi++] = right[righti++];
		}
	}

	/**
	 * Helper method to return the left half of an array
	 * @param array the array
	 * @return the right half of the array
	 */
	private int[] getLeft(int[] array) {
		return Arrays.copyOfRange(array, 0, array.length / 2);
	}

	/**
	 * Helper method to return the right half of an array
	 * @param array the array
	 * @return the right half of the array
	 */
	private int[] getRight(int[] array) {
		return Arrays.copyOfRange(array, array.length / 2, array.length);
	}
}
