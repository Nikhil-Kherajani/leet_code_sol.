class Solution{

public int findRadius(int[] houses, int[] heaters) {

	int res = Integer.MIN_VALUE;
	Arrays.sort(heaters);

	for (int house: houses)
		res = Math.max(Math.abs(heaters[nearestNumber(house, heaters)] - house), res);

	return res;
}
static int nearestNumber(int n, int[] a) {
	int low = 0;
	int high = a.length - 1, nearestIndex = 0;
	int distance = Integer.MAX_VALUE;

	while (low<= high) {

		int mid = low + (high - low) / 2;

		if (distance > Math.abs(a[mid] - n)) {

			distance = Math.abs(a[mid] - n);
			nearestIndex = mid;
		}

		if (a[mid] == n) return mid;

		else if (n<a[mid]) high = mid - 1;

		else low = mid + 1;
	}
	return nearestIndex;

}
}