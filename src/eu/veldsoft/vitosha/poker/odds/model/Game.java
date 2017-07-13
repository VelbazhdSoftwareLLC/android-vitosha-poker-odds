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

	/**
	 * Deck of cards used in game.
	 */
	private Deck deck = new Deck();

	/**
	 * Game board.
	 */
	private Board board = new Board();

	/**
	 * Players in game.
	 */
	private Player[] players = new Player[Constants.MAX_NUMBER_OF_PLAYERS];

	/**
	 * Number of players.
	 */
	private int numberOfPlayers;

	/**
	 * The pot on board.
	 */
	private Pot pot = new Pot();

	/**
	 * Get the deck of cards.
	 * 
	 * @return deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Set the deck of cards.
	 * 
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * Get the board.
	 * 
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the game board.
	 * 
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Get the players playing.
	 * 
	 * @return players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Set the players in game.
	 * 
	 * @param players
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}

	/**
	 * Get the number of players.
	 * 
	 * @return numberOfPlayers
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * Set the number of players in game.
	 * 
	 * @param numberOfPlayers
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	/**
	 * Get the pot on board.
	 * 
	 * @return pot
	 */
	public Pot getPot() {
		return pot;
	}

	/**
	 * Set the pot.
	 * 
	 * @param pot
	 */
	public void setPot(Pot pot) {
		this.pot = pot;
	}

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