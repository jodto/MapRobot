
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	private static DifferentialPilot pilot = new DifferentialPilot(
		    DifferentialPilot.WHEEL_SIZE_NXT2, 14.0, Motor.B, Motor.C);
	   
	public static void main(String[] args) {
		waitForKeyPressWithDelay(500);
    	pilot.setTravelSpeed(500);
    	System.out.println("Program Started");
    	Behavior forward = new ForwardBehave(pilot);
    	Behavior stop = new ExitBehave(pilot);
    	Behavior detect = new ObjectDetectorBehave(pilot);
    	Behavior[] behave = {forward, detect, stop};
    	
    	
        Arbitrator arb = new Arbitrator(behave);
    	arb.start();
	}
	
	public static void waitForKeyPressWithDelay(int delayTime)
    {
	System.out.println("Press any key to continue...");
	Button.waitForAnyPress();
	delay(delayTime);
    }

    public static void delay(int delayTime)

    {
	try
	{
	    Thread.sleep(delayTime);
	} catch (InterruptedException e)
	{
	    // just wake up
	}
    }
}
