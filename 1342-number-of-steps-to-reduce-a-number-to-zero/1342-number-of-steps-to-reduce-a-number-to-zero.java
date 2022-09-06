class Solution {
public int numberOfSteps(int num) {
int res= helper(num,0);
return res;

}
public int helper(int num,int c){
    if(num==0){
        return c;
    }
      if(num%2==0){
        return helper(num/2,c+1);
    }
    else{
        return helper(num-1,c+1);
    }
}
}