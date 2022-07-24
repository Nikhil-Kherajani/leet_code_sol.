class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        	auto output = nums1.rbegin();
	auto first1 = std::next(nums1.rbegin(), n), last1 = nums1.rend();
	auto first2 = nums2.rbegin(), last2 = nums2.rend();
	while (first1 != last1 && first2 != last2)
	{
		*output++ = *first1 > *first2 ? *first1++ : *first2++;
	}
        
	std::copy(first1, last1, output);
	std::copy(first2, last2, output);
        
    }
};