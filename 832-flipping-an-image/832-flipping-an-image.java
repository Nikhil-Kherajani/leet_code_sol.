class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int a[]:image){
            reverseArr(a);
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                image[i][j]=invert(image[i][j]);
            }
        }
        
        return image;
    }
    static void reverseArr(int[] arr){
        for(int i=0,j=arr.length-1;i<arr.length/2;i++,j--){
            swap(arr,i,j);
        }
        
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static int invert(int a){
        if(a==0){
            return 1;
        }
        return 0;
    }
}