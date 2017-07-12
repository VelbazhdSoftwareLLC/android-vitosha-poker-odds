package eu.veldsoft.vitosha.poker.odds.model;

/**
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
	 * 
	 */
	private boolean known;

	/**
	 * Get the card suit.
	 * 
	 * @return suit.
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Set the suit of the current card.
	 * 
	 * @param suit
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}

	/**
	 * Get the card kind.
	 * 
	 * @return kind.
	 */
	public int getKind() {
		return kind;
	}

	/**
	 * Set the kind of the current card.
	 * 
	 * @param kind
	 */
	public void setKind(int kind) {
		this.kind = kind;
	}

	/**
	 * Get the known state of the card.
	 * 
	 * @return known.
	 */
	public boolean isKnown() {
		return known;
	}

	/**
	 * Set the known state of the current card.
	 * 
	 * @param known
	 */
	public void setKnown(boolean known) {
		this.known = known;
	}

	/**
	 * Card constructor.
	 * 
	 * @param suit
	 * @param kind
	 * @param known
	 */
	public Card(int suit, int kind, boolean known) {
		this.suit = suit;
		this.kind = kind;
		this.known = known;
	}

	/**
	 * Default card constructor.
	 */
	public Card() {
	}

}