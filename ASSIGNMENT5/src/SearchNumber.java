
public class SearchNumber {
	
	/**
	 * @param arr array
	 * @param element for search in arr
	 * @return position of element in arr using linear search
	 */
	public static int linearSearch( int arr[], int element ){
		//start from first element
		int index = 0;
		if(arr[index] == element)
			return index + 1;
		else{
			if(arr.length > 1){
			//check size of array
			int[] dupArr=new int[arr.length-1];
			//duplicate array of size - 1 of arr
			for( int i = 0; i < dupArr.length; i++ )
				dupArr[i] = arr[i+1];
			return 1 + linearSearch(dupArr, element);
		}else
			//if element not found
			throw new AssertionError("element not found");
		}		
	}
	
	/**
	 * @param arr sorted array
	 * @param element for search in arr
	 * @return position of element in arr using binary search
	 */
	public static int binarySearch( int arr[], int element ){
		int midIndex = arr.length / 2;
		//mid index of array
		int startIndex = 0, lastIndex = 0;
		if( arr[midIndex] == element )
			return midIndex+1;
		else{
			if(arr.length > 1){
		    //check size of array
			if( arr[midIndex] > element ){
				//element greater than mid index number 
				startIndex = 0;
				lastIndex = midIndex;
			}else{
				//element smaller than mid index number 
				startIndex = midIndex + 1;
				lastIndex = arr.length;
			}
		}else
			throw new ArrayIndexOutOfBoundsException("element not found");
		}
		int[] dupArr = new int[lastIndex - startIndex];
		//duplicate array for search element
		for( int i = 0; i < dupArr.length; i++)
			dupArr[i] = arr[startIndex + i];
		return startIndex + binarySearch(dupArr, element);
	}

}
