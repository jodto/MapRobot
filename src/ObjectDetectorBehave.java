import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class ObjectDetectorBehave implements Behavior {
	boolean supress = false;
	
	
	DifferentialPilot pilot;
	public ObjectDetectorBehave(DifferentialPilot pilot){
		this.pilot = pilot;
		
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
