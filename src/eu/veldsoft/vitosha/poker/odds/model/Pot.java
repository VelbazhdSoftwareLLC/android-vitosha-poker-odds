package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class Pot {
	long[] bets = new long[Constants.MAX_NUMBER_OF_PLAYERS];
	int numberOfSplits;
}