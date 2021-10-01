package main;

import javafx.scene.control.Button;

//Class that saves a Light Switch
public class LightSwitch {
	// Each light switch can be on or off
	private boolean status;
	// Each light switch has a name
	private String name;

	// Constructor
	public LightSwitch(String name, boolean status) {
		this.status = status;
		this.name = name;
	}

	// Creates a Button with the name of the light switch as it's text
	public Button getLightSwitch() {
		Button light = new Button(name);
		return light;
	}

	// Toggles the light on or off
	public void toggleStatus() {
		status = !status;
	}

	// Returns the state of the light
	public boolean getState() {
		return status;
	}

	// Returns the state of the light
	public String getStatus() {
		String statusString;
		if (status) {
			statusString= "Status: ON";
		} else {
			statusString= "Status: OFF";
		}
		return statusString;
	}

	// Returns the name of the light switch
	public String getName() {
		return name;
	}

}
