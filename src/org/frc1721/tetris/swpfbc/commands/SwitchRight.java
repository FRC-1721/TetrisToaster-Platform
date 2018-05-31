package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.utils.EncoderConversion;
import org.frc1721.tetris.swpfbc.utils.Sides;
import org.frc1721.tetris.swpfbc.utils.SwitchSide;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchRight extends CommandGroup {

    public SwitchRight() {
        double target = EncoderConversion.getVal(8);
        SmartDashboard.putString("Status", "Auto has run");
       // addSequential(new DriveToPoint());
        Command eu = (new ElevatorUp());
        Command ec = (new EjectCube());
        
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'R') {
				eu.start();
				Timer.delay(0.2);
				ec.start();
			}
		}
       // if (SwitchSide.shouldDump(Sides.Right) == true){
        //	eu.start();
          //  Timer.delay(0.2);
            //ec.start();
        //}
    }
}
