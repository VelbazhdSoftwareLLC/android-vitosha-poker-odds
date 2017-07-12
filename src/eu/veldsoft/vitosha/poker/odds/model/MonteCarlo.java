/*******************************************************************************
 *                                                                             *
 * VitoshaPokerOdds is Texas hold'em odds calculator written in Bulgaria.      *
 *                                                                             *
 * Copyright (C) 2009-2012 by Todor Balabanov ( tdb@tbsoft.eu )                *
 * Technological School of Electronic Systems                                  *
 * Technical University of Sofia                                               *
 * Sofia, Bulgaria                                                             *
 *                                                                             *
 * This program is free software: you can redistribute it and/or modify        *
 * it under the terms of the GNU General Public License as published by        *
 * the Free Software Foundation, either version 3 of the License, or           *
 * (at your option) any later version.                                         *
 *                                                                             *
 * This program is distributed in the hope that it will be useful,             *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of              *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               *
 * GNU General Public License for more details.                                *
 *                                                                             *
 * You should have received a copy of the GNU General Public License           *
 * along with this program. If not, see <http://www.gnu.org/licenses/>.        *
 *                                                                             *
 ******************************************************************************/

package eu.veldsoft.vitosha.poker.odds.model;

import java.util.Random;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
public class MonteCarlo {

	/**
	 * Number of loops for the simulation.
	 */
	private long numberOfLoops = 0L;

	/**
	 * Current loop for the simulation.
	 */
	private long currentLoop = 0L;

	/**
	 * Known cards from outside.
	 */
	private String knownCards = "";

	/**
	 * Current game simulation.
	 */
	private Game game = new Game();

	/**
	 * Pseudo random number generator.
	 */
	private Random prng = new Random();

	/**
	 * Control running thread.
	 */
	private boolean running = false;

