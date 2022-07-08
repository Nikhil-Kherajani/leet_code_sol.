class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
     int h=0;
for(int i=0;i<nums.size();i++){
if(nums[i]==val){
h++;
}
}
int t=0;
for(int i=0;i<nums.size();i++){
if(nums[i]!=val){
nums[t]=nums[i];
t++;
}
}
return nums.size()-h;   
    }
};


