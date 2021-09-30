package simulation;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.LightSwitch;
import main.Room;

public class SimMain extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// UI setup
		arg0.setTitle("Lights");
		StackPane stackPane = new StackPane();
		Button btn = new Button("test");
		stackPane.getChildren().add(btn);
		Scene livingRoom = new Scene(stackPane, 1200, 600);
		arg0.setScene(livingRoom);
		arg0.show();
	}

	public ArrayList<Room> getRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		ArrayList<LightSwitch> livingroomLights = new ArrayList<LightSwitch>();
		livingroomLights.add(new LightSwitch("Ceiling Light (TV)", false));
		livingroomLights.add(new LightSwitch("Ceiling Light (Dining)", false));
		livingroomLights.add(new LightSwitch("Window Light 1", true));
		livingroomLights.add(new LightSwitch("Window Light 2", true));
		livingroomLights.add(new LightSwitch("Window Light 3", true));
		livingroomLights.add(new LightSwitch("Window Light 4", false));
		livingroomLights.add(new LightSwitch("Floor Light 1", true));
		livingroomLights.add(new LightSwitch("Floor Light 2", true));
		rooms.add(new Room("Livingroom", livingroomLights));
		ArrayList<LightSwitch> bedroomLights = new ArrayList<LightSwitch>();
		bedroomLights.add(new LightSwitch("Ceiling Light 1", true));
		bedroomLights.add(new LightSwitch("Ceiling Light 2", true));
		bedroomLights.add(new LightSwitch("Window Light", false));
		bedroomLights.add(new LightSwitch("Night Light", true));
		rooms.add(new Room("Bedroom", bedroomLights));
		ArrayList<LightSwitch> kitchenLights = new ArrayList<LightSwitch>();
		kitchenLights.add(new LightSwitch("Ceiling Light", true));
		kitchenLights.add(new LightSwitch("Stove Light", false));
		kitchenLights.add(new LightSwitch("Workbench Light", true));
		kitchenLights.add(new LightSwitch("Cupboard Light", true));
		kitchenLights.add(new LightSwitch("Window Light 1", true));
		kitchenLights.add(new LightSwitch("Window Light 2", true));
		rooms.add(new Room("Kitchen", kitchenLights));
		ArrayList<LightSwitch> hallwayLights = new ArrayList<LightSwitch>();
		hallwayLights.add(new LightSwitch("Ceiling Light 1", false));
		hallwayLights.add(new LightSwitch("Ceiling Light 2", false));
		hallwayLights.add(new LightSwitch("Wall Light", true));
		rooms.add(new Room("Hallway", hallwayLights));
		return rooms;
	}

}
