import java.util.NoSuchElementException;

/**
 *	SinglyLinkedList - (description)
 *
 *	@author	Aditi Chamarthy
 *	@since	April 29, 2024
 */
public class SinglyLinkedList<E extends Comparable<E>>
{
	/* Fields */
	private ListNode<E> head, tail;		// head and tail pointers to list
	
	/* No-args Constructors */
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
	/** Copy constructor */
	//Complete
	public SinglyLinkedList(SinglyLinkedList<E> oldList) {
		if(oldList.isEmpty()){
			head = null;
			tail = null;
		}
		head = oldList.get(0);
		tail = oldList.get(oldList.size()-1);
	}
	
	/**	Clears the list of elements */
	//Complete
	public void clear() {
		head = null;
		tail = null;
	}
	
	/**	Add the object to the end of the list
	 *	@param obj		the object to add
	 *	@return			true if successful; false otherwise
	 */
	 //Complete
	public boolean add(E obj) {
		ListNode<E> node = new ListNode<E>(obj);
		if(isEmpty()){
			head = tail = node;
		}
		else{
			tail.setNext(node);
			tail = node;
		}
		return true;
	}
	
	/**	Add the object at the specified index
	 *	@param index		the index to add the object
	 *	@param obj			the object to add
	 *	@return				true if successful; false otherwise
	 *	@throws NoSuchElementException if index does not exist
	 */
	 //Complete
	public boolean add(int index, E obj) {
		ListNode<E> node = new ListNode<E>(obj);
		//System.out.println(index + "    " + obj);
		if(index < 0 || index > size()){
			throw new NoSuchElementException();
		}
		if(index == 0){
			node.setNext(head);
			head = node;
			return true;
		}
		if(isEmpty()){
			return false;
		}
		if(index == size()){
			add(obj);
			return true;
		}
		int count = 0;
		ListNode<E> pre = head;
		while(count < index-1){
			pre = pre.getNext();
			count++;
		}
		node.setNext(pre.getNext());
		pre.setNext(node);
		return true;
	}
	
	/**	@return the number of elements in this list */
	//Complete
	public int size() {
		
		if(isEmpty()){
			return 0;
		}
		int count = 1;
		ListNode next = head.getNext();
		while(next != null){
			count++;
			next = next.getNext();
		}
		return count;
	}
	
	/**	Return the ListNode at the specified index
	 *	@param index		the index of the ListNode
	 *	@return				the ListNode at the specified index
	 *	@throws NoSuchElementException if index does not exist
	 */
	 //Complete
	public ListNode<E> get(int index) {
		int count = 0;
		if(isEmpty() || index < 0 || index > size()-1){
			throw new NoSuchElementException();
		}
		else{
			ListNode<E> now = head;
			while(count < index){
				now = now.getNext();
				count++;
			}
			return now;
		}
	}
	
	/**	Replace the object at the specified index
	 *	@param index		the index of the object
	 *	@param obj			the object that will replace the original
	 *	@return				the object that was replaced
	 *	@throws NoSuchElementException if index does not exist
	 */
	 //Complete
	public E set(int index, E obj) {
		if(isEmpty() || index < 0 || index > size()-1){
			throw new NoSuchElementException();
		}
		int count = 0;
		ListNode<E> now = head;
		while(count < index){
			now = now.getNext();
			count++;
		}
		E val = now.getValue();
		now.setValue(obj);
		return val;
	}
	
	/**	Remove the element at the specified index
	 *	@param index		the index of the element
	 *	@return				the object in the element that was removed
	 *	@throws NoSuchElementException if index does not exist
	 */
	 //Complete
	public E remove(int index) {
		if(isEmpty() || index < 0 || index > size()-1){
			throw new NoSuchElementException();
		}
		if(index == 0){
			E val = head.getValue();
			head = null;
			return val;
		}
		if(index == size() - 1){
			ListNode<E> lastPre = get(index-1);
			E val = tail.getValue();
			lastPre.setNext(null);
			tail = lastPre;
			return val;
		}
		int count = 0;
		ListNode<E> pre = head;
		while(count < index-1){
			pre = pre.getNext();
			count++;
		}
		E val = pre.getNext().getValue();
		ListNode<E> next = pre.getNext().getNext();
		pre.setNext(next);
		return val;
	}
	
	/**	@return	true if list is empty; false otherwise */
	//Complete
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}
	
	/**	Tests whether the list contains the given object
	 *	@param object		the object to test
	 *	@return				true if the object is in the list; false otherwise
	 */
	 //Complete
	public boolean contains(E object) {
		if(isEmpty()){
			return false;
		}
		ListNode next = head.getNext();
		if(head.getValue().equals(object)){
			return true;
		}
		while(next != null){
			if(next.getValue().equals(object)){
				return true;
			}
			next = next.getNext();
		}
		return false;
		
	}
	
	/**	Return the first index matching the element
	 *	@param element		the element to match
	 *	@return				if found, the index of the element; otherwise returns -1
	 */
	 //Complete
	public int indexOf(E element) {
		int count = 0;
		if(isEmpty()){
			return -1;
		}
		ListNode now = head;
		while(now != null){
			if(now.getValue().equals(element)){
				return count;
			}
			count++;
			now = now.getNext();
		}
		return -1;
	}
	
	/**	Prints the list of elements */
	public void printList()
	{
		ListNode<E> ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.getValue() + "; ");
			ptr = ptr.getNext();
		}
	}
	

}
