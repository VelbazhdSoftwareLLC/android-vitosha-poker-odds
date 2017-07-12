package eu.veldsoft.vitosha.poker.odds.model;

/**
 * 
 * @author Todor Balabanov
 * 
 * @email tdb@tbsoft.eu
 * 
 * @date 09 Aug 2012
 */
class HandStrength {
	long fifthKicker;
	long fourthKicker;
	long thirdKicker;
	long secondKicker;
	long firstKicker;
	long onePair;
	long twoPair;
	long threeOfKind;
	long straight;
	long flush;
	long fullHouse;
	long fourOfKind;
	long straightFlush;

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
	long getValue() {
		long result = 0L;

		int offset = 0;

		/*
		 * long fifthKicker:(4);
		 */
		result |= (fifthKicker << offset);
		offset += 4;

		/*
		 * long fourthKicker:(4);
		 */
		result |= (fourthKicker << offset);
		offset += 4;

		/*
		 * long thirdKicker:(4);
		 */
		result |= (thirdKicker << offset);
		offset += 4;

		/*
		 * long secondKicker:(4);
		 */
		result |= (secondKicker << offset);
		offset += 4;

		/*
		 * long firstKicker:(4);
		 */
		result |= (firstKicker << offset);
		offset += 4;

		/*
		 * long onePair:(4);
		 */
		result |= (onePair << offset);
		offset += 4;

		/*
		 * long twoPair:(4);
		 */
		result |= (twoPair << offset);
		offset += 4;

		/*
		 * long threeOfKind:(4);
		 */
		result |= (threeOfKind << offset);
		offset += 4;

		/*
		 * long straight:(4);
		 */
		result |= (straight << offset);
		offset += 4;

		/*
		 * long flush:(1);
		 */
		result |= (flush << offset);
		offset += 1;

		/*
		 * long fullHouse:(1);
		 */
		result |= (fullHouse << offset);
		offset += 1;

		/*
		 * long fourOfKind:(1);
		 */
		result |= (fourOfKind << offset);
		offset += 1;

		/*
		 * long straightFlush:(1);
		 */
		result |= (straightFlush << offset);
		offset += 1;

		return (result);
	}
}