package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LightSwitch {
	private boolean status;
	private String name;

	public LightSwitch(String name,boolean status) {
		this.status=status;
		this.name=name;
	}
	public Button getLightSwitch() {
		Button light= new Button(name);
		return  light;
	}
	public void toggleStatus() {
		status=!status;
	}
	public boolean getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}




}
