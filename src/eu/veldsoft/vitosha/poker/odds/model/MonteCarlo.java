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
		game.setNumberOfPlayers(numberOfPlayers);

		for (int i = 0; i < Constants.MAX_NUMBER_OF_PLAYERS; i++) {
			game.getPlayers()[i].setMoney(Constants.MIN_PLAYER_MONEY
					+ (Math.abs(prng.nextInt())) % (Constants.MAX_PLAYER_MONEY - Constants.MIN_PLAYER_MONEY + 1));
			game.getPlayers()[i].setType(Constants.PLAYER_TYPE_REGULAR);
			game.getPlayers()[i].setWinsCounter(0L);
			game.getPlayers()[i].setTiesCounter(0L);
		}

		for (int i = 0; i < Constants.NUMBER_OF_CARDS; i++) {
			game.getDeck().getCards()[i].setKnown(false);
		}

		game.getDeck().getCards()[0].setKind(Constants.CARD_KIND_TWO);
		game.getDeck().getCards()[0].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[1].setKind(Constants.CARD_KIND_THREE);
		game.getDeck().getCards()[1].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[2].setKind(Constants.CARD_KIND_FOUR);
		game.getDeck().getCards()[2].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[3].setKind(Constants.CARD_KIND_FIVE);
		game.getDeck().getCards()[3].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[4].setKind(Constants.CARD_KIND_SIX);
		game.getDeck().getCards()[4].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[5].setKind(Constants.CARD_KIND_SEVEN);
		game.getDeck().getCards()[5].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[6].setKind(Constants.CARD_KIND_EIGHT);
		game.getDeck().getCards()[6].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[7].setKind(Constants.CARD_KIND_NINE);
		game.getDeck().getCards()[7].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[8].setKind(Constants.CARD_KIND_TEN);
		game.getDeck().getCards()[8].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[9].setKind(Constants.CARD_KIND_JACK);
		game.getDeck().getCards()[9].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[10].setKind(Constants.CARD_KIND_QUEEN);
		game.getDeck().getCards()[10].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[11].setKind(Constants.CARD_KIND_KING);
		game.getDeck().getCards()[11].setSuit(Constants.CARD_SUIT_CLUBS);
		game.getDeck().getCards()[12].setKind(Constants.CARD_KIND_ACE);
		game.getDeck().getCards()[12].setSuit(Constants.CARD_SUIT_CLUBS);

		game.getDeck().getCards()[13].setKind(Constants.CARD_KIND_TWO);
		game.getDeck().getCards()[13].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[14].setKind(Constants.CARD_KIND_THREE);
		game.getDeck().getCards()[14].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[15].setKind(Constants.CARD_KIND_FOUR);
		game.getDeck().getCards()[15].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[16].setKind(Constants.CARD_KIND_FIVE);
		game.getDeck().getCards()[16].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[17].setKind(Constants.CARD_KIND_SIX);
		game.getDeck().getCards()[17].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[18].setKind(Constants.CARD_KIND_SEVEN);
		game.getDeck().getCards()[18].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[19].setKind(Constants.CARD_KIND_EIGHT);
		game.getDeck().getCards()[19].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[20].setKind(Constants.CARD_KIND_NINE);
		game.getDeck().getCards()[20].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[21].setKind(Constants.CARD_KIND_TEN);
		game.getDeck().getCards()[21].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[22].setKind(Constants.CARD_KIND_JACK);
		game.getDeck().getCards()[22].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[23].setKind(Constants.CARD_KIND_QUEEN);
		game.getDeck().getCards()[23].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[24].setKind(Constants.CARD_KIND_KING);
		game.getDeck().getCards()[24].setKind(Constants.CARD_SUIT_DIAMONDS);
		game.getDeck().getCards()[25].setKind(Constants.CARD_KIND_ACE);
		game.getDeck().getCards()[25].setKind(Constants.CARD_SUIT_DIAMONDS);

		game.getDeck().getCards()[26].setKind(Constants.CARD_KIND_TWO);
		game.getDeck().getCards()[26].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[27].setKind(Constants.CARD_KIND_THREE);
		game.getDeck().getCards()[27].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[28].setKind(Constants.CARD_KIND_FOUR);
		game.getDeck().getCards()[28].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[29].setKind(Constants.CARD_KIND_FIVE);
		game.getDeck().getCards()[29].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[30].setKind(Constants.CARD_KIND_SIX);
		game.getDeck().getCards()[30].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[31].setKind(Constants.CARD_KIND_SEVEN);
		game.getDeck().getCards()[31].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[32].setKind(Constants.CARD_KIND_EIGHT);
		game.getDeck().getCards()[32].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[33].setKind(Constants.CARD_KIND_NINE);
		game.getDeck().getCards()[33].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[34].setKind(Constants.CARD_KIND_TEN);
		game.getDeck().getCards()[34].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[35].setKind(Constants.CARD_KIND_JACK);
		game.getDeck().getCards()[35].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[36].setKind(Constants.CARD_KIND_QUEEN);
		game.getDeck().getCards()[36].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[37].setKind(Constants.CARD_KIND_KING);
		game.getDeck().getCards()[37].setKind(Constants.CARD_SUIT_HEARTS);
		game.getDeck().getCards()[38].setKind(Constants.CARD_KIND_ACE);
		game.getDeck().getCards()[38].setKind(Constants.CARD_SUIT_HEARTS);

		game.getDeck().getCards()[39].setKind(Constants.CARD_KIND_TWO);
		game.getDeck().getCards()[39].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[40].setKind(Constants.CARD_KIND_THREE);
		game.getDeck().getCards()[40].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[41].setKind(Constants.CARD_KIND_FOUR);
		game.getDeck().getCards()[41].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[42].setKind(Constants.CARD_KIND_FIVE);
		game.getDeck().getCards()[42].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[43].setKind(Constants.CARD_KIND_SIX);
		game.getDeck().getCards()[43].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[44].setKind(Constants.CARD_KIND_SEVEN);
		game.getDeck().getCards()[44].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[45].setKind(Constants.CARD_KIND_EIGHT);
		game.getDeck().getCards()[45].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[46].setKind(Constants.CARD_KIND_NINE);
		game.getDeck().getCards()[46].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[47].setKind(Constants.CARD_KIND_TEN);
		game.getDeck().getCards()[47].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[48].setKind(Constants.CARD_KIND_JACK);
		game.getDeck().getCards()[48].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[49].setKind(Constants.CARD_KIND_QUEEN);
		game.getDeck().getCards()[49].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[50].setKind(Constants.CARD_KIND_KING);
		game.getDeck().getCards()[50].setSuit(Constants.CARD_SUIT_SPADES);
		game.getDeck().getCards()[51].setKind(Constants.CARD_KIND_ACE);
		game.getDeck().getCards()[51].setSuit(Constants.CARD_SUIT_SPADES);

		game.getPot().setNumberOfSplits(1);
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
			Card swap = game.getDeck().getCards()[i];

			int r = prng.nextInt(Constants.NUMBER_OF_CARDS);

			game.getDeck().getCards()[i] = game.getDeck().getCards()[r];
			game.getDeck().getCards()[r] = swap;
		}
	}

	/**
	 * 
	 */
	private void fillKnownCards() {
		int playerCardsDeckIndex = 2 * Constants.HUMAN_PLAYER_INDEX;
		int tableCardsDeckIndex = 2 * game.getNumberOfPlayers();

		for (int i = 0; i < knownCards.length(); i += 2) {
			Card card = new Card();
			card.setKnown(true);

			switch (knownCards.charAt(i)) {
			case '2':
				card.setKind(Constants.CARD_KIND_TWO);
				break;
			case '3':
				card.setKind(Constants.CARD_KIND_THREE);
				break;
			case '4':
				card.setKind(Constants.CARD_KIND_FOUR);
				break;
			case '5':
				card.setKind(Constants.CARD_KIND_FIVE);
				break;
			case '6':
				card.setKind(Constants.CARD_KIND_SIX);
				break;
			case '7':
				card.setKind(Constants.CARD_KIND_SEVEN);
				break;
			case '8':
				card.setKind(Constants.CARD_KIND_EIGHT);
				break;
			case '9':
				card.setKind(Constants.CARD_KIND_NINE);
				break;
			case 'T':
				card.setKind(Constants.CARD_KIND_TEN);
				break;
			case 'J':
				card.setKind(Constants.CARD_KIND_JACK);
				break;
			case 'Q':
				card.setKind(Constants.CARD_KIND_QUEEN);
				break;
			case 'K':
				card.setKind(Constants.CARD_KIND_KING);
				break;
			case 'A':
				card.setKind(Constants.CARD_KIND_ACE);
				break;
			}

			switch (knownCards.charAt(i + 1)) {
			case 'C':
				card.setSuit(Constants.CARD_SUIT_CLUBS);
				break;
			case 'D':
				card.setSuit(Constants.CARD_SUIT_DIAMONDS);
				break;
			case 'H':
				card.setSuit(Constants.CARD_SUIT_HEARTS);
				break;
			case 'S':
				card.setSuit(Constants.CARD_SUIT_SPADES);
				break;
			}

			int j;
			for (j = 0; j < Constants.NUMBER_OF_CARDS; j++) {
				if (game.getDeck().getCards()[j].getSuit() == card.getSuit() && game.getDeck().getCards()[j].getKind() == card.getKind()) {
					break;
				}
			}

			/*
			 * Put known cards on their places.
			 */
			if (i == 0) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[playerCardsDeckIndex + 0];
				game.getDeck().getCards()[playerCardsDeckIndex + 0] = card;
			} else if (i == 2) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[playerCardsDeckIndex + 1];
				game.getDeck().getCards()[playerCardsDeckIndex + 1] = card;
			} else if (i == 4) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[tableCardsDeckIndex + 0];
				game.getDeck().getCards()[tableCardsDeckIndex + 0] = card;
			} else if (i == 6) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[tableCardsDeckIndex + 1];
				game.getDeck().getCards()[tableCardsDeckIndex + 1] = card;
			} else if (i == 8) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[tableCardsDeckIndex + 2];
				game.getDeck().getCards()[tableCardsDeckIndex + 2] = card;
			} else if (i == 10) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[tableCardsDeckIndex + 3];
				game.getDeck().getCards()[tableCardsDeckIndex + 3] = card;
			} else if (i == 12) {
				game.getDeck().getCards()[j] = game.getDeck().getCards()[tableCardsDeckIndex + 4];
				game.getDeck().getCards()[tableCardsDeckIndex + 4] = card;
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
		game.getPot().setNumberOfSplits(1);

		int j = 0;
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
			game.getPlayers()[i].getHand()[0] = game.getDeck().getCards()[j];
			j++;
			game.getPlayers()[i].getHand()[1] = game.getDeck().getCards()[j];
			j++;
		}

		game.getBoard().getFlop()[0] = game.getDeck().getCards()[j];
		j++;
		game.getBoard().getFlop()[1] = game.getDeck().getCards()[j];
		j++;
		game.getBoard().getFlop()[2] = game.getDeck().getCards()[j];
		j++;
		game.getBoard().setTurn(game.getDeck().getCards()[j]);
		j++;
		game.getBoard().setRiver(game.getDeck().getCards()[j]);
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
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
			game.getPlayers()[i].setType(Constants.PLAYER_TYPE_REGULAR);
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
		if (dealerIndex >= game.getNumberOfPlayers()) {
			dealerIndex = game.getNumberOfPlayers() - 1;
		}

		game.getPlayers()[dealerIndex].setType(Constants.PLAYER_TYPE_DEALER);
		game.getPlayers()[(dealerIndex + 1) % game.getNumberOfPlayers()].setType(Constants.PLAYER_TYPE_SMALL_BLIND);
		game.getPlayers()[(dealerIndex + 2) % game.getNumberOfPlayers()].setType(Constants.PLAYER_TYPE_BIG_BLIND);
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() != hand[2].getKind() && hand[0].getKind() != hand[3].getKind()
				&& hand[0].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[0].getKind());
			result.setFirstKicker(hand[2].getKind());
			result.setSecondKicker(hand[3].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() != hand[0].getKind() && hand[1].getKind() != hand[3].getKind()
				&& hand[1].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[3].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() != hand[0].getKind() && hand[2].getKind() != hand[1].getKind()
				&& hand[2].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[2].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[3].getKind() == hand[4].getKind() && hand[3].getKind() != hand[0].getKind() && hand[3].getKind() != hand[1].getKind()
				&& hand[3].getKind() != hand[2].getKind()) {
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
			result.setThirdKicker(hand[2].getKind());
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[2].getKind() == hand[3].getKind() && hand[0].getKind() != hand[2].getKind()
				&& hand[0].getKind() != hand[4].getKind() && hand[2].getKind() != hand[4].getKind()) {
			result.setTwoPair(hand[0].getKind());
			result.setOnePair(hand[2].getKind());
			result.setFirstKicker(hand[4].getKind());
		}

		if (hand[0].getKind() == hand[1].getKind() && hand[3].getKind() == hand[4].getKind() && hand[0].getKind() != hand[3].getKind()
				&& hand[0].getKind() != hand[2].getKind() && hand[3].getKind() != hand[2].getKind()) {
			result.setTwoPair(hand[0].getKind());
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[2].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[3].getKind() == hand[4].getKind() && hand[1].getKind() != hand[3].getKind()
				&& hand[1].getKind() != hand[0].getKind() && hand[3].getKind() != hand[0].getKind()) {
			result.setTwoPair(hand[1].getKind());
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[0].getKind());
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind() && hand[0].getKind() != hand[3].getKind()
				&& hand[0].getKind() != hand[4].getKind() && hand[3].getKind() != hand[4].getKind()) {
			result.setThreeOfKind(hand[0].getKind());
			result.setFirstKicker(hand[3].getKind());
			result.setSecondKicker(hand[4].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() == hand[3].getKind() && hand[1].getKind() != hand[0].getKind()
				&& hand[1].getKind() != hand[4].getKind() && hand[0].getKind() != hand[4].getKind()) {
			result.setThreeOfKind(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[4].getKind());
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() == hand[4].getKind() && hand[2].getKind() != hand[0].getKind()
				&& hand[2].getKind() != hand[1].getKind() && hand[0].getKind() != hand[1].getKind()) {
			result.setThreeOfKind(hand[2].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
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

		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		found = 1;
		for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
			if (hand[i].getKind() - hand[i + 1].getKind() != 1) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.setStraight(hand[0].getKind());
		}

		found = 1;
		if (hand[0].getKind() != Constants.CARD_KIND_ACE || hand[1].getKind() != Constants.CARD_KIND_FIVE) {
			found = 0;
		}
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
			if (hand[i].getKind() - hand[i + 1].getKind() != 1) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.setStraight(hand[1].getKind());
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

		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		found = 1;
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS; i++) {
			if (hand[0].getSuit() != hand[i].getSuit()) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.setFlush(1);
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
			result.setThirdKicker(hand[2].getKind());
			result.setFourthKicker(hand[3].getKind());
			result.setFifthKicker(hand[4].getKind());
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind() && hand[3].getKind() == hand[4].getKind()
				&& hand[0].getKind() != hand[3].getKind()) {
			result.setThreeOfKind(hand[0].getKind());
			result.setTwoPair(hand[3].getKind());
			result.setFullHouse(1);
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() == hand[4].getKind() && hand[0].getKind() == hand[1].getKind()
				&& hand[0].getKind() != hand[2].getKind()) {
			result.setThreeOfKind(hand[2].getKind());
			result.setTwoPair(hand[0].getKind());
			result.setFullHouse(1);
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind() && hand[0].getKind() == hand[3].getKind()
				&& hand[0].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[0].getKind());
			result.setTwoPair(hand[0].getKind());
			result.setFirstKicker(hand[4].getKind());
			result.setFourOfKind(1);
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() == hand[3].getKind() && hand[1].getKind() == hand[4].getKind()
				&& hand[1].getKind() != hand[0].getKind()) {
			result.setOnePair(hand[1].getKind());
			result.setTwoPair(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setFourOfKind(1);
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
		if (straight.getStraight() == 1 && flush.getFlush() == 1) {
			result.setFlush(flush.getFlush());
			result.setStraight(straight.getStraight());
			result.setStraightFlush(1);
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
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPair(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		/*
		 * Check for hand without combination.
		 */
		result.setFirstKicker(hand[0].getKind());
		result.setSecondKicker(hand[1].getKind());
		result.setThirdKicker(hand[2].getKind());
		result.setFourthKicker(hand[3].getKind());
		result.setFifthKicker(hand[4].getKind());

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

		allCards[0] = player.getHand()[0];
		allCards[1] = player.getHand()[1];
		allCards[2] = board.getFlop()[0];
		allCards[3] = board.getFlop()[1];
		allCards[4] = board.getFlop()[2];
		allCards[5] = board.getTurn();
		allCards[6] = board.getRiver();

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
				if (hand[i].getKind() < hand[i + 1].getKind()) {
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
				if (((hand[i].getKind() == Constants.CARD_KIND_ACE) ? Constants.CARD_KIND_WEAK_ACE
						: hand[i].getKind()) < ((hand[i + 1].getKind() == Constants.CARD_KIND_ACE) ? Constants.CARD_KIND_WEAK_ACE
								: hand[i + 1].getKind())) {
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
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
			Card[] hand = new Card[Constants.NUMBER_OF_EVALUATION_HAND_CARDS];

			game.getPlayers()[i].setHandScore(0L);

			for (int j = 0; j < Constants.NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION; j++) {
				long score = 0L;

				formFiveCardsHand(hand, j, game.getPlayers()[i], game.getBoard());

				sortWithoutLeadingAce(hand);
				score = evaluateHand(hand);
				if (score > game.getPlayers()[i].getHandScore()) {
					game.getPlayers()[i].setHandScore(score);
				}

				sortWithLeadingAce(hand);
				score = evaluateHand(hand);
				if (score > game.getPlayers()[i].getHandScore()) {
					game.getPlayers()[i].setHandScore(score);
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
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
			if (game.getPlayers()[i].getHandScore() > game.getPlayers()[bestScoreIndex].getHandScore()) {
				bestScoreIndex = i;
			}
		}

		/*
		 * Find how many players have the best score.
		 */
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
			if (game.getPlayers()[i].getHandScore() == game.getPlayers()[bestScoreIndex].getHandScore()) {
				howManyBest++;
			}
		}

		/*
		 * Update wins or ties counters.
		 */
		if (howManyBest == 1) {
			game.getPlayers()[bestScoreIndex].incrementWinsCounter();
		} else if (howManyBest > 1) {
			for (int i = 0; i < game.getNumberOfPlayers(); i++) {
				if (game.getPlayers()[i].getHandScore() == game.getPlayers()[bestScoreIndex].getHandScore()) {
					game.getPlayers()[i].incrementTiesCounter();
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
		return ((double) 100.0 * game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getWinsCounter() / (double) currentLoop);
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
		return ((double) 100.0 * (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getWinsCounter()
				+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getTiesCounter()) / (double) currentLoop);
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
				result = (double) 100.0 * (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getWinsCounter()
						+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getTiesCounter()) / (double) currentLoop;

				return (result);
			}
		}

		result = (double) 100.0 * (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getWinsCounter()
				+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX].getTiesCounter()) / (double) numberOfLoops;

		return (result);
	}
}
