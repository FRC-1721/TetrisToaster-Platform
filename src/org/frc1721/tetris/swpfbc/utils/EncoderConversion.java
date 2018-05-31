package org.frc1721.tetris.swpfbc.utils;

public class EncoderConversion {
	
	/**
	 * Get the value of the encoders movement in ticks
	 * from inches.
	 * @param inches
	 * @return ticks
	 * @author Brennan
	 */
	public static double getVal(double feet) {
//		return 17383;
		return 1304 * feet;
	}
}
