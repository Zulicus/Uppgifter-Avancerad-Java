package main;

import java.util.ArrayList;

import javafx.scene.control.ToggleButton;

//Class that saves a room
public class Room {
	// Each room has a name
	private String name;
	// Each room has a number of light switches
	private ArrayList<LightSwitch> lights;

	// Constructor
	public Room(String name, ArrayList<LightSwitch> lights) {
		this.name = name;
		this.lights = lights;
	}

	// Creates a Button with the name of the room as it's text
	public ToggleButton getButton() {
		ToggleButton button = new ToggleButton(name);
		return button;
	}

	// Returns an Array containing all the Light Switches in the room
	public ArrayList<LightSwitch> getLights() {
		return lights;
	}

	// Returns the name of the room
	public String getName() {
		return name;
	}
}
