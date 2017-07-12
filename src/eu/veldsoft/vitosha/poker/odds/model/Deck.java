package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Deck {
	Card[] cards = new Card[Constants.NUMBER_OF_CARDS];

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public Deck() {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card();
		}
	}
}