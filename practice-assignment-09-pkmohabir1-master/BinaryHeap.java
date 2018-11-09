
public class BinaryHeap{
	private int [] arr = new int[1000000];
	private int size;

	public BinaryHeap(){
		size = 0;
	}

	public void add(int pri){
		if(size >= arr.length){
			grow_array();
		}
		arr[size]=pri;
		++size;
		int index = size -1;
		int parent = (index-1)/2;
		while(index > 0 && arr[index] < arr[parent]){
			swap(arr, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}

	public int remove(){
		int pri = arr[0];
		arr[0] = arr[size-1];
		size=size-1;
		shiftDown(0);
		return pri;
	}

	public void shiftDown(int parent){
		int child = parent*2+1;
		//BASE CASE
		if(child > size){
			return;
		}
		if(arr[child+1] < arr[child]){
			child++;
		}
		if(arr[child] < arr[parent]){
			swap(arr, child, parent);
			shiftDown(child);
		}

	}

	public void swap (int [] arr, int child, int parent){
		int temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
	}

	public void grow_array(){
		int[] newArr = new int[arr.length*2];
		for(int i = 0; i < arr.length; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;

	}


}
