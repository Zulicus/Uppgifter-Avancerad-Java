package main;

import java.util.ArrayList;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;

public class Room {
	private String name;

	private ArrayList<LightSwitch> lights;

	public ToggleButton getButton(){
		ToggleButton button = new ToggleButton(name);
		return button;
	}

	public Room(String name, ArrayList<LightSwitch> lights) {
		this.name = name;
		this.lights = lights;
	}

	public ArrayList<LightSwitch> getLights() {
		return lights;
	}
	public String getName() {
		return name;
	}
}
