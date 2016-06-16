package test;

/* @author zengli  
 * @date 2015/12/1
 */
//import java.util.Arrays;

import java.util.Random;

import boolPack.ApproxBoolPack;

public class ApproxBoolPackTest {
	public static Random random = new Random() ;
	 
	public static void main(String[] args) {
		//��¼��ǰϵͳʱ�䣬��ת��Ϊ���뼶��
		long begintime = System.currentTimeMillis();
		int count = 1000 ;//100/1000/10000
		int[] weights = new int[count] ;  //��Ʒ����
		int[] values = new int[count] ;   //��Ʒ��ֵ��
		int capacity = -1 ;   //��������
		double percent = 1 ;
		
		//��ʼ����Ʒ�����ͼ�ֵ��
		for(int i = 0 ; i < weights.length ; i ++){
			weights[i] = random.nextInt(1000)+1 ;
		}
		for(int i = 0 ; i < values.length ; i ++){
			values[i] = random.nextInt(1000)+1 ;
		}
		//��֤�������������ܹ�װ��һ����Ʒ
		capacity = random.nextInt(1000-getMax(weights)+1)+getMax(weights);
		
		System.out.println("���н�����£�");
		System.out.println("����������"+capacity);
		
		System.out.println("��Ʒ������"+count);
		System.out.println("��Ʒ������");
		//ÿʮ�������������������֮���ÿո����
		for(int i =1;i<count+1;i++){
			if(i%20==0){
				System.out.println((weights[i-1]));
			}else{
				System.out.print((weights[i-1]+"    "));
				}
			} 
		System.out.println();
	//	System.out.println(Arrays.toString(weights));
		
		System.out.println("��Ʒ��ֵ����");
		//ÿʮ�������������������֮���ÿո����
		for(int i =1;i<count+1;i++){
			if(i%20==0){
				System.out.println((values[i-1]));
			}else{
				System.out.print((values[i-1]+"    "));
				}
			} 
		System.out.println();
	//	System.out.println(Arrays.toString(values));
		
		int[] solution = new int[count] ;
		
		solution = ApproxBoolPack.approBoolPack(weights, values, capacity, percent) ;
		
		
		System.out.println("****************************************");
		System.out.println("��������Ľ����㷨�����Ž�Ϊ");
		//ÿʮ�������������������֮���ÿո����
		for(int i =1;i<count+1;i++){
			if(i%30==0){
				System.out.println((solution[i-1]));
			}else{
				System.out.print((solution[i-1]+"  "));
				}
			} 
		System.out.println();
	//	System.out.println(Arrays.toString(solution));
		System.out.println("****************************************");
		//��¼��ǰϵͳʱ�䣬��ת��Ϊ���뼶��
		long endtime = System.currentTimeMillis();
		//�����㷨����ʱ��
		long runtime = endtime-begintime;
		System.out.println("�㷨������ʱ��Ϊ:");	
		System.out.println(runtime+"ms.");
	}
	
	/**
	 * �÷������ڷ�������array�е����ֵ
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
