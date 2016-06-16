package test;

/* @author zengli  
 * @date 2015/12/1
 */
//import java.util.Arrays;
import java.util.Random;

import boolPack.BoolPack;

public class BoolPackTest {
	
	public static Random random = new Random() ;

	public static void main(String[] args) {
		//记录当前系统时间，并转换为毫秒级别
		long begintime = System.currentTimeMillis();
		int count = 100 ;//100/1000/10000
		int[] weights = new int[count] ;  //物品重量
		int[] values = new int[count] ;   //物品价值量
		int capacity = -1 ;   //背包容量
		
		//初始化物品重量和价值量
		for(int i = 0 ; i < weights.length ; i ++){
			weights[i] = random.nextInt(1000)+1 ; //(1~1000)/(1~100000)/(1~10000000)
		}
		for(int i = 0 ; i < values.length ; i ++){
			values[i] = random.nextInt(1000)+1 ;
		}
		
		capacity = random.nextInt(1000-getMax(weights)+1)+getMax(weights) ;
		
		int[] solution = new int[count] ;
		
		solution = BoolPack.boolPack(weights, values, capacity) ;
		
		System.out.println("运行结果如下：");
		System.out.println("背包容量："+capacity);
		System.out.println("物品个数："+count);
		
		System.out.println("物品重量：");
		//每十个数换行输出，数与数之间用空格隔开
		for(int i =1;i<count+1;i++){
			if(i%10==0){
				System.out.println((weights[i-1]));
			}else{
				System.out.print((weights[i-1]+"    "));
				}
			} 
		System.out.println();
	  //System.out.println(Arrays.toString(weights));
		
		System.out.println("物品价值量：");
		//每十个数换行输出，数与数之间用空格隔开
		for(int i =1;i<count+1;i++){
			if(i%10==0){
				System.out.println((values[i-1]));
			}else{
				System.out.print((values[i-1]+"    "));
				}
			}
		System.out.println();
	  //System.out.println(Arrays.toString(values));
		
		System.out.println("****************************************");
		System.out.println("背包问题的最优解为:");
		//每十个数换行输出，数与数之间用空格隔开
		for(int i =1;i<count+1;i++){
			if(i%10==0){
				System.out.println((solution[i-1]));
			}else{
				System.out.print((solution[i-1]+"   "));
				}
			}
		System.out.println();
	  //System.out.println(Arrays.toString(solution));
		System.out.println("****************************************");
		//记录当前系统时间，并转换为毫秒级别
		long endtime = System.currentTimeMillis();
		//计算算法运行时间
		long runtime = endtime-begintime;
		System.out.println("算法的运行时间为: "+runtime+"ms.");

	}

	
	/**
	 * 该方法用于返回数组array中的最大值
	 * @param array
	 * @return
	 */
	public static int getMax(int[] array){
		int max = -1 ;
		for(int i = 0 ; i < array.length ; i ++){
			if(max < array[i]) max = array[i] ;
		}
		return max ;
	}
	
	
}
