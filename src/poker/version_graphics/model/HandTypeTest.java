package poker.version_graphics.model;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HandTypeTest {
	// We define the hands using abbreviations. The code at the bottom
	// of this class can translate one of these strings into a card.
	//
	// Another method takes a set of five cards, and translates the whole hand
	//
	// Yet another method does this for a whole set of hands
	private static String[][] highCards = {
			{ "2S", "9C", "3H", "5D", "7H" },
			{ "7S", "5C", "AH", "JD", "6H" },
			{ "2S", "3S", "4S", "5S", "7H" },
			{ "AS", "KC", "QH", "JD", "9H" }
			};
	
	private static String[][] pairs = {
			{ "2S", "2C", "3H", "5D", "7H" },
			{ "2S", "AC", "3H", "5D", "AH" },
			{ "3S", "2C", "3H", "KD", "QH" },
			{ "9S", "2C", "2H", "5D", "7H" }
			};

	private static String[][] twoPairs = {
			{ "2S", "2C", "7H", "5D", "7H" },
			{ "2S", "AC", "5H", "5D", "AH" },
			{ "3S", "2C", "3H", "2D", "QH" },
			{ "9S", "2C", "2H", "5D", "5H" }
			};
	
	private static String[][] threeOfAKinds = {
			{ "2S", "2C", "8H", "2D", "7H" },
			{ "2S", "AC", "AH", "5D", "AS" },
			{ "3S", "2C", "3H", "3D", "QH" },
			{ "5S", "2C", "3H", "5D", "5H" }
			};
	//be aware of an ace as the lowest card should be possible
	private static String[][] straights = {
			{ "2S", "3C", "4H", "5D", "6H" },
			{ "TS", "AC", "QH", "JD", "KH" },
			{ "AS", "2C", "3H", "4D", "5H" },
			{ "8S", "9C", "7H", "5D", "6H" }
			};
	
	private static String[][] flushs = {
			{ "2S", "3S", "7S", "5S", "KS" },
			{ "2H", "AH", "5H", "KH", "QH" },
			{ "5D", "2D", "3D", "JD", "QD" },
			{ "9C", "3C", "2C", "5C", "6C" }
			};
	
	private static String[][] fullHouses = {
			{ "2S", "2C", "7S", "7D", "7H" },
			{ "AS", "AC", "5H", "5D", "AH" },
			{ "3S", "3C", "3H", "2D", "2H" },
			{ "QS", "QC", "QH", "5D", "5H" }
			};
	
	private static String[][] fourOfAKinds = {
			{ "2S", "2C", "2H", "2D", "7H" },
			{ "2S", "5C", "5H", "5D", "5S" },
			{ "AS", "AC", "AH", "2D", "AD" },
			{ "9S", "9C", "2H", "9D", "9H" }
			};
	
	private static String[][] straightFlushs = {
			{ "2S", "3S", "4S", "5S", "6S" },
			{ "TH", "AH", "QH", "JH", "KH" },
			{ "AC", "2C", "3C", "4C", "5C" },
			{ "8D", "9D", "7D", "5D", "6D" }
			};
	
	// This is where we store the translated hands
	ArrayList<ArrayList<Card>> highCardHands;
	ArrayList<ArrayList<Card>> pairHands;
	ArrayList<ArrayList<Card>> twoPairHands;
	ArrayList<ArrayList<Card>> threeHands;
	ArrayList<ArrayList<Card>> straightHands;
	ArrayList<ArrayList<Card>> flushHands;
	ArrayList<ArrayList<Card>> fullHouseHands;
	ArrayList<ArrayList<Card>> fourHands;
	ArrayList<ArrayList<Card>> straightFlushHands;
	
	/**
	 * The makeHands method is called before each test method,
	 * and prepares the translated hands. We recreate these for
	 * each test method, in case the test method damages the data.
	 */
	@Before
	public void makeHands() {
		highCardHands = makeHands(highCards);
		pairHands = makeHands(pairs);
		twoPairHands = makeHands(twoPairs);
		threeHands =  makeHands(threeOfAKinds);
		straightHands =  makeHands(straights);
		flushHands =  makeHands(flushs);
		fullHouseHands =  makeHands(fullHouses);
		fourHands =  makeHands(fourOfAKinds);
		straightFlushHands =  makeHands(straightFlushs);
	}

	/**
	 * This is a test method for the isOnePair method in HandType.
	 * We expect all HighCard hands to be false, all OnePair hands to
	 * be true, all TwoPair hands to be true, etc.
	 */
	@Test
	public void testIsOnePair() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertTrue(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertTrue(HandType.isOnePair(hand)); // Two-pair contains a pair
		}// check asserts from here!
		for (ArrayList<Card> hand : threeHands) {
			assertTrue(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertTrue(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertTrue(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertFalse(HandType.isOnePair(hand));
		}
	}

	/**
	 * This is the test method for the isTwoPair in HandType.
	 */
	@Test
	public void testIsTwoPair() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertTrue(HandType.isTwoPair(hand));
		}//check asserts from here!
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertTrue(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertTrue(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		
	}
	// rework!
	@Test
	public void testIsThreeOfAKind() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : threeHands) {
			assertTrue(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertTrue(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertTrue(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
	}
	// rework!
	@Test
	public void testIsStraight() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertTrue(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertTrue(HandType.isStraight(hand));
		}
	}
	// rework!
	@Test
	public void testIsFlush() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertTrue(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertTrue(HandType.isFlush(hand));
		}
	}
	// rework!
	@Test
	public void testIsFullHouse() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isFullHouse(hand));
		}//check asserts from here!
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertTrue(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
	}
	
	@Test
	public void testIsFourOfAKind() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertTrue(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
	}
	// rework!
	@Test
	public void testIsStraightFlush() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : threeHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : fullHouseHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : fourHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : straightFlushHands) {
			assertTrue(HandType.isStraightFlush(hand));
		}
	}
	
	/**
	 * Make an ArrayList of hands from an array of string-arrays
	 */
	private ArrayList<ArrayList<Card>> makeHands(String[][] handsIn) {
		ArrayList<ArrayList<Card>> handsOut = new ArrayList<>();
		for (String[] hand : handsIn) {
			handsOut.add(makeHand(hand));
		}
		return handsOut;
	}
	
	/**
	 * Make a hand (ArrayList<Card>) from an array of 5 strings
	 */
	private ArrayList<Card> makeHand(String[] inStrings) {
		ArrayList<Card> hand = new ArrayList<>();
		for (String in : inStrings) {
			hand.add(makeCard(in));
		}
		return hand;
	}
	
	/**
	 * Create a card from a 2-character String.
	 * First character is the rank (2-9, T, J, Q, K, A) 
	 * Second character is the suit (C, D, H, S)
	 * 
	 * No validation or error handling!
	 */
	private Card makeCard(String in) {
		char r = in.charAt(0);
		Card.Rank rank = null;
		if (r <= '9') rank = Card.Rank.values()[r-'0' - 2];
		else if (r == 'T') rank = Card.Rank.Ten;
		else if (r == 'J') rank = Card.Rank.Jack;
		else if (r == 'Q') rank = Card.Rank.Queen;
		else if (r == 'K') rank = Card.Rank.King;
		else if (r == 'A') rank = Card.Rank.Ace;
		
		char s = in.charAt(1);
		Card.Suit suit = null;
		if (s == 'C') suit = Card.Suit.Clubs;
		if (s == 'D') suit = Card.Suit.Diamonds;
		if (s == 'H') suit = Card.Suit.Hearts;
		if (s == 'S') suit = Card.Suit.Spades;

		return new Card(suit, rank);
	}
}
