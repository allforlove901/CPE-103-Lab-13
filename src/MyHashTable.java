import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashTable<T> {

	LinkedList<T>[] arr;
	
	@SuppressWarnings("unchecked")
	public MyHashTable(int size){
		arr = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = new LinkedList<T>();
	}
	
	private int hash(T value){
		return Math.abs(value.hashCode())%arr.length;
	}
	
	public void insert(T value){
		int hashVal = hash(value);
		arr[hashVal].addFirst(value);
	}
	
	public void delete(T value){
		int hashVal = hash(value);
		if(arr[hashVal].contains(value)){
			arr[hashVal].remove(value);
			System.out.println(value + " deleted");
		}else
			System.out.println("element not in list");
	}
	
	public boolean find(T value){
		int hashVal = hash(value);
		return arr[hashVal].contains(value);
	}
	
	public boolean isEmpty(){
		for(LinkedList<T> list:arr)
			if(list.size() != 0)
				return false;
		return true;
	}
	
	public void print(){
		for(int i = 0; i<arr.length; i++){
			System.out.print(i + ":");
			for(T element:arr[i])
				System.out.print(" " + element.hashCode());
			System.out.println("\r");
		}
	}
	
	public void makeEmpty(){
		for(LinkedList<T> list: arr){
			list.clear();
		}
	}
	
	public int size(){
		int sum = 0;
		for(LinkedList<T> list: arr){
			sum += list.size();
		}
		return sum;
	}
	
	private class iter implements Iterator<T>{
		int i, j = 0;
		
		public iter(){
			if(isEmpty()){
				i = arr.length;
				j = 0;
			}else{
				for(int z = 0; z<arr.length; z++){
					if(arr[z].size() > 0){
						i = z;
						break;
					}
				}
			}
		}
		
		public boolean hasNext(){
			return i<arr.length;
		}
		
		public T next(){
			if(i == arr.length)
				throw new NoSuchElementException();
			T store = arr[i].get(j);
			if(j<arr[i].size()-1){
				j++;
			}else{
				i++;
				j=0;
				while(i != arr.length && arr[i].size() == 0)
					i++;
			}
			return store;
		}
		
		public void remove(){}
	}
	
	public Iterator<T> iterator(){
		return new iter();
	}
}
