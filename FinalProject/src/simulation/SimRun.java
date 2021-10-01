package simulation;

import java.util.ArrayList;

import main.LightSwitch;
import main.Room;

public class SimRun {
	// Simulates an already existing house with rooms and light switches
		public static ArrayList<Room> runSim() {
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
