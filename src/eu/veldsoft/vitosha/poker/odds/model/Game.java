package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Game {
	Deck deck = new Deck();
	Board board = new Board();
	Player[] players = new Player[Constants.MAX_NUMBER_OF_PLAYERS];
	int numberOfPlayers;
	Pot pot = new Pot();

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public Game() {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}
	}
}