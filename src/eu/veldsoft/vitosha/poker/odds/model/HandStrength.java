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
	
	/**
	 * Strength of a fifth kicker.
	 */
	private long fifthKicker;
	
	/**
	 * Strength of a Fourth kicker.
	 */
	private long fourthKicker;
	
	/**
	 * Strength of a Third kicker.
	 */
	private long thirdKicker;
	
	/**
	 * Strength of a Second kicker.
	 */
	private long secondKicker;
	
	/**
	 * Strength of a First kicker.
	 */
	private long firstKicker;
	
	/**
	 * Strength of a One pair.
	 */
	private long onePair;
		
	/**
	 * Strength of a Two pair.
	 */
	private long twoPair;
	
	/**
	 * Strength of a Three of a kind.
	 */
	private long threeOfKind;
	
	/**
	 *Strength of a Straight.
	 */
	private long straight;
	
	/**
	 * Strength of a Flush.
	 */
	private long flush;
	
	/**
	 * Strength of a full house.
	 */
	private long fullHouse;
	
	/**
	 * Strength of a four of a kind.
	 */
	private long fourOfKind;
	
	/**
	 * Strength of a straight flush.
	 */
	private long straightFlush;
	
	public long getFifthKicker() {
		return fifthKicker;
	}
	
	public void setFifthKicker(long fifthKicker) {
		this.fifthKicker = fifthKicker;
	}
	
	public long getFourthKicker() {
		return fourthKicker;
	}

	public void setFourthKicker(long fourthKicker) {
		this.fourthKicker = fourthKicker;
	}

	public long getThirdKicker() {
		return thirdKicker;
	}

	public void setThirdKicker(long thirdKicker) {
		this.thirdKicker = thirdKicker;
	}

	public long getSecondKicker() {
		return secondKicker;
	}

	public void setSecondKicker(long secondKicker) {
		this.secondKicker = secondKicker;
	}

	public long getFirstKicker() {
		return firstKicker;
	}

	public void setFirstKicker(long firstKicker) {
		this.firstKicker = firstKicker;
	}

	public long getOnePair() {
		return onePair;
	}

	public void setOnePair(long onePair) {
		this.onePair = onePair;
	}

	public long getTwoPair() {
		return twoPair;
	}

	public void setTwoPair(long twoPair) {
		this.twoPair = twoPair;
	}

	public long getThreeOfKind() {
		return threeOfKind;
	}

	public void setThreeOfKind(long threeOfKind) {
		this.threeOfKind = threeOfKind;
	}

	public long getStraight() {
		return straight;
	}

	public void setStraight(long straight) {
		this.straight = straight;
	}

	public long getFlush() {
		return flush;
	}

	public void setFlush(long flush) {
		this.flush = flush;
	}

	public long getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(long fullHouse) {
		this.fullHouse = fullHouse;
	}

	public long getFourOfKind() {
		return fourOfKind;
	}

	public void setFourOfKind(long fourOfKind) {
		this.fourOfKind = fourOfKind;
	}

	public long getStraightFlush() {
		return straightFlush;
	}

	public void setStraightFlush(long straightFlush) {
		this.straightFlush = straightFlush;
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