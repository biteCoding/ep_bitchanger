/*
 * Copyright (c) 2020 - Tim Muehle und Moritz Wolter
 * 
 * Entwicklungsprojekt im Auftrag von Professorin K. Brabender und Herrn A. Koch
 * Entwickelt fuer das AID-Labor der Hochschule Bochum
 * 
 */

package bitchanger.calculations;

// TODO JavaDoc
/**	<!-- $LANGUAGE=DE -->
 * 
 * @author Tim M\u00FChle
 * 
 * @since Bitchanger 0.1.7
 * @version 0.1.7
 * 
 */
public enum IEEEStandard {

	// TODO JavaDoc
	IEEE_754_2008_b16(16, 5),
	
	// TODO JavaDoc
	IEEE_754_2008_b32(32, 8);
	
	
	private int bitLength;
	private int exponentLength;
	
	private IEEEStandard(int bitLength, int exponentLength) {
		this.bitLength = bitLength;
		this.exponentLength = exponentLength;
	}
	
	public int getBitLength() {
		return this.bitLength;
	}
	
	public int getExponentLength() {
		return this.exponentLength;
	}
	
}







