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
	Card[] hand = new Card[Constants.NUMBER_OF_HAND_CARDS];
	long money;
	int type;
	long handScore;
	long winsCounter;
	long tiesCounter;

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