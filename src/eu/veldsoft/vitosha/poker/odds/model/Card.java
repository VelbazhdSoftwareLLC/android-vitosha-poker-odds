package eu.veldsoft.vitosha.poker.odds.model;

/**
 * Card class.
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Card {
	/**
	 * Suit of the card.
	 */
	private int suit;

	/**
	 * Kind of the card.
	 */
	private int kind;

	/**
	 * Is the card revealed flag.
	 */
	private boolean known;

	/**
	 * Constructor without parameters.
	 */
	public Card() {
	}

	/**
	 * Constructor with all parameters.
	 * 
	 * @param suit
	 *            Card suit.
	 * @param kind
	 *            Card kind.
	 * @param known
	 *            Is the card known flag.
	 */
	public Card(int suit, int kind, boolean known) {
		this.suit = suit;
		this.kind = kind;
		this.known = known;
	}

	/**
	 * Get the card suit.
	 * 
	 * @return Card suit.
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Set the suit of the current card.
	 * 
	 * @param suit
	 *            Card suit.
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}

	/**
	 * Get the card kind.
	 * 
	 * @return Card kind.
	 */
	public int getKind() {
		return kind;
	}

	/**
	 * Set the kind of the current card.
	 * 
	 * @param kind
	 *            Card kind.
	 */
	public void setKind(int kind) {
		this.kind = kind;
	}

	/**
	 * Get the known state of the card.
	 * 
	 * @return Is the card known.
	 */
	public boolean isKnown() {
		return known;
	}

	/**
	 * Set the known state of the current card.
	 * 
	 * @param known
	 *            Is the card known flag.
	 */
	public void setKnown(boolean known) {
		this.known = known;
	}
}
