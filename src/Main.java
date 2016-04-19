
import java.io.DataInputStream;
import java.io.DataOutputStream;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	private static DifferentialPilot pilot = new DifferentialPilot(
		    DifferentialPilot.WHEEL_SIZE_NXT2, 14.0, Motor.B, Motor.C);
	   
	public static void main(String[] args) {
		
		 	LCD.clear();
		    LCD.drawString("Waiting for client connection...", 0, 0);
		    
		    BTConnection btc = Bluetooth.waitForConnection();	    
		    
		    LCD.drawString("Client connected", 0, 0);
		    
		    DataInputStream dis = new DataInputStream(btc.openDataInputStream());
		    DataOutputStream dos = new DataOutputStream(btc.openDataOutputStream());
		    
		waitForKeyPressWithDelay(500);
    	pilot.setTravelSpeed(500);
    	System.out.println("Program Started");
    	Behavior forward = new ForwardBehave(pilot);
    	Behavior stop = new ExitBehave(pilot);
    	Behavior detect = new ObjectDetectorBehave(pilot, dis, dos);
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
