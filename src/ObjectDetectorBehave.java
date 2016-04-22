import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.subsumption.Behavior;

public class ObjectDetectorBehave implements Behavior, FeatureListener {
	boolean supress = false;
	private UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
	private final int securityDistance = 30;
	boolean objectDetected = false;

	DifferentialPilot pilot;
	Navigator nav;
	DataInputStream dis;
	DataOutputStream dos;
	public ObjectDetectorBehave(DifferentialPilot pilot, DataInputStream dis,DataOutputStream dos, Navigator nav){
		this.pilot = pilot;
		this.dis = dis;
		this.dos =dos;
		this.nav = nav;
	}
	@Override
	public boolean takeControl() {
	 
		return us.getDistance()< securityDistance && supress == false;
	}

	@Override
	public void action() {
	
		
				pilot.stop();
				try {
					dos.writeUTF("Object Found!");
					dos.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				pilot.rotate(90);
				
			 objectDetected = false;
			

	}

	@Override
	public void suppress() {
		supress = true;// TODO Auto-generated method stub

	}
	
	@Override
	public void featureDetected(Feature feature, FeatureDetector detector) {
		objectDetected = true;// TODO Auto-generated method stub
		
	}

}
