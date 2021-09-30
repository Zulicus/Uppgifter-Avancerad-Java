package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LightSwitch {
	private boolean status;
	private String name;

	LightSwitch(String name,boolean status) {
		this.status=status;
		this.name=name;
	}
	public Button getLightSwitch() {
		Button light= new Button(name);
		EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				status=!status;
			}
		};
		light.setOnAction(e);
		return  light;
	}
	public boolean getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}




}
