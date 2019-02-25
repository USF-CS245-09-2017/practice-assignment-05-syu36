import java.util.Arrays;

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

	private int[] getLeft(int[] array) {
		return Arrays.copyOfRange(array, 0, array.length / 2);
	}

	private int[] getRight(int[] array) {
		return Arrays.copyOfRange(array, array.length / 2, array.length);
	}
}
