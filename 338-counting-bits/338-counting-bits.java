class Solution {
public int[] countBits(int n) {
int[] ans = new int[n + 1];
for(int i = 0;i<=n;i++)
{
int c =0;
int a = i;
while(a>0)
{
c++;
a = a &(a-1);
// a = a - (a & -a);
}
ans[i] = c;
}
return ans;
}
}