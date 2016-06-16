package boolPack;

/* @author zengli  
 * @date 2015/12/1
 */
public class BoolPack {
	/**
	 * 0-1��������
	 * @param weights
	 * @param values
	 * @param capacity
	 * @return
	 */
	public static int[] boolPack(int[] weights, int[] values, int capacity){
	    //��Ʒ�ĸ�����Ϊ��������ĳ���
		int count = weights.length ;
		//costΪ���Ŵ�������
		int[][] cost = new int[count][] ;
		//solutionΪ��������Ž�����
		int[] solution = new int[count] ;

		cost = boolPackCost(weights, values, capacity) ;

		solution = boolPackSolution(cost, weights, capacity) ;

		return solution ;
	}

	/**
	 * �÷������ڷ��ر�����������Ž���۾���
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
	 * �÷������ڷ������Ž�����
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
	 * �÷������ڷ�������array�е����ֵ
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
