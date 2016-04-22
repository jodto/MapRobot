import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;

public class ForwardBehave implements Behavior {
	boolean supress = false;
	
	Navigator nav;
	DifferentialPilot pilot;
	DataInputStream dis;
	DataOutputStream dos;
	public ForwardBehave(DifferentialPilot pilot, DataInputStream dis, DataOutputStream dos, Navigator nav){
		this.pilot = pilot;
		this.nav = nav;
		this.dis = dis;
		this.dos = dos;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		supress = false;

		pilot.forward();
		
		float x = nav.getPoseProvider().getPose().getX();
		float y = nav.getPoseProvider().getPose().getY();
		// TODO Auto-generated method stub
		try {
			dos.writeUTF("forward" + x + "#" + y);
		//	dos.writeUTF(x + "#" + y);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		while(!supress){
			Thread.yield();		
		}
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		supress = true;
	}

}
