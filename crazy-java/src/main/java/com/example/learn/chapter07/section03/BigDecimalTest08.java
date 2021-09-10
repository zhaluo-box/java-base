package com.zhaluobox.crazyjava.chapter07.section03;

import java.math.*;
/**
 * Description:
 * 1.double: 计算机的小数部分无法精确表示，因为0.9*2=1.8 , 0.8*2 = 1.6 ....永远除不尽。
 * 2.BigDecimal,不推荐使用double 的构造函数，应该使用"0.5" 或者BigDecimal.valueOf()
 * 3.推荐使用String来构造BigDecimal
 *
 * @version 1.0
 */
public class BigDecimalTest08
{
	public static void main(String[] args)
	{
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);  //丢失精度。。。double 无法精确表示浮点。



		System.out.println("使用String作为BigDecimal构造器参数：");
		System.out.println("0.05 + 0.01 = " + f1.add(f2));
		System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f1.divide(f2));

		System.out.println("使用double作为BigDecimal构造器参数：");
		System.out.println("0.05 + 0.01 = " + f3.add(f2));
		System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f3.divide(f2));
	}
}
