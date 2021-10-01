package simulation;

import java.util.ArrayList;

import javafx.scene.shape.Circle;
import main.Room;
import main.Main;

public class SimLights extends Thread {
	Circle lightIndicator;
	ArrayList<Room> rooms;
	int i;
	int j;

	public SimLights(Circle lightIndicator, int i, int j) {
this.lightIndicator=lightIndicator;
this.i=i;
this.j=j;
	}

	@Override
	public void run() {
		while (true) {
			rooms=Main.rooms;
			if (rooms.get(i).getLights().get(j).getState()) {
				lightIndicator.setFill(javafx.scene.paint.Color.GREEN);
			} else {
				lightIndicator.setFill(javafx.scene.paint.Color.RED);
			}
		}
	}
}
