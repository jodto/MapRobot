import java.io.DataInputStream;
import java.io.DataOutputStream;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class ObjectDetectorBehave implements Behavior {
	boolean supress = false;
	
	
	DifferentialPilot pilot;
	DataInputStream dis;
	DataOutputStream dos;
	public ObjectDetectorBehave(DifferentialPilot pilot, DataInputStream dis,DataOutputStream dos){
		this.pilot = pilot;
		this.dis = dis;
		this.dos =dos;
	}
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
