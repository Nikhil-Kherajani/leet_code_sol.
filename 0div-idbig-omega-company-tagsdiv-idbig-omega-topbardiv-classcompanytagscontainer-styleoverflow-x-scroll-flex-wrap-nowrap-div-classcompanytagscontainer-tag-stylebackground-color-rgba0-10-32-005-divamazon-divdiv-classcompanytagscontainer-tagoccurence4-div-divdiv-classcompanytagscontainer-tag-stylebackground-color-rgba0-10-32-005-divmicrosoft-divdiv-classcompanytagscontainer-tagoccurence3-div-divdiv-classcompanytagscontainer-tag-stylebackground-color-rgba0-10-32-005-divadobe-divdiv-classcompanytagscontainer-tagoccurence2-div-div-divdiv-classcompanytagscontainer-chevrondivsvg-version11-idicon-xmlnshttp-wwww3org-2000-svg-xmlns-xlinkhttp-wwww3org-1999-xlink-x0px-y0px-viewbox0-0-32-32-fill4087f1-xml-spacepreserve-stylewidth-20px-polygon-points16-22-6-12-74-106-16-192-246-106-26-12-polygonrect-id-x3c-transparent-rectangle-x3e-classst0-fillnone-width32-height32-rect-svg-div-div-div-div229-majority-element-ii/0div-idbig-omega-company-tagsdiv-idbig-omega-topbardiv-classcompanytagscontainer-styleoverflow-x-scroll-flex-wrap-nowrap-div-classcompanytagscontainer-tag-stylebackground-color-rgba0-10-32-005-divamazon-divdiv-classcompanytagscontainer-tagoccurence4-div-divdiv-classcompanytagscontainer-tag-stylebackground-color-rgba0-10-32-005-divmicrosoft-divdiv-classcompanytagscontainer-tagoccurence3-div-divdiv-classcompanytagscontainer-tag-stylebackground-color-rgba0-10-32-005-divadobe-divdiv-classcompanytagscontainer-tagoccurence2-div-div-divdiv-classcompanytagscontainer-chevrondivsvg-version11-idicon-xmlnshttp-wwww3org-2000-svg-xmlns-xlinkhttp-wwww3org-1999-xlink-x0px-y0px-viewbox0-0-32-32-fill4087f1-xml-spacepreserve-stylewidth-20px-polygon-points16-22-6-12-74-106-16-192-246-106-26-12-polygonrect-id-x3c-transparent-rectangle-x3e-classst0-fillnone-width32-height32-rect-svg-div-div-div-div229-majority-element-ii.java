class Solution {
    public List<Integer> majorityElement(int[] nums) {
	List<Integer> result = new ArrayList<Integer>();
	if (nums.length == 0)
		return result;
	// In the begining, both Trump and Biden don't get a vote
	int firstMajor = Integer.MAX_VALUE, firstSum = 0, secondMajor = Integer.MIN_VALUE, secondSum = 0;
	
	for (int i = 0; i < nums.length; i++) {
		// case 1: I want to vote for Biden or Trump
		if (nums[i] == firstMajor)
			firstSum++;
		else if (nums[i] == secondMajor)
			secondSum++;
		// case 2: I want to run for the president
		else if (firstSum == 0) {
			firstMajor = nums[i];
			firstSum = 1;
		}
		else if (secondSum == 0) {
			secondMajor = nums[i];
			secondSum = 1;
		}
		// case 3: fuck sleepy Joe and crazy Trump, let James be the president
		else {
			firstSum--;
			secondSum--;
		}
	}
	// After election, we need to count the vote again.
	firstSum = 0;
	secondSum = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] == firstMajor)
			firstSum++;    
		else if (nums[i] == secondMajor)
			secondSum++;
	}
	if (firstSum > nums.length / 3)
		result.add(firstMajor);
	if (secondSum > nums.length / 3)
		result.add(secondMajor);
	return result;
}
}