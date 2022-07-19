class Solution {
public:
    int mySqrt(int x) {
    long i = 1 ;
    while((i * i) <= x){    i++;    }
    return (i-1);
}
};