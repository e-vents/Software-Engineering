package examPreparation.dataStructures.singlyLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class SinglyLinkedListTest {
	private SinglyLinkedList<String> myList;

	/**
	 * This method is run before each individual test-method. In this case, we
	 * reset the test-list to a new, empty list each time
	 */
	@Before
	public void setUp() throws Exception {
		myList = new SinglyLinkedList<>();
	}

	@Test(expected = ListException.class)
	public void testIllegalAddUpperBound() throws ListException {
		// when
		myList.add(1, "one");
	}

	@Test(expected = ListException.class)
	public void testIllegalAddLowerBound() throws ListException {
		// when
		myList.add(-1, "one");
	}

	@Test
	public void testAddFirst() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);
		final String second = "second";

		// when
		myList.add(0, second);

		// then
		assertEquals(second, myList.get(0));
		assertEquals(first, myList.get(1));
	}

	@Test
	public void testAddLast() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);

		final String second = "second";

		// when
		myList.add(1, second);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(second, myList.get(1));
	}

	@Test
	public void testAddNull() throws Exception {
		// when
		myList.add(0, null);

		// then
		assertNull(myList.get(0));
		assertEquals(1, myList.size());
	}

	@Test
	public void testAddAtPos() throws Exception {
		// given

		final String first = "first";
		final String second = "second";

		// when
		myList.add(0, first);
		myList.add(1, second);

		final String newSecond = "newSecond";
		myList.add(1, newSecond);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(newSecond, myList.get(1));
		assertEquals(second, myList.get(2));
	}

	@Test(expected = ListException.class)
	public void testIllegalRemoveUpperBound() throws Exception {
		myList.remove(0);
	}

	@Test(expected = ListException.class)
	public void testIllegalRemoveLowerBound() throws Exception {
		myList.remove(-1);
	}

	@Test
	public void testRemove() throws Exception {
		myList.add(0, "one");
		final String two = "two";
		myList.add(1, two);
		myList.remove(0);
		assertEquals(1, myList.size());
		assertSame(two, myList.get(0));
		myList.remove(0);
		assertTrue(myList.isEmpty());
	}

	@Test(expected = ListException.class)
	public void testIllegalGetUpperBound() throws Exception {
		myList.get(0);
	}

	@Test(expected = ListException.class)
	public void testIllegalGetLowerBound() throws Exception {
		myList.get(-1);
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(myList.isEmpty());
		myList.add(0, "value");
		assertFalse(myList.isEmpty());
		myList.remove(0);
		assertTrue(myList.isEmpty());
	}

	@Test
	public void testContains() throws Exception {
		final String value = "value";
		assertFalse(myList.contains(value));
		myList.add(0, "otherValue");
		assertFalse(myList.contains(value));
		myList.add(0, value);
		assertTrue(myList.contains(value));
		assertFalse(myList.contains(null));
		myList.add(0, null);
		assertTrue(myList.contains(null));
	}

	@Test
	public void testSize() throws Exception {
		assertEquals(0, myList.size());
		myList.add(0, "value");
		assertEquals(1, myList.size());
		myList.remove(0);
		assertEquals(0, myList.size());
	}
}
