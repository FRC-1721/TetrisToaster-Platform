package org.frc1721.tetris.swpfbc;

/**
 * ControlsMap.java
 * <p>This class stores all of the controls of the robot in a safe
 * place that isn't {@link RobotMap.java} to avoid clutter.
 * 
 * @author Brennan
 *
 */
public class ControlsMap {

	/* All types should be marked final - i.e. they won't change */
	public static final int joyPort = 0,
							controllerPort = 1;
	 
	public static final int closeBtn = 5,
							openBtn = 6,
							climbBtn = 1;
	
	public static final int raiseLiftAxis = 3,
							lowerLiftAxis = 2,
							spinAxis = 5;
	
	
}
