
public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
	public LinkedList() {
		head = current = null;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public void findFirst() {
		current= head;
	}
	
	public void findNext() {
		current= current.next;
	}
	
	public boolean last() {
		return current.next == null;		
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public void update(T e) {
		current.data= e;
	}
	
	public void insert(T e) {
		Node<T> temp;
		if(empty()) 
			current= head= new Node<T> (e);
		else {
			temp= current.next;
			current.next= new Node<T> (e);
			current= current.next;
			current.next= temp;
		}
	}
	
	public void remove() {
		if(empty())
			return;
		if(current == head)
			head= head.next;
		else {
			Node<T> temp= head;
			while(temp.next != current) 
				temp= temp.next;
			temp.next= current.next;
		}
		if(current.next == null)
			current= head;
		else
			current= current.next;
	}
	
	//Searches for the first element that satisfies a condition. 
	//If found, it is set as current and true is returned, 
	//otherwise current remains unchanged and false is returned. 
	//The condition is tested using cnd.
	public boolean findFirstEle(Cond<T> cnd) {
		if(empty())
			return false;
		Node<T> temp= head;
		while(temp != null) {
			if(cnd.test(temp.data)) {
				current= temp;
				return true;
			}
			temp= temp.next;
		}
		return false;
	}
	
	//Searches and returns all elements that satisfy a condition. 
	//If none is found, the empty list is returned. 
	//This method does not change current. 
	//The condition is tested using cnd.
	public List<T> findAllEle(Cond<T> cnd){
		LinkedList<T> list= new LinkedList<T>();
		if(empty())
			return list;
		Node<T> temp= head;
		while(temp != null) {
			if(cnd.test(temp.data))
				list.insert(temp.data);
			temp= temp.next;
		}
		return list;
	}
}
