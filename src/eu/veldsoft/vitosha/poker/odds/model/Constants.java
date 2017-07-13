package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Constants {
	static final int HUMAN_PLAYER_INDEX = 0;

	static final long MIN_NUMBER_OF_LOOPS = 1L;
	static final long MAX_NUMBER_OF_LOOPS = 100000L;

	static final int MIN_NUMBER_OF_PLAYERS = 2;
	static final int MAX_NUMBER_OF_PLAYERS = 10;

	static final int NUMBER_OF_CARDS = 52;
	static final int NUMBER_OF_EVALUATION_HAND_CARDS = 5;
	static final int NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION = 21;
	static final int NUMBER_OF_HAND_CARDS = 2;
	static final int NUMBER_OF_FLOP_CARDS = 3;
	static final int NUMBER_OF_KNOWN_CARDS = 7;

	static final int PLAYER_TYPE_REGULAR = 0x1;
	static final int PLAYER_TYPE_DEALER = 0x2;
	static final int PLAYER_TYPE_SMALL_BLIND = 0x4;
	static final int PLAYER_TYPE_BIG_BLIND = 0x8;

	static final long MIN_PLAYER_MONEY = 100L;
	static final long MAX_PLAYER_MONEY = 100000L;

	static final int CARD_KIND_WEAK_ACE = 0x1;
	static final int CARD_KIND_TWO = 0x2;
	static final int CARD_KIND_THREE = 0x3;
	static final int CARD_KIND_FOUR = 0x4;
	static final int CARD_KIND_FIVE = 0x5;
	static final int CARD_KIND_SIX = 0x6;
	static final int CARD_KIND_SEVEN = 0x7;
	static final int CARD_KIND_EIGHT = 0x8;
	static final int CARD_KIND_NINE = 0x9;
	static final int CARD_KIND_TEN = 0xA;
	static final int CARD_KIND_JACK = 0xB;
	static final int CARD_KIND_QUEEN = 0xC;
	static final int CARD_KIND_KING = 0xD;
	static final int CARD_KIND_ACE = 0xE;

	static final int CARD_SUIT_CLUBS = 0x10;
	static final int CARD_SUIT_DIAMONDS = 0x20;
	static final int CARD_SUIT_HEARTS = 0x30;
	static final int CARD_SUIT_SPADES = 0x40;
}
