package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Player {

	/**
	 * Array of cards in player's hand.
	 */
	private Card[] hand = new Card[Constants.NUMBER_OF_HAND_CARDS];

	/**
	 * Amount of money the player has.
	 */
	private long money;

	/**
	 * TODO
	 */
	private int type;

	/**
	 * Player's hand score.
	 */
	private long handScore;

	/**
	 * Player's win counter.
	 */
	private long winsCounter;

	/**
	 * Player's tie counter.
	 */
	private long tiesCounter;

	/**
	 * Get player's cards in hand.
	 * 
	 * @return hand
	 */
	public Card[] getHand() {
		return hand;
	}

	/**
	 * Set player's cards in hand.
	 * 
	 * @param hand
	 */
	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	/**
	 * Get player's money.
	 * 
	 * @return money
	 */
	public long getMoney() {
		return money;
	}

	/**
	 * Set player's money.
	 * 
	 * @param money
	 */
	public void setMoney(long money) {
		this.money = money;
	}

	/**
	 * Get player's type.
	 * 
	 * @return type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Set player's type.
	 * 
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Get player's hand score.
	 * 
	 * @return handScore
	 */
	public long getHandScore() {
		return handScore;
	}

	/**
	 * Set player's handScore.
	 * 
	 * @param handScore
	 */
	public void setHandScore(long handScore) {
		this.handScore = handScore;
	}

	/**
	 * Get player's wins counter.
	 * 
	 * @return winsCounter
	 */
	public long getWinsCounter() {
		return winsCounter;
	}

	/**
	 * Increments the win counter.
	 */
	public void incrementWinsCounter() {
		this.winsCounter++;
	}

	/**
	 * Set player's win counter.
	 * 
	 * @param winsCounter
	 */
	public void setWinsCounter(long winsCounter) {
		this.winsCounter = winsCounter;
	}

	/**
	 * Get player's tie counter.
	 * 
	 * @return tiesCounter
	 */
	public long getTiesCounter() {
		return tiesCounter;
	}

	/**
	 * Increments the tie counter.
	 */
	public void incrementTiesCounter() {
		this.tiesCounter++;
	}

	/**
	 * Set player's tie Counter.
	 * 
	 * @param tiesCounter
	 */
	public void setTiesCounter(long tiesCounter) {
		this.tiesCounter = tiesCounter;
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public Player() {
		for (int i = 0; i < hand.length; i++) {
			hand[i] = new Card();
		}
	}
}