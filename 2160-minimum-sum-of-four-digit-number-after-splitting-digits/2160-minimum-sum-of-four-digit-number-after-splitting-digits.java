  class Solution {
public int minimumSum(int num) {   
int[] now= new int[4];
    int j=0;
    while(num>0){
        int temp=num%10;
        num=num/10;
        now[j]=temp;
        j++;
    }
    Arrays.sort(now);
  String one=""+ now[0] +now[2];
    String two=""+ now[1] +now[3];
    int fir= Integer.valueOf(one);
    int sec= Integer.valueOf(two);
    return fir+sec;
} 
}