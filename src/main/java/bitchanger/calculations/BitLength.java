/*
 * Copyright (c) 2020 - Tim Muehle und Moritz Wolter
 * 
 * Entwicklungsprojekt im Auftrag von Professorin K. Brabender und Herrn A. Koch
 * Entwickelt fuer das AID-Labor der Hochschule Bochum
 * 
 */

package bitchanger.calculations;

/**	<!-- $LANGUAGE=DE -->
 * 
 * @author Tim M\u00FChle
 * 
 * @since Bitchanger 0.1.7
 * @version 0.1.8
 * 
 */
// TODO JavaDoc
public enum BitLength {
	// TODO JavaDoc
	_8_BIT("8-Bit", 8, 0xffL), _16_BIT("16-Bit", 16, 0xffffL), _32_BIT("32-Bit", 32, 0xffffffffL), _64_BIT("64-Bit", 64, 0xffffffffffffffffL), UNKNOWN("Unbekannt", 0, 0x0L);

	private String description;
	private int numberOfBits;
	private long bitmask;

	private BitLength(String description, int numberOfBits, long bitmask) {
		this.description = description;
		this.numberOfBits = numberOfBits;
		this.bitmask = bitmask;
	}

	@Override
	public String toString() {
		return description;
	}
	
	public long maxValue() {
		if(this.equals(UNKNOWN)) {
			return 0;
		}
		
		return (long) (Math.pow(2, numberOfBits - 1) - 1);
	}
	
	public long minValue() {
		if(this.equals(UNKNOWN)) {
			return 0;
		}
		
		return (long) - Math.pow(2, numberOfBits - 1);
	}
	
	public long maxUnsignedValue() {
		if(this.equals(UNKNOWN)) {
			return 0;
		}
		
		return (long) (Math.pow(2, numberOfBits) - 1);
	}
	
	public long minUnsignedValue() {
		if(this.equals(UNKNOWN)) {
			return 0;
		}
		
		return 0;
	}
	
	public int getNumberOfBits() {
		return this.numberOfBits;
	}
	
	public long getBitmask() {
		return this.bitmask;
	}
	
}




