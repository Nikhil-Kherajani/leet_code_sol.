class Solution {
	public:
		int trap(vector<int>& height) 
		{
			vector<int> left;
			vector<int> right(height.size());
			int maxi=height[0];
			for(int i=0;i<height.size();i++)
			{
			   if(maxi<height[i])
				   maxi=height[i];
			   left.push_back(maxi); 
			}
			maxi=height[height.size()-1];
			for(int i=height.size()-1;i>=0;i--)
			{
				if(maxi<height[i])
				   maxi=height[i];
				right[i]=maxi;
			}
			long int water=0;
			for(int i=0;i<height.size();i++)
			{
				water+=(min(left[i],right[i])-height[i]);
			}
			return water;
		}
	};