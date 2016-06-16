package boolPack;

/* @author zengli  
 * @date 2015/12/1
 */
public class BoolPack {
	/**
	 * 0-1背包问题
	 * @param weights
	 * @param values
	 * @param capacity
	 * @return
	 */
	public static int[] boolPack(int[] weights, int[] values, int capacity){
	    //物品的个数即为重量数组的长度
		int count = weights.length ;
		//cost为最优代价数组
		int[][] cost = new int[count][] ;
		//solution为问题的最优解数组
		int[] solution = new int[count] ;

		cost = boolPackCost(weights, values, capacity) ;

		solution = boolPackSolution(cost, weights, capacity) ;

		return solution ;
	}

	/**
	 * 该方法用于返回背包问题的最优解代价矩阵
	 * @param weights
	 * @param values
	 * @return
	 */
	public static int[][] boolPackCost(int[] weights, int[] values, int capacity){
		int count = weights.length ;
		int[][] cost = new int[count][capacity+1] ;

		for(int j = 1 ; j <= weights[count-1]-1 ; j ++){
			cost[count-1][j] = 0 ;
		}

		for(int j = weights[count-1]; j < capacity+1 ; j ++){
			cost[count-1][j] = values[count-1] ;
		}

		for(int i = count-2 ; i >0 ; i --){
			for(int j = 0 ; j <= weights[i]-1 ; j ++){
				cost[i][j] = cost[i+1][j] ;
			}

			for(int j = weights[i] ; j < capacity+1 ; j ++){
				cost[i][j] = cost[i+1][j-weights[i]] + values[i] ;
				if(cost[i][j] < cost[i+1][j]) 
					cost[i][j] = cost[i+1][j] ;
			}
		}

		cost[0][capacity] = cost[1][capacity-weights[0]]+values[0] ;

		if(cost[0][capacity] < cost[1][capacity]) 
			cost[0][capacity] = cost[1][capacity] ;

		return cost ;
	}

	/**
	 * 该方法用于返回最优解数组
	 * @param cost
	 * @param weights
	 * @param capacity
	 * @return
	 */
	public static int[] boolPackSolution(int[][] cost, int[] weights, int capacity){
		int count = weights.length , j = capacity;
		int[] solution = new int[count] ;

		for(int i = 0 ; i < count-2 ; i ++){
			if(cost[i][j] == cost[i+1][j]) 
				solution[i] = 0 ;
			else{
				solution[i] = 1 ;
				j = j - weights[i] ;
			}
		}

		if(cost[count-1][j] == 0) 
			solution[count-1] = 0 ;
		else solution[count-1] = 1 ;

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
			if(max < array[i])
			    max = array[i] ;
		}
		return max ;
	}

}