	/**
	 * 
	 * @param numberOfPlayers
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void init(int numberOfPlayers) {
		game.numberOfPlayers = numberOfPlayers;

		for (int i = 0; i < Constants.MAX_NUMBER_OF_PLAYERS; i++) {
			game.players[i].money = Constants.MIN_PLAYER_MONEY
					+ (Math.abs(prng.nextInt())) % (Constants.MAX_PLAYER_MONEY - Constants.MIN_PLAYER_MONEY + 1);
			game.players[i].type = Constants.PLAYER_TYPE_REGULAR;
			game.players[i].winsCounter = 0L;
			game.players[i].tiesCounter = 0L;
		}

		for (int i = 0; i < Constants.NUMBER_OF_CARDS; i++) {
			game.deck.cards[i].known = false;
		}

		game.deck.cards[0].kind = Constants.CARD_KIND_TWO;
		game.deck.cards[0].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[1].kind = Constants.CARD_KIND_THREE;
		game.deck.cards[1].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[2].kind = Constants.CARD_KIND_FOUR;
		game.deck.cards[2].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[3].kind = Constants.CARD_KIND_FIVE;
		game.deck.cards[3].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[4].kind = Constants.CARD_KIND_SIX;
		game.deck.cards[4].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[5].kind = Constants.CARD_KIND_SEVEN;
		game.deck.cards[5].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[6].kind = Constants.CARD_KIND_EIGHT;
		game.deck.cards[6].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[7].kind = Constants.CARD_KIND_NINE;
		game.deck.cards[7].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[8].kind = Constants.CARD_KIND_TEN;
		game.deck.cards[8].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[9].kind = Constants.CARD_KIND_JACK;
		game.deck.cards[9].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[10].kind = Constants.CARD_KIND_QUEEN;
		game.deck.cards[10].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[11].kind = Constants.CARD_KIND_KING;
		game.deck.cards[11].suit = Constants.CARD_SUIT_CLUBS;
		game.deck.cards[12].kind = Constants.CARD_KIND_ACE;
		game.deck.cards[12].suit = Constants.CARD_SUIT_CLUBS;

		game.deck.cards[13].kind = Constants.CARD_KIND_TWO;
		game.deck.cards[13].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[14].kind = Constants.CARD_KIND_THREE;
		game.deck.cards[14].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[15].kind = Constants.CARD_KIND_FOUR;
		game.deck.cards[15].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[16].kind = Constants.CARD_KIND_FIVE;
		game.deck.cards[16].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[17].kind = Constants.CARD_KIND_SIX;
		game.deck.cards[17].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[18].kind = Constants.CARD_KIND_SEVEN;
		game.deck.cards[18].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[19].kind = Constants.CARD_KIND_EIGHT;
		game.deck.cards[19].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[20].kind = Constants.CARD_KIND_NINE;
		game.deck.cards[20].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[21].kind = Constants.CARD_KIND_TEN;
		game.deck.cards[21].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[22].kind = Constants.CARD_KIND_JACK;
		game.deck.cards[22].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[23].kind = Constants.CARD_KIND_QUEEN;
		game.deck.cards[23].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[24].kind = Constants.CARD_KIND_KING;
		game.deck.cards[24].suit = Constants.CARD_SUIT_DIAMONDS;
		game.deck.cards[25].kind = Constants.CARD_KIND_ACE;
		game.deck.cards[25].suit = Constants.CARD_SUIT_DIAMONDS;

		game.deck.cards[26].kind = Constants.CARD_KIND_TWO;
		game.deck.cards[26].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[27].kind = Constants.CARD_KIND_THREE;
		game.deck.cards[27].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[28].kind = Constants.CARD_KIND_FOUR;
		game.deck.cards[28].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[29].kind = Constants.CARD_KIND_FIVE;
		game.deck.cards[29].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[30].kind = Constants.CARD_KIND_SIX;
		game.deck.cards[30].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[31].kind = Constants.CARD_KIND_SEVEN;
		game.deck.cards[31].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[32].kind = Constants.CARD_KIND_EIGHT;
		game.deck.cards[32].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[33].kind = Constants.CARD_KIND_NINE;
		game.deck.cards[33].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[34].kind = Constants.CARD_KIND_TEN;
		game.deck.cards[34].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[35].kind = Constants.CARD_KIND_JACK;
		game.deck.cards[35].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[36].kind = Constants.CARD_KIND_QUEEN;
		game.deck.cards[36].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[37].kind = Constants.CARD_KIND_KING;
		game.deck.cards[37].suit = Constants.CARD_SUIT_HEARTS;
		game.deck.cards[38].kind = Constants.CARD_KIND_ACE;
		game.deck.cards[38].suit = Constants.CARD_SUIT_HEARTS;

		game.deck.cards[39].kind = Constants.CARD_KIND_TWO;
		game.deck.cards[39].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[40].kind = Constants.CARD_KIND_THREE;
		game.deck.cards[40].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[41].kind = Constants.CARD_KIND_FOUR;
		game.deck.cards[41].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[42].kind = Constants.CARD_KIND_FIVE;
		game.deck.cards[42].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[43].kind = Constants.CARD_KIND_SIX;
		game.deck.cards[43].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[44].kind = Constants.CARD_KIND_SEVEN;
		game.deck.cards[44].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[45].kind = Constants.CARD_KIND_EIGHT;
		game.deck.cards[45].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[46].kind = Constants.CARD_KIND_NINE;
		game.deck.cards[46].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[47].kind = Constants.CARD_KIND_TEN;
		game.deck.cards[47].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[48].kind = Constants.CARD_KIND_JACK;
		game.deck.cards[48].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[49].kind = Constants.CARD_KIND_QUEEN;
		game.deck.cards[49].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[50].kind = Constants.CARD_KIND_KING;
		game.deck.cards[50].suit = Constants.CARD_SUIT_SPADES;
		game.deck.cards[51].kind = Constants.CARD_KIND_ACE;
		game.deck.cards[51].suit = Constants.CARD_SUIT_SPADES;

		game.pot.numberOfSplits = 1;
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void shuffle() {
		for (int i = 0; i < Constants.NUMBER_OF_CARDS; i++) {
			Card swap = game.deck.cards[i];

			int r = prng.nextInt(Constants.NUMBER_OF_CARDS);

			game.deck.cards[i] = game.deck.cards[r];
			game.deck.cards[r] = swap;
		}
	}

	/**
	 * 
	 */
	private void fillKnownCards() {
		int playerCardsDeckIndex = 2 * Constants.HUMAN_PLAYER_INDEX;
		int tableCardsDeckIndex = 2 * game.numberOfPlayers;

		for (int i = 0; i < knownCards.length(); i += 2) {
			Card card = new Card();
			card.known = true;

			switch (knownCards.charAt(i)) {
			case '2':
				card.kind = Constants.CARD_KIND_TWO;
				break;
			case '3':
				card.kind = Constants.CARD_KIND_THREE;
				break;
			case '4':
				card.kind = Constants.CARD_KIND_FOUR;
				break;
			case '5':
				card.kind = Constants.CARD_KIND_FIVE;
				break;
			case '6':
				card.kind = Constants.CARD_KIND_SIX;
				break;
			case '7':
				card.kind = Constants.CARD_KIND_SEVEN;
				break;
			case '8':
				card.kind = Constants.CARD_KIND_EIGHT;
				break;
			case '9':
				card.kind = Constants.CARD_KIND_NINE;
				break;
			case 'T':
				card.kind = Constants.CARD_KIND_TEN;
				break;
			case 'J':
				card.kind = Constants.CARD_KIND_JACK;
				break;
			case 'Q':
				card.kind = Constants.CARD_KIND_QUEEN;
				break;
			case 'K':
				card.kind = Constants.CARD_KIND_KING;
				break;
			case 'A':
				card.kind = Constants.CARD_KIND_ACE;
				break;
			}

			switch (knownCards.charAt(i + 1)) {
			case 'C':
				card.suit = Constants.CARD_SUIT_CLUBS;
				break;
			case 'D':
				card.suit = Constants.CARD_SUIT_DIAMONDS;
				break;
			case 'H':
				card.suit = Constants.CARD_SUIT_HEARTS;
				break;
			case 'S':
				card.suit = Constants.CARD_SUIT_SPADES;
				break;
			}

			int j;
			for (j = 0; j < Constants.NUMBER_OF_CARDS; j++) {
				if (game.deck.cards[j].suit == card.suit && game.deck.cards[j].kind == card.kind) {
					break;
				}
			}

			/*
			 * Put known cards on their places.
			 */
			if (i == 0) {
				game.deck.cards[j] = game.deck.cards[playerCardsDeckIndex + 0];
				game.deck.cards[playerCardsDeckIndex + 0] = card;
			} else if (i == 2) {
				game.deck.cards[j] = game.deck.cards[playerCardsDeckIndex + 1];
				game.deck.cards[playerCardsDeckIndex + 1] = card;
			} else if (i == 4) {
				game.deck.cards[j] = game.deck.cards[tableCardsDeckIndex + 0];
				game.deck.cards[tableCardsDeckIndex + 0] = card;
			} else if (i == 6) {
				game.deck.cards[j] = game.deck.cards[tableCardsDeckIndex + 1];
				game.deck.cards[tableCardsDeckIndex + 1] = card;
			} else if (i == 8) {
				game.deck.cards[j] = game.deck.cards[tableCardsDeckIndex + 2];
				game.deck.cards[tableCardsDeckIndex + 2] = card;
			} else if (i == 10) {
				game.deck.cards[j] = game.deck.cards[tableCardsDeckIndex + 3];
				game.deck.cards[tableCardsDeckIndex + 3] = card;
			} else if (i == 12) {
				game.deck.cards[j] = game.deck.cards[tableCardsDeckIndex + 4];
				game.deck.cards[tableCardsDeckIndex + 4] = card;
			}
		}
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void deal() {
		game.pot.numberOfSplits = 1;

		int j = 0;
		for (int i = 0; i < game.numberOfPlayers; i++) {
			game.players[i].hand[0] = game.deck.cards[j];
			j++;
			game.players[i].hand[1] = game.deck.cards[j];
			j++;
		}

		game.board.flop[0] = game.deck.cards[j];
		j++;
		game.board.flop[1] = game.deck.cards[j];
		j++;
		game.board.flop[2] = game.deck.cards[j];
		j++;
		game.board.turn = game.deck.cards[j];
		j++;
		game.board.river = game.deck.cards[j];
		j++;
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void allPlayersRegular() {
		for (int i = 0; i < game.numberOfPlayers; i++) {
			game.players[i].type = Constants.PLAYER_TYPE_REGULAR;
		}
	}

	/**
	 * 
	 * @param dealerIndex
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void definePlayers(int dealerIndex) {
		if (dealerIndex < 0) {
			dealerIndex = 0;
		}
		if (dealerIndex >= game.numberOfPlayers) {
			dealerIndex = game.numberOfPlayers - 1;
		}

		game.players[dealerIndex].type = Constants.PLAYER_TYPE_DEALER;
		game.players[(dealerIndex + 1) % game.numberOfPlayers].type = Constants.PLAYER_TYPE_SMALL_BLIND;
		game.players[(dealerIndex + 2) % game.numberOfPlayers].type = Constants.PLAYER_TYPE_BIG_BLIND;
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateOnePair(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		if (hand[0].kind == hand[1].kind && hand[0].kind != hand[2].kind && hand[0].kind != hand[3].kind
				&& hand[0].kind != hand[4].kind) {
			result.onePair = hand[0].kind;
			result.firstKicker = hand[2].kind;
			result.secondKicker = hand[3].kind;
			result.thirdKicker = hand[4].kind;
		}

		if (hand[1].kind == hand[2].kind && hand[1].kind != hand[0].kind && hand[1].kind != hand[3].kind
				&& hand[1].kind != hand[4].kind) {
			result.onePair = hand[1].kind;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[3].kind;
			result.thirdKicker = hand[4].kind;
		}

		if (hand[2].kind == hand[3].kind && hand[2].kind != hand[0].kind && hand[2].kind != hand[1].kind
				&& hand[2].kind != hand[4].kind) {
			result.onePair = hand[2].kind;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[1].kind;
			result.thirdKicker = hand[4].kind;
		}

		if (hand[3].kind == hand[4].kind && hand[3].kind != hand[0].kind && hand[3].kind != hand[1].kind
				&& hand[3].kind != hand[2].kind) {
			result.onePair = hand[3].kind;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[1].kind;
			result.thirdKicker = hand[2].kind;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateTwoPair(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		if (hand[0].kind == hand[1].kind && hand[2].kind == hand[3].kind && hand[0].kind != hand[2].kind
				&& hand[0].kind != hand[4].kind && hand[2].kind != hand[4].kind) {
			result.twoPair = hand[0].kind;
			result.onePair = hand[2].kind;
			result.firstKicker = hand[4].kind;
		}

		if (hand[0].kind == hand[1].kind && hand[3].kind == hand[4].kind && hand[0].kind != hand[3].kind
				&& hand[0].kind != hand[2].kind && hand[3].kind != hand[2].kind) {
			result.twoPair = hand[0].kind;
			result.onePair = hand[3].kind;
			result.firstKicker = hand[2].kind;
		}

		if (hand[1].kind == hand[2].kind && hand[3].kind == hand[4].kind && hand[1].kind != hand[3].kind
				&& hand[1].kind != hand[0].kind && hand[3].kind != hand[0].kind) {
			result.twoPair = hand[1].kind;
			result.onePair = hand[3].kind;
			result.firstKicker = hand[0].kind;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateThreeOfKind(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		if (hand[0].kind == hand[1].kind && hand[0].kind == hand[2].kind && hand[0].kind != hand[3].kind
				&& hand[0].kind != hand[4].kind && hand[3].kind != hand[4].kind) {
			result.threeOfKind = hand[0].kind;
			result.firstKicker = hand[3].kind;
			result.secondKicker = hand[4].kind;
		}

		if (hand[1].kind == hand[2].kind && hand[1].kind == hand[3].kind && hand[1].kind != hand[0].kind
				&& hand[1].kind != hand[4].kind && hand[0].kind != hand[4].kind) {
			result.threeOfKind = hand[1].kind;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[4].kind;
		}

		if (hand[2].kind == hand[3].kind && hand[2].kind == hand[4].kind && hand[2].kind != hand[0].kind
				&& hand[2].kind != hand[1].kind && hand[0].kind != hand[1].kind) {
			result.threeOfKind = hand[2].kind;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[1].kind;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateStraight(Card[] hand) {
		HandStrength result = new HandStrength();
		int i;
		int found = 0;

		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		found = 1;
		for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
			if (hand[i].kind - hand[i + 1].kind != 1) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.straight = hand[0].kind;
		}

		found = 1;
		if (hand[0].kind != Constants.CARD_KIND_ACE || hand[1].kind != Constants.CARD_KIND_FIVE) {
			found = 0;
		}
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
			if (hand[i].kind - hand[i + 1].kind != 1) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.straight = hand[1].kind;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateFlush(Card[] hand) {
		HandStrength result = new HandStrength();
		int i;
		int found = 0;

		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		found = 1;
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS; i++) {
			if (hand[0].suit != hand[i].suit) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.flush = 1;
			result.firstKicker = hand[0].kind;
			result.secondKicker = hand[1].kind;
			result.thirdKicker = hand[2].kind;
			result.fourthKicker = hand[3].kind;
			result.fifthKicker = hand[4].kind;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateFullHouse(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		if (hand[0].kind == hand[1].kind && hand[0].kind == hand[2].kind && hand[3].kind == hand[4].kind
				&& hand[0].kind != hand[3].kind) {
			result.threeOfKind = hand[0].kind;
			result.twoPair = hand[3].kind;
			result.fullHouse = 1;
		}

		if (hand[2].kind == hand[3].kind && hand[2].kind == hand[4].kind && hand[0].kind == hand[1].kind
				&& hand[0].kind != hand[2].kind) {
			result.threeOfKind = hand[2].kind;
			result.twoPair = hand[0].kind;
			result.fullHouse = 1;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateFourOfKind(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		if (hand[0].kind == hand[1].kind && hand[0].kind == hand[2].kind && hand[0].kind == hand[3].kind
				&& hand[0].kind != hand[4].kind) {
			result.onePair = hand[0].kind;
			result.twoPair = hand[0].kind;
			result.firstKicker = hand[4].kind;
			result.fourOfKind = 1;
		}

		if (hand[1].kind == hand[2].kind && hand[1].kind == hand[3].kind && hand[1].kind == hand[4].kind
				&& hand[1].kind != hand[0].kind) {
			result.onePair = hand[1].kind;
			result.twoPair = hand[1].kind;
			result.firstKicker = hand[0].kind;
			result.fourOfKind = 1;
		}

		return (result);

	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateStraightFlush(Card[] hand) {
		HandStrength result = new HandStrength();
		HandStrength straight;
		HandStrength flush;

		straight = evaluateStraight(hand);
		flush = evaluateFlush(hand);
		if (straight.straight == 1 && flush.flush == 1) {
			result.flush = flush.flush;
			result.straight = straight.straight;
			result.straightFlush = 1;
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateKickers(Card[] hand) {
		HandStrength result = new HandStrength();
		result.fifthKicker = 0;
		result.fourthKicker = 0;
		result.thirdKicker = 0;
		result.secondKicker = 0;
		result.firstKicker = 0;
		result.onePair = 0;
		result.twoPair = 0;
		result.threeOfKind = 0;
		result.straight = 0;
		result.flush = 0;
		result.fullHouse = 0;
		result.fourOfKind = 0;
		result.straightFlush = 0;

		/*
		 * Check for hand without combination.
		 */
		result.firstKicker = hand[0].kind;
		result.secondKicker = hand[1].kind;
		result.thirdKicker = hand[2].kind;
		result.fourthKicker = hand[3].kind;
		result.fifthKicker = hand[4].kind;

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private long evaluateHand(Card[] hand) {
		long result = 0L;
		HandStrength strength;

		strength = evaluateOnePair(hand);
		result |= strength.getValue();

		strength = evaluateTwoPair(hand);
		result |= strength.getValue();

		strength = evaluateThreeOfKind(hand);
		result |= strength.getValue();

		strength = evaluateStraight(hand);
		result |= strength.getValue();

		strength = evaluateFlush(hand);
		result |= strength.getValue();

		strength = evaluateFullHouse(hand);
		result |= strength.getValue();

		strength = evaluateFourOfKind(hand);
		result |= strength.getValue();

		strength = evaluateStraightFlush(hand);
		result |= strength.getValue();

		if (result == 0L) {
			strength = evaluateKickers(hand);
			result |= strength.getValue();
		}

		return (result);
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @param index
	 * 
	 * @param player
	 * 
	 * @param board
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void formFiveCardsHand(Card[] hand, int index, Player player, Board board) {

		final int[][] combinations = { { 0, 0, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 1, 1 }, { 0, 1, 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0 },
				{ 1, 1, 0, 0, 1, 1, 1 }, { 1, 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0 }, { 1, 1, 1, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 0, 0 } };

		Card[] allCards = new Card[Constants.NUMBER_OF_KNOWN_CARDS];

		allCards[0] = player.hand[0];
		allCards[1] = player.hand[1];
		allCards[2] = board.flop[0];
		allCards[3] = board.flop[1];
		allCards[4] = board.flop[2];
		allCards[5] = board.turn;
		allCards[6] = board.river;

		if (index < 0 || index >= Constants.NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION) {
			// TODO Exception handling!
			return;
		}

		for (int i = 0, j = 0; i < Constants.NUMBER_OF_KNOWN_CARDS; i++) {
			if (combinations[index][i] == 1) {
				hand[j] = allCards[i];
				j++;
			}
		}

	}

	/**
	 * 
	 * @param hand
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void sortWithLeadingAce(Card[] hand) {
		int i;
		int done = 0;
		Card swap;

		while (done == 0) {
			done = 1;
			for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
				if (hand[i].kind < hand[i + 1].kind) {
					swap = hand[i];
					hand[i] = hand[i + 1];
					hand[i + 1] = swap;
					done = 0;
				}
			}
		}
	}

	/**
	 * 
	 * @param hand
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void sortWithoutLeadingAce(Card[] hand) {
		int i;
		int done = 0;
		Card swap;

		while (done == 0) {
			done = 1;
			for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
				if (((hand[i].kind == Constants.CARD_KIND_ACE) ? Constants.CARD_KIND_WEAK_ACE
						: hand[i].kind) < ((hand[i + 1].kind == Constants.CARD_KIND_ACE) ? Constants.CARD_KIND_WEAK_ACE
								: hand[i + 1].kind)) {
					swap = hand[i];
					hand[i] = hand[i + 1];
					hand[i + 1] = swap;
					done = 0;
				}
			}
		}
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void calculatePlayersHandScore() {
		/*
		 * Calculate hand score.
		 */
		for (int i = 0; i < game.numberOfPlayers; i++) {
			Card[] hand = new Card[Constants.NUMBER_OF_EVALUATION_HAND_CARDS];

			game.players[i].handScore = 0L;

			for (int j = 0; j < Constants.NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION; j++) {
				long score = 0L;

				formFiveCardsHand(hand, j, game.players[i], game.board);

				sortWithoutLeadingAce(hand);
				score = evaluateHand(hand);
				if (score > game.players[i].handScore) {
					game.players[i].handScore = score;
				}

				sortWithLeadingAce(hand);
				score = evaluateHand(hand);
				if (score > game.players[i].handScore) {
					game.players[i].handScore = score;
				}

			}
		}
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void updateWinsCounter() {
		int howManyBest = 0;
		int bestScoreIndex = 0;

		/*
		 * Find index of the player with the best score.
		 */
		for (int i = 0; i < game.numberOfPlayers; i++) {
			if (game.players[i].handScore > game.players[bestScoreIndex].handScore) {
				bestScoreIndex = i;
			}
		}

		/*
		 * Find how many players have the best score.
		 */
		for (int i = 0; i < game.numberOfPlayers; i++) {
			if (game.players[i].handScore == game.players[bestScoreIndex].handScore) {
				howManyBest++;
			}
		}

		/*
		 * Update wins or ties counters.
		 */
		if (howManyBest == 1) {
			game.players[bestScoreIndex].winsCounter++;
		} else if (howManyBest > 1) {
			for (int i = 0; i < game.numberOfPlayers; i++) {
				if (game.players[i].handScore == game.players[bestScoreIndex].handScore) {
					game.players[i].tiesCounter++;
				}
			}
		}
	}

	/**
	 * 
	 * @param numberOfLoops
	 * 
	 * @param numberOfPlayers
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public MonteCarlo(String knownCards, long numberOfLoops, int numberOfPlayers) {
		/*
		 * Parse initial game options from command line.
		 */
		if (numberOfPlayers < Constants.MIN_NUMBER_OF_PLAYERS) {
			numberOfPlayers = Constants.MIN_NUMBER_OF_PLAYERS;
		}
		if (numberOfPlayers > Constants.MAX_NUMBER_OF_PLAYERS) {
			numberOfPlayers = Constants.MAX_NUMBER_OF_PLAYERS;
		}

		if (numberOfLoops < Constants.MIN_NUMBER_OF_LOOPS) {
			numberOfLoops = Constants.MIN_NUMBER_OF_LOOPS;
		}
		if (numberOfLoops > Constants.MAX_NUMBER_OF_LOOPS) {
			numberOfLoops = Constants.MAX_NUMBER_OF_LOOPS;
		}

		/*
		 * Initialize the table with players and cards.
		 */
		init(numberOfPlayers);

		this.knownCards = knownCards;
		this.numberOfLoops = numberOfLoops;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	synchronized public double willWinIn() {
		return ((double) 100.0 * game.players[Constants.HUMAN_PLAYER_INDEX].winsCounter / (double) currentLoop);
	}

	/**
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	synchronized public double willNotLooseIn() {
		return ((double) 100.0 * (game.players[Constants.HUMAN_PLAYER_INDEX].winsCounter
				+ game.players[Constants.HUMAN_PLAYER_INDEX].tiesCounter) / (double) currentLoop);
	}

	/**
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 13 Aug 2012
	 */
	public synchronized void stop() {
		running = false;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	public double start() {
		final int SLEEP_FOR_MS = 10;

		double result = 0.0;

		running = true;

		for (currentLoop = 1L; currentLoop <= numberOfLoops; currentLoop++) {

			allPlayersRegular();

			// TODO Player type is not used yet.
			// definePlayers(l % game.numberOfPlayers);

			shuffle();
			fillKnownCards();
			deal();

			calculatePlayersHandScore();

			// TODO Handle winner win.

			updateWinsCounter();

			try {
				Thread.sleep(SLEEP_FOR_MS);
			} catch (InterruptedException exception) {
			}

			if (running == false) {
				result = (double) 100.0 * (game.players[Constants.HUMAN_PLAYER_INDEX].winsCounter
						+ game.players[Constants.HUMAN_PLAYER_INDEX].tiesCounter) / (double) currentLoop;

				return (result);
			}
		}

		result = (double) 100.0 * (game.players[Constants.HUMAN_PLAYER_INDEX].winsCounter
				+ game.players[Constants.HUMAN_PLAYER_INDEX].tiesCounter) / (double) numberOfLoops;

		return (result);
	}
}
