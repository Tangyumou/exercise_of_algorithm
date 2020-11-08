package digitArithmetic;

import java.util.Scanner;

/**
 * 6.2判断一个数是否是2的n次方
 * 该算法时间复杂度为O(1),好于常规算法O(log n)
 * @Author TangQinwei
 * @Date 2020/11/8
 */

public class Is2ToTheNthPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int n = scanner.nextInt();
        //2的n次方2进制为000010000...,只有1位为1，建议后为000001111...,两者与运算后结果为0
        int result = n&(n-1);
        if(result==0){
            System.out.println(n+"是2的n次方");
        }else{
            System.out.println(n+"不是2的n次方");
        }
    }
}
