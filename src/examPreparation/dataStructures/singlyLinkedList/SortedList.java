package examPreparation.dataStructures.singlyLinkedList;

public class SortedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

	public void add(T data) {
		try {
			// Find correct position, then use superclass method
			super.add(getSortPosition(data), data);
		} catch (ListException e) {
			// There's always a valid position, ListException cannot occur
		}
	}

	// The superclass method must be disabled, because we cannot trust the user
	// to add elements in the correct position. This is a sign that the class
	// hierarchy is not optimal - all inherited methods should apply.
	//
	// How could you define a better class hierarchy?

	@Override
	public void add(int pos, T data) throws ListException {
		throw new UnsupportedOperationException("can't add at a specific position in a sorted list");
	}

	private int getSortPosition(T data) {
		int position = 0;
		try {
			for (int i = 0; i < size(); i++) {
				if (get(i).compareTo(data) < 0) { // T implements Comparable<T>
					position++;
				}
			}
		} catch (ListException e) {
			// i is always between 0 and size(); no ListException can be thrown
		}
		return position;
	}
}
