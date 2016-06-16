package boolPack;

/* @author zengli  
 * @date 2015/12/1
 */
public class ApproxBoolPack {
	public static int[] approBoolPack(int[] weights, int[] values, int capacity, double percent){
		int count = weights.length ;
		int[] solution = new int[count] ;
		double k = 1.0*count/percent ;
		
		int maxValue = getMax(values) ;
		
		for(int i = 0 ; i < values.length ; i ++){
			values[i] = (int)(values[i]*k/maxValue) ;
		}
		
		solution = BoolPack.boolPack(weights, values, capacity) ;
		return solution ;
		
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
