import java.util.ArrayList;
import java.util.List;


public class ArrOperation {

	/**
	 * @param arr array of positive numbers
	 * @return size of the largest mirror section of arr
	 */
	public static int maxMirror(int arr[]){
		int max = 0, count = 0;              //char that hold max of the count
		if(arr.length != 0){            //check array is empty
			for(int i = 0; i<=arr.length-1; i++)
			{
				for(int j = i+1; j <=arr.length-1; j++)
				{
					if(arr[i] == arr[j])  //comparing each number with ever other to find a match
					{
						for(int k = i, l = j; k <= l; k++, l--)
							            //to find the length of the mirror
						{
							if(arr[k] == arr[l])
							{
								count++;
								if(k == l)
									count=count*2-1;
							}
							else{
								break;
							}
						}
						if(count > max)
						{
							max = count;     //updating max with the maximum of count
						}
						count = 0;
					}
				}
			}
			return max;                    //value of max mirror
		}else
			throw new AssertionError("Array is empty");
	}
	
	/**
	 * @param arr array of positive numbers 
	 * @return  number of clumps in arr
	 */
	public static int countClumps(int arr[]) 
	{
		int current = -1, clump = 0;
		if(arr.length != 0){             //check array is empty
			for(int i = 0; i < arr.length - 1; i++) 
			{
				if(arr[i] == arr[i + 1] && arr[i] != current) 
				{
					current = arr[i];    //store current value
					clump++;             //increase clump value
				} 
				else 
				{
					if(arr[i] != current) 
					{
						current = -1;   //reset current value
					}
				}
			}
			return clump;
		}else
			throw new AssertionError("Array is empty");
	}
	
	/**
	 * @param arr array of positive numbers 
	 * split index there sum of numbers on one side is equal to sum of numbers on other side
	 * @return  split index if it exit else return -1
	 */
	public static int splitArray(int arr[]){
		if(arr.length != 0){                //check array is empty
			int sum1 = arr[0];                //set first value of array
			int sum2 = arr[arr.length-1];     //set last value of array
			int i = 1, j = arr.length-2;
			while(i <= j){
				                             //check for split index
				if(sum1 >= sum2){
					sum2 += arr[j];
					j--;
				}else if(sum2 > sum1){
					sum1 += arr[i];
					i++;
				}
			}
			if(sum1 == sum2 && j >= 0)       //check sum of both side
				return i;                    //return split index
			else
				return -1;
		}else
			throw new AssertionError("Array is empty");
	}
	
	/**
	 * @param arr array of positive numbers
	 * @param x is a number
	 * @param y is a number
	 * @return array in which x is followed by y
	 */
	public static int[] fixXY(int arr[], int x, int y){
		int count = 0;                                 //count of x in array
		List<Integer> xList = new ArrayList<Integer>();  //for storing indexes of x
		List<Integer> yList = new ArrayList<Integer>();  //for storing indexes of y
		if(arr.length != 0){                           //check array is empty
			for(int i = 0; i <arr.length; i++){
				if(arr[i] == x){
					xList.add(i);                      //store index of x
					count++;
				}else if(arr[i] == y)
					yList.add(i);                     //store index of y
			}
			if(xList.contains(arr.length-1)){         //check x on last index
				throw new AssertionError("X occurs at the last index");
			}
			for(int i = 0; i<count-1 ; i++){              //check two adjacent x
				if(xList.get(i)+1 == xList.get(i+1))
					throw new AssertionError(" two adjacent X values");
			}
			if(xList.size() == yList.size()){          //check equal x and y
				for(int i=0 ; i<count ; i++){
					                                  //swapping position of y in array
					int temp = arr[xList.get(i)+1];
					arr[xList.get(i)+1] = y;
					arr[yList.get(i)] = temp;
				}
				return arr;
			}else
				throw new AssertionError("unequal x & y");
		}else
			throw new AssertionError("Array is empty");
	}
}


