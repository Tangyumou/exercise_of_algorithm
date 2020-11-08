package digitArithmetic;

import java.util.Scanner;

//6.1
//判断一个自然数是否是某个数的二次方，不能用平方根运算
public class IsPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int n = scanner.nextInt();
        boolean flag = isPower(n);
        if(flag){
            System.out.println(n+"是一个数的二次方");
        }else{
            System.out.println(n+"不是一个数的二次方");
        }
    }

    //用二分法，时间复杂度为O(log n),比O(n^(1/2))的算法要好
    private static boolean isPower(int n){
        int low = 1;
        int high = n;
        int mid;
        int power;
        while(low<=high){
            mid = (low+high)/2;
            power = mid*mid;
            if(power==n){
                return true;
            }else if(power<n){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
