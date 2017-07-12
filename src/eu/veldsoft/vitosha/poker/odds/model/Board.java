package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Board {
	Card[] flop = new Card[Constants.NUMBER_OF_FLOP_CARDS];
	Card turn = new Card();
	Card river = new Card();

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public Board() {
		for (int i = 0; i < flop.length; i++) {
			flop[i] = new Card();
		}
	}
}