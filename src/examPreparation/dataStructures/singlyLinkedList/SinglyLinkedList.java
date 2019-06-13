package examPreparation.dataStructures.singlyLinkedList;

import examPreparation.dataStructures.singlyLinkedList.ListException.ListErrorCode;

public class SinglyLinkedList<T> {
	/**
	 * Inner class representing individual elements in the list - no longer public
	 */
	protected class SinglyLinkedElement<T> {
		private final T data; // in our current implementation, this is unchangeable
		private SinglyLinkedElement<T> next = null; // Outer class has access to private attribute
		
		/**
		 * Constructor protected; could be needed by a subclass
		 */
		protected SinglyLinkedElement(T data) {
			this.data = data;
		}
		
		/**
		 * Protected; could be needed by a subclass
		 */
		protected T getData() {
			return data;
		}
	}	

	//--------------------------------------
	
	private SinglyLinkedElement<T> head = null;
	
	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int position, T o) throws ListException {
		if(position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		
	}

	public T get(int position) throws ListException {
		if (position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		SinglyLinkedElement<T> cursor = head;
		for (int pos = 0; pos < position; pos++) {
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			cursor = cursor.next;
		}
		if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
		return cursor.getData();
	}

	public T remove(int position) throws ListException {
		return null;
	}
	
	public int size() {
		int counter = 0;
		SinglyLinkedElement cursor = head;
		
		return counter;
	}
	
	public boolean contains(T elt) {
		return false;
	}	
}
