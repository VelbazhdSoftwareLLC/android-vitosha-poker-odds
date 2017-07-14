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
 * Monte Calo calculator class.
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
	 * Card kind constants.
	 * 
	 * @author swifty_swizzy
	 *
	 */
	private enum CardKind {
		WEAK_ACE (0x1),
		TWO (0x2),
		THREE (0x3),
		FOUR (0x4),
		FIVE (0x5),
		SIX (0x6),
		SEVEN (0x7),
		EIGHT (0x8),
		NINE (0x9),
		TEN (0xA),
		JACK (0xB),
		QUEEN (0xC),
		KING (0xD),
		ACE (0xE);

		/**
		 * Value of the constant.
		 */
		private int value;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param value
		 */
		private CardKind(int value) {
			this.value = value;
		}
		
		/**
		 * 
		 * Value of the constant getter.
		 * 
		 * @return Value of the constant.
		 */
		public int value() {
			return this.value;
		}
	}
	

	/**
	 * 
	 * Card suit constants.
	 * 
	 * @author swifty_swizzy
	 *
	 */
	private enum CardSuit {

		CLUBS (0x10),
		DIAMONDS (0x20),
		HEARTS (0x30),
		SPADES (0x40);
		
		/**
		 * Value of the constant.
		 */
		private int value;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param value
		 */
		private CardSuit(int value) {
			this.value = value;
		}
		
		/**
		 * 
		 * Value of the constant getter.
		 * 
		 * @return Value of the constant.
		 */
		public int value() {
			return this.value;
		}
	}
	
	 /** 
	 * Player constants.
	 * 
	 * @author swifty_swizzy
	 *
	 */
	private enum PlayerType {

		REGULAR (0x1),
		DEALER (0x2),
		SMALL_BLIND (0x4),
		BIG_BLIND (0x8);
		
		/**
		 * Value of the constant.
		 */
		private int value;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param value
		 */
		private PlayerType(int value) {
			this.value = value;
		}
		
		/**
		 * 
		 * Value of the constant getter.
		 * 
		 * @return Value of the constant.
		 */
		public int value() {
			return this.value;
		}
	}

	/**
	 * Simulation initialization.
	 * 
	 * @param numberOfPlayers
	 *            Number of players on the table.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void init(int numberOfPlayers) {
		game.setNumberOfPlayers(numberOfPlayers);

<<<<<<< HEAD
		for (int i = 0; i < Constants.MAX_NUMBER_OF_PLAYERS; i++) {
			game.getPlayers()[i].setMoney(Constants.MIN_PLAYER_MONEY
					+ (Math.abs(prng.nextInt())) % (Constants.MAX_PLAYER_MONEY - Constants.MIN_PLAYER_MONEY + 1));
			game.getPlayers()[i].setType(PlayerType.REGULAR.value());
=======
		for (int i = 0; i < Constants.MAX_NUMBER_OF_PLAYERS.value(); i++) {
			game.getPlayers()[i].setMoney(Constants.MIN_PLAYER_MONEY.value()
					+ (Math.abs(prng.nextInt())) % (Constants.MAX_PLAYER_MONEY.value() - Constants.MIN_PLAYER_MONEY.value() + 1));
			game.getPlayers()[i].setType(Constants.PLAYER_TYPE_REGULAR.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
			game.getPlayers()[i].setWinsCounter(0L);
			game.getPlayers()[i].setTiesCounter(0L);
		}

		for (int i = 0; i < Constants.NUMBER_OF_CARDS.value(); i++) {
			game.getDeck().getCards()[i].setKnown(false);
		}

<<<<<<< HEAD
		game.getDeck().getCards()[0].setKind(CardKind.TWO.value());
		game.getDeck().getCards()[0].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[1].setKind(CardKind.THREE.value());
		game.getDeck().getCards()[1].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[2].setKind(CardKind.FOUR.value());
		game.getDeck().getCards()[2].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[3].setKind(CardKind.FIVE.value());
		game.getDeck().getCards()[3].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[4].setKind(CardKind.SIX.value());
		game.getDeck().getCards()[4].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[5].setKind(CardKind.SEVEN.value());
		game.getDeck().getCards()[5].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[6].setKind(CardKind.EIGHT.value());
		game.getDeck().getCards()[6].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[7].setKind(CardKind.NINE.value());
		game.getDeck().getCards()[7].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[8].setKind(CardKind.TEN.value());
		game.getDeck().getCards()[8].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[9].setKind(CardKind.JACK.value());
		game.getDeck().getCards()[9].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[10].setKind(CardKind.QUEEN.value());
		game.getDeck().getCards()[10].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[11].setKind(CardKind.KING.value());
		game.getDeck().getCards()[11].setSuit(CardSuit.CLUBS.value());
		game.getDeck().getCards()[12].setKind(CardKind.ACE.value());
		game.getDeck().getCards()[12].setSuit(CardSuit.CLUBS.value());

		game.getDeck().getCards()[13].setKind(CardKind.TWO.value());
		game.getDeck().getCards()[13].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[14].setKind(CardKind.THREE.value());
		game.getDeck().getCards()[14].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[15].setKind(CardKind.FOUR.value());
		game.getDeck().getCards()[15].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[16].setKind(CardKind.FIVE.value());
		game.getDeck().getCards()[16].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[17].setKind(CardKind.SIX.value());
		game.getDeck().getCards()[17].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[18].setKind(CardKind.SEVEN.value());
		game.getDeck().getCards()[18].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[19].setKind(CardKind.EIGHT.value());
		game.getDeck().getCards()[19].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[20].setKind(CardKind.NINE.value());
		game.getDeck().getCards()[20].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[21].setKind(CardKind.TEN.value());
		game.getDeck().getCards()[21].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[22].setKind(CardKind.JACK.value());
		game.getDeck().getCards()[22].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[23].setKind(CardKind.QUEEN.value());
		game.getDeck().getCards()[23].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[24].setKind(CardKind.KING.value());
		game.getDeck().getCards()[24].setKind(CardSuit.DIAMONDS.value());
		game.getDeck().getCards()[25].setKind(CardKind.ACE.value());
		game.getDeck().getCards()[25].setKind(CardSuit.DIAMONDS.value());

		game.getDeck().getCards()[26].setKind(CardKind.TWO.value());
		game.getDeck().getCards()[26].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[27].setKind(CardKind.THREE.value());
		game.getDeck().getCards()[27].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[28].setKind(CardKind.FOUR.value());
		game.getDeck().getCards()[28].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[29].setKind(CardKind.FIVE.value());
		game.getDeck().getCards()[29].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[30].setKind(CardKind.SIX.value());
		game.getDeck().getCards()[30].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[31].setKind(CardKind.SEVEN.value());
		game.getDeck().getCards()[31].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[32].setKind(CardKind.EIGHT.value());
		game.getDeck().getCards()[32].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[33].setKind(CardKind.NINE.value());
		game.getDeck().getCards()[33].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[34].setKind(CardKind.TEN.value());
		game.getDeck().getCards()[34].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[35].setKind(CardKind.JACK.value());
		game.getDeck().getCards()[35].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[36].setKind(CardKind.QUEEN.value());
		game.getDeck().getCards()[36].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[37].setKind(CardKind.KING.value());
		game.getDeck().getCards()[37].setKind(CardSuit.HEARTS.value());
		game.getDeck().getCards()[38].setKind(CardKind.ACE.value());
		game.getDeck().getCards()[38].setKind(CardSuit.HEARTS.value());

		game.getDeck().getCards()[39].setKind(CardKind.TWO.value());
		game.getDeck().getCards()[39].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[40].setKind(CardKind.THREE.value());
		game.getDeck().getCards()[40].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[41].setKind(CardKind.FOUR.value());
		game.getDeck().getCards()[41].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[42].setKind(CardKind.FIVE.value());
		game.getDeck().getCards()[42].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[43].setKind(CardKind.SIX.value());
		game.getDeck().getCards()[43].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[44].setKind(CardKind.SEVEN.value());
		game.getDeck().getCards()[44].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[45].setKind(CardKind.EIGHT.value());
		game.getDeck().getCards()[45].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[46].setKind(CardKind.NINE.value());
		game.getDeck().getCards()[46].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[47].setKind(CardKind.TEN.value());
		game.getDeck().getCards()[47].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[48].setKind(CardKind.JACK.value());
		game.getDeck().getCards()[48].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[49].setKind(CardKind.QUEEN.value());
		game.getDeck().getCards()[49].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[50].setKind(CardKind.KING.value());
		game.getDeck().getCards()[50].setSuit(CardSuit.SPADES.value());
		game.getDeck().getCards()[51].setKind(CardKind.ACE.value());
		game.getDeck().getCards()[51].setSuit(CardSuit.SPADES.value());
=======
		game.getDeck().getCards()[0].setKind(Constants.CARD_KIND_TWO.value());
		game.getDeck().getCards()[0].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[1].setKind(Constants.CARD_KIND_THREE.value());
		game.getDeck().getCards()[1].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[2].setKind(Constants.CARD_KIND_FOUR.value());
		game.getDeck().getCards()[2].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[3].setKind(Constants.CARD_KIND_FIVE.value());
		game.getDeck().getCards()[3].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[4].setKind(Constants.CARD_KIND_SIX.value());
		game.getDeck().getCards()[4].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[5].setKind(Constants.CARD_KIND_SEVEN.value());
		game.getDeck().getCards()[5].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[6].setKind(Constants.CARD_KIND_EIGHT.value());
		game.getDeck().getCards()[6].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[7].setKind(Constants.CARD_KIND_NINE.value());
		game.getDeck().getCards()[7].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[8].setKind(Constants.CARD_KIND_TEN.value());
		game.getDeck().getCards()[8].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[9].setKind(Constants.CARD_KIND_JACK.value());
		game.getDeck().getCards()[9].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[10].setKind(Constants.CARD_KIND_QUEEN.value());
		game.getDeck().getCards()[10].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[11].setKind(Constants.CARD_KIND_KING.value());
		game.getDeck().getCards()[11].setSuit(Constants.CARD_SUIT_CLUBS.value());
		game.getDeck().getCards()[12].setKind(Constants.CARD_KIND_ACE.value());
		game.getDeck().getCards()[12].setSuit(Constants.CARD_SUIT_CLUBS.value());

		game.getDeck().getCards()[13].setKind(Constants.CARD_KIND_TWO.value());
		game.getDeck().getCards()[13].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[14].setKind(Constants.CARD_KIND_THREE.value());
		game.getDeck().getCards()[14].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[15].setKind(Constants.CARD_KIND_FOUR.value());
		game.getDeck().getCards()[15].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[16].setKind(Constants.CARD_KIND_FIVE.value());
		game.getDeck().getCards()[16].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[17].setKind(Constants.CARD_KIND_SIX.value());
		game.getDeck().getCards()[17].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[18].setKind(Constants.CARD_KIND_SEVEN.value());
		game.getDeck().getCards()[18].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[19].setKind(Constants.CARD_KIND_EIGHT.value());
		game.getDeck().getCards()[19].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[20].setKind(Constants.CARD_KIND_NINE.value());
		game.getDeck().getCards()[20].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[21].setKind(Constants.CARD_KIND_TEN.value());
		game.getDeck().getCards()[21].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[22].setKind(Constants.CARD_KIND_JACK.value());
		game.getDeck().getCards()[22].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[23].setKind(Constants.CARD_KIND_QUEEN.value());
		game.getDeck().getCards()[23].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[24].setKind(Constants.CARD_KIND_KING.value());
		game.getDeck().getCards()[24].setKind(Constants.CARD_SUIT_DIAMONDS.value());
		game.getDeck().getCards()[25].setKind(Constants.CARD_KIND_ACE.value());
		game.getDeck().getCards()[25].setKind(Constants.CARD_SUIT_DIAMONDS.value());

		game.getDeck().getCards()[26].setKind(Constants.CARD_KIND_TWO.value());
		game.getDeck().getCards()[26].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[27].setKind(Constants.CARD_KIND_THREE.value());
		game.getDeck().getCards()[27].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[28].setKind(Constants.CARD_KIND_FOUR.value());
		game.getDeck().getCards()[28].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[29].setKind(Constants.CARD_KIND_FIVE.value());
		game.getDeck().getCards()[29].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[30].setKind(Constants.CARD_KIND_SIX.value());
		game.getDeck().getCards()[30].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[31].setKind(Constants.CARD_KIND_SEVEN.value());
		game.getDeck().getCards()[31].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[32].setKind(Constants.CARD_KIND_EIGHT.value());
		game.getDeck().getCards()[32].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[33].setKind(Constants.CARD_KIND_NINE.value());
		game.getDeck().getCards()[33].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[34].setKind(Constants.CARD_KIND_TEN.value());
		game.getDeck().getCards()[34].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[35].setKind(Constants.CARD_KIND_JACK.value());
		game.getDeck().getCards()[35].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[36].setKind(Constants.CARD_KIND_QUEEN.value());
		game.getDeck().getCards()[36].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[37].setKind(Constants.CARD_KIND_KING.value());
		game.getDeck().getCards()[37].setKind(Constants.CARD_SUIT_HEARTS.value());
		game.getDeck().getCards()[38].setKind(Constants.CARD_KIND_ACE.value());
		game.getDeck().getCards()[38].setKind(Constants.CARD_SUIT_HEARTS.value());

		game.getDeck().getCards()[39].setKind(Constants.CARD_KIND_TWO.value());
		game.getDeck().getCards()[39].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[40].setKind(Constants.CARD_KIND_THREE.value());
		game.getDeck().getCards()[40].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[41].setKind(Constants.CARD_KIND_FOUR.value());
		game.getDeck().getCards()[41].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[42].setKind(Constants.CARD_KIND_FIVE.value());
		game.getDeck().getCards()[42].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[43].setKind(Constants.CARD_KIND_SIX.value());
		game.getDeck().getCards()[43].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[44].setKind(Constants.CARD_KIND_SEVEN.value());
		game.getDeck().getCards()[44].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[45].setKind(Constants.CARD_KIND_EIGHT.value());
		game.getDeck().getCards()[45].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[46].setKind(Constants.CARD_KIND_NINE.value());
		game.getDeck().getCards()[46].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[47].setKind(Constants.CARD_KIND_TEN.value());
		game.getDeck().getCards()[47].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[48].setKind(Constants.CARD_KIND_JACK.value());
		game.getDeck().getCards()[48].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[49].setKind(Constants.CARD_KIND_QUEEN.value());
		game.getDeck().getCards()[49].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[50].setKind(Constants.CARD_KIND_KING.value());
		game.getDeck().getCards()[50].setSuit(Constants.CARD_SUIT_SPADES.value());
		game.getDeck().getCards()[51].setKind(Constants.CARD_KIND_ACE.value());
		game.getDeck().getCards()[51].setSuit(Constants.CARD_SUIT_SPADES.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52

		game.getPot().setNumberOfSplits(1);
	}

	/**
	 * Deck shuffle.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void shuffle() {
		for (int i = 0; i < Constants.NUMBER_OF_CARDS.value(); i++) {
			Card swap = game.getDeck().getCards()[i];

			int r = prng.nextInt(Constants.NUMBER_OF_CARDS.value());

			game.getDeck().getCards()[i] = game.getDeck().getCards()[r];
			game.getDeck().getCards()[r] = swap;
		}
	}

	/**
	 * Mark already known cards.
	 */
	private void fillKnownCards() {
		int playerCardsDeckIndex = 2 * Constants.HUMAN_PLAYER_INDEX.value();
		int tableCardsDeckIndex = 2 * game.getNumberOfPlayers();

		for (int i = 0; i < knownCards.length(); i += 2) {
			Card card = new Card();
			card.setKnown(true);

			switch (knownCards.charAt(i)) {
			case '2':
<<<<<<< HEAD
				card.setKind(CardKind.TWO.value());
				break;
			case '3':
				card.setKind(CardKind.THREE.value());
				break;
			case '4':
				card.setKind(CardKind.FOUR.value());
				break;
			case '5':
				card.setKind(CardKind.FIVE.value());
				break;
			case '6':
				card.setKind(CardKind.SIX.value());
				break;
			case '7':
				card.setKind(CardKind.SEVEN.value());
				break;
			case '8':
				card.setKind(CardKind.EIGHT.value());
				break;
			case '9':
				card.setKind(CardKind.NINE.value());
				break;
			case 'T':
				card.setKind(CardKind.TEN.value());
				break;
			case 'J':
				card.setKind(CardKind.JACK.value());
				break;
			case 'Q':
				card.setKind(CardKind.QUEEN.value());
				break;
			case 'K':
				card.setKind(CardKind.KING.value());
				break;
			case 'A':
				card.setKind(CardKind.ACE.value());
=======
				card.setKind(Constants.CARD_KIND_TWO.value());
				break;
			case '3':
				card.setKind(Constants.CARD_KIND_THREE.value());
				break;
			case '4':
				card.setKind(Constants.CARD_KIND_FOUR.value());
				break;
			case '5':
				card.setKind(Constants.CARD_KIND_FIVE.value());
				break;
			case '6':
				card.setKind(Constants.CARD_KIND_SIX.value());
				break;
			case '7':
				card.setKind(Constants.CARD_KIND_SEVEN.value());
				break;
			case '8':
				card.setKind(Constants.CARD_KIND_EIGHT.value());
				break;
			case '9':
				card.setKind(Constants.CARD_KIND_NINE.value());
				break;
			case 'T':
				card.setKind(Constants.CARD_KIND_TEN.value());
				break;
			case 'J':
				card.setKind(Constants.CARD_KIND_JACK.value());
				break;
			case 'Q':
				card.setKind(Constants.CARD_KIND_QUEEN.value());
				break;
			case 'K':
				card.setKind(Constants.CARD_KIND_KING.value());
				break;
			case 'A':
				card.setKind(Constants.CARD_KIND_ACE.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
				break;
			}

			switch (knownCards.charAt(i + 1)) {
			case 'C':
<<<<<<< HEAD
				card.setSuit(CardSuit.CLUBS.value());
				break;
			case 'D':
				card.setSuit(CardSuit.DIAMONDS.value());
				break;
			case 'H':
				card.setSuit(CardSuit.HEARTS.value());
				break;
			case 'S':
				card.setSuit(CardSuit.SPADES.value());
=======
				card.setSuit(Constants.CARD_SUIT_CLUBS.value());
				break;
			case 'D':
				card.setSuit(Constants.CARD_SUIT_DIAMONDS.value());
				break;
			case 'H':
				card.setSuit(Constants.CARD_SUIT_HEARTS.value());
				break;
			case 'S':
				card.setSuit(Constants.CARD_SUIT_SPADES.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
				break;
			}

			int j;
			for (j = 0; j < Constants.NUMBER_OF_CARDS.value(); j++) {
				if (game.getDeck().getCards()[j].getSuit() == card.getSuit()
						&& game.getDeck().getCards()[j].getKind() == card.getKind()) {
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
	 * Deal cards on the table.
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
	 * Mar all players as regular players.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private void allPlayersRegular() {
		for (int i = 0; i < game.getNumberOfPlayers(); i++) {
<<<<<<< HEAD
			game.getPlayers()[i].setType(PlayerType.REGULAR.value());
=======
			game.getPlayers()[i].setType(Constants.PLAYER_TYPE_REGULAR.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
		}
	}

	/**
	 * Mark dealer index.
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

<<<<<<< HEAD
		game.getPlayers()[dealerIndex].setType(PlayerType.DEALER.value());
		game.getPlayers()[(dealerIndex + 1) % game.getNumberOfPlayers()].setType(PlayerType.SMALL_BLIND.value());
		game.getPlayers()[(dealerIndex + 2) % game.getNumberOfPlayers()].setType(PlayerType.BIG_BLIND.value());
=======
		game.getPlayers()[dealerIndex].setType(Constants.PLAYER_TYPE_DEALER.value());
		game.getPlayers()[(dealerIndex + 1) % game.getNumberOfPlayers()].setType(Constants.PLAYER_TYPE_SMALL_BLIND.value());
		game.getPlayers()[(dealerIndex + 2) % game.getNumberOfPlayers()].setType(Constants.PLAYER_TYPE_BIG_BLIND.value());
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
	}

	/**
	 * Evaluate hand of one pair.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() != hand[2].getKind()
				&& hand[0].getKind() != hand[3].getKind() && hand[0].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[0].getKind());
			result.setFirstKicker(hand[2].getKind());
			result.setSecondKicker(hand[3].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() != hand[0].getKind()
				&& hand[1].getKind() != hand[3].getKind() && hand[1].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[3].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() != hand[0].getKind()
				&& hand[2].getKind() != hand[1].getKind() && hand[2].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[2].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
			result.setThirdKicker(hand[4].getKind());
		}

		if (hand[3].getKind() == hand[4].getKind() && hand[3].getKind() != hand[0].getKind()
				&& hand[3].getKind() != hand[1].getKind() && hand[3].getKind() != hand[2].getKind()) {
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
			result.setThirdKicker(hand[2].getKind());
		}

		return (result);
	}

	/**
	 * Evaluate hand of two pairs.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	private HandStrength evaluateTwoPairs(Card[] hand) {
		HandStrength result = new HandStrength();
		result.setFifthKicker(0);
		result.setFourthKicker(0);
		result.setThirdKicker(0);
		result.setSecondKicker(0);
		result.setFirstKicker(0);
		result.setOnePair(0);
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[2].getKind() == hand[3].getKind()
				&& hand[0].getKind() != hand[2].getKind() && hand[0].getKind() != hand[4].getKind()
				&& hand[2].getKind() != hand[4].getKind()) {
			result.setTwoPairs(hand[0].getKind());
			result.setOnePair(hand[2].getKind());
			result.setFirstKicker(hand[4].getKind());
		}

		if (hand[0].getKind() == hand[1].getKind() && hand[3].getKind() == hand[4].getKind()
				&& hand[0].getKind() != hand[3].getKind() && hand[0].getKind() != hand[2].getKind()
				&& hand[3].getKind() != hand[2].getKind()) {
			result.setTwoPairs(hand[0].getKind());
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[2].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[3].getKind() == hand[4].getKind()
				&& hand[1].getKind() != hand[3].getKind() && hand[1].getKind() != hand[0].getKind()
				&& hand[3].getKind() != hand[0].getKind()) {
			result.setTwoPairs(hand[1].getKind());
			result.setOnePair(hand[3].getKind());
			result.setFirstKicker(hand[0].getKind());
		}

		return (result);
	}

	/**
	 * Evaluate hand of three of a kind.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind()
				&& hand[0].getKind() != hand[3].getKind() && hand[0].getKind() != hand[4].getKind()
				&& hand[3].getKind() != hand[4].getKind()) {
			result.setThreeOfKind(hand[0].getKind());
			result.setFirstKicker(hand[3].getKind());
			result.setSecondKicker(hand[4].getKind());
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() == hand[3].getKind()
				&& hand[1].getKind() != hand[0].getKind() && hand[1].getKind() != hand[4].getKind()
				&& hand[0].getKind() != hand[4].getKind()) {
			result.setThreeOfKind(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[4].getKind());
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() == hand[4].getKind()
				&& hand[2].getKind() != hand[0].getKind() && hand[2].getKind() != hand[1].getKind()
				&& hand[0].getKind() != hand[1].getKind()) {
			result.setThreeOfKind(hand[2].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setSecondKicker(hand[1].getKind());
		}

		return (result);
	}

	/**
	 * Evaluate hand of straight.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		found = 1;
		for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value() - 1; i++) {
			if (hand[i].getKind() - hand[i + 1].getKind() != 1) {
				found = 0;
				break;
			}
		}
		if (found == 1) {
			result.setStraight(hand[0].getKind());
		}

		found = 1;
<<<<<<< HEAD
		if (hand[0].getKind() != CardKind.ACE.value() || hand[1].getKind() != CardKind.FIVE.value()) {
=======
		if (hand[0].getKind() != Constants.CARD_KIND_ACE.value() || hand[1].getKind() != Constants.CARD_KIND_FIVE.value()) {
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
			found = 0;
		}
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value() - 1; i++) {
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
	 * Evaluate hand of flush.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		found = 1;
		for (i = 1; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value(); i++) {
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
	 * Evaluate hand of full house.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind()
				&& hand[3].getKind() == hand[4].getKind() && hand[0].getKind() != hand[3].getKind()) {
			result.setThreeOfKind(hand[0].getKind());
			result.setTwoPairs(hand[3].getKind());
			result.setFullHouse(1);
		}

		if (hand[2].getKind() == hand[3].getKind() && hand[2].getKind() == hand[4].getKind()
				&& hand[0].getKind() == hand[1].getKind() && hand[0].getKind() != hand[2].getKind()) {
			result.setThreeOfKind(hand[2].getKind());
			result.setTwoPairs(hand[0].getKind());
			result.setFullHouse(1);
		}

		return (result);
	}

	/**
	 * Evaluate hand of four of a kind.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
		result.setThreeOfKind(0);
		result.setStraight(0);
		result.setFlush(0);
		result.setFullHouse(0);
		result.setFourOfKind(0);
		result.setStraightFlush(0);

		if (hand[0].getKind() == hand[1].getKind() && hand[0].getKind() == hand[2].getKind()
				&& hand[0].getKind() == hand[3].getKind() && hand[0].getKind() != hand[4].getKind()) {
			result.setOnePair(hand[0].getKind());
			result.setTwoPairs(hand[0].getKind());
			result.setFirstKicker(hand[4].getKind());
			result.setFourOfKind(1);
		}

		if (hand[1].getKind() == hand[2].getKind() && hand[1].getKind() == hand[3].getKind()
				&& hand[1].getKind() == hand[4].getKind() && hand[1].getKind() != hand[0].getKind()) {
			result.setOnePair(hand[1].getKind());
			result.setTwoPairs(hand[1].getKind());
			result.setFirstKicker(hand[0].getKind());
			result.setFourOfKind(1);
		}

		return (result);
	}

	/**
	 * Evaluate hand of straight flush.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
	 * Evaluate hand of kikcers.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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
		result.setTwoPairs(0);
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
	 * Evaluate hand.
	 * 
	 * @param hand
	 *            Cards in the hand.
	 * 
	 * @return Hand strength value.
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

		strength = evaluateTwoPairs(hand);
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
	 * Five cards hand forming.
	 * 
	 * @param hand
	 *            Array of cards.
	 * 
	 * @param index
	 *            Index of the current combination.
	 * 
	 * @param player
	 *            Current player.
	 * 
	 * @param board
	 *            Reference to the board object.
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

		Card[] allCards = new Card[Constants.NUMBER_OF_KNOWN_CARDS.value()];

		allCards[0] = player.getHand()[0];
		allCards[1] = player.getHand()[1];
		allCards[2] = board.getFlop()[0];
		allCards[3] = board.getFlop()[1];
		allCards[4] = board.getFlop()[2];
		allCards[5] = board.getTurn();
		allCards[6] = board.getRiver();

		if (index < 0 || index >= Constants.NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION.value()) {
			// TODO Exception handling!
			return;
		}

		for (int i = 0, j = 0; i < Constants.NUMBER_OF_KNOWN_CARDS.value(); i++) {
			if (combinations[index][i] == 1) {
				hand[j] = allCards[i];
				j++;
			}
		}

	}

	/**
	 * Hand sort with leading ace.
	 * 
	 * @param hand
	 *            Array of cards.
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
			for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value() - 1; i++) {
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
	 * Hand sort without leading ace.
	 * 
	 * @param hand
	 *            Array of cards.
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
<<<<<<< HEAD
			for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS - 1; i++) {
				if (((hand[i].getKind() == CardKind.ACE.value()) ? CardKind.WEAK_ACE.value()
						: hand[i].getKind()) < ((hand[i + 1].getKind() == CardKind.ACE.value())
								? CardKind.WEAK_ACE.value() : hand[i + 1].getKind())) {
=======
			for (i = 0; i < Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value() - 1; i++) {
				if (((hand[i].getKind() == Constants.CARD_KIND_ACE.value()) ? Constants.CARD_KIND_WEAK_ACE.value()
						: hand[i].getKind()) < ((hand[i + 1].getKind() == Constants.CARD_KIND_ACE.value())
								? Constants.CARD_KIND_WEAK_ACE.value() : hand[i + 1].getKind())) {
>>>>>>> e1f4108e774bea4d6733e3d0fe59d743fd9aaf52
					swap = hand[i];
					hand[i] = hand[i + 1];
					hand[i + 1] = swap;
					done = 0;
				}
			}
		}
	}

	/**
	 * Hand scor calculation.
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
			Card[] hand = new Card[Constants.NUMBER_OF_EVALUATION_HAND_CARDS.value()];

			game.getPlayers()[i].setHandScore(0L);

			for (int j = 0; j < Constants.NUMBER_OF_POSSIBLE_HANDS_FOR_EVALUATION.value(); j++) {
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
	 * Wins counter update.
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
	 * Monte Carlo simulation entry point.
	 * 
	 * @param numberOfLoops
	 *            How many card in the flop are known.
	 * 
	 * @param numberOfPlayers
	 *            How may player are on the table.
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
		if (numberOfPlayers < Constants.MIN_NUMBER_OF_PLAYERS.value()) {
			numberOfPlayers = Constants.MIN_NUMBER_OF_PLAYERS.value();
		}
		if (numberOfPlayers > Constants.MAX_NUMBER_OF_PLAYERS.value()) {
			numberOfPlayers = Constants.MAX_NUMBER_OF_PLAYERS.value();
		}

		if (numberOfLoops < Constants.MIN_NUMBER_OF_LOOPS.value()) {
			numberOfLoops = Constants.MIN_NUMBER_OF_LOOPS.value();
		}
		if (numberOfLoops > Constants.MAX_NUMBER_OF_LOOPS.value()) {
			numberOfLoops = Constants.MAX_NUMBER_OF_LOOPS.value();
		}

		/*
		 * Initialize the table with players and cards.
		 */
		init(numberOfPlayers);

		this.knownCards = knownCards;
		this.numberOfLoops = numberOfLoops;
	}

	/**
	 * Win chances.
	 * 
	 * @return Percent of the win chances.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	synchronized public double willWinIn() {
		return ((double) 100.0 * game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getWinsCounter()
				/ (double) currentLoop);
	}

	/**
	 * Tie and loose chances.
	 * 
	 * @return Percent of the tie and loose chances.
	 * 
	 * @author Todor Balabanov
	 * 
	 * @email tdb@tbsoft.eu
	 * 
	 * @date 09 Aug 2012
	 */
	synchronized public double willNotLooseIn() {
		return ((double) 100.0 * (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getWinsCounter()
				+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getTiesCounter()) / (double) currentLoop);
	}

	/**
	 * Simulation stop.
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
	 * Simulation start.
	 * 
	 * @return Simulation results.
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
				result = (double) 100.0
						* (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getWinsCounter()
								+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getTiesCounter())
						/ (double) currentLoop;

				return (result);
			}
		}

		result = (double) 100.0 * (game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getWinsCounter()
				+ game.getPlayers()[Constants.HUMAN_PLAYER_INDEX.value()].getTiesCounter()) / (double) numberOfLoops;

		return (result);
	}
}
