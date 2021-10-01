package main;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simulation.SimMain;
import simulation.SimRun;

public class Main extends Application {
	static SimMain simMain = new SimMain();
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	String status = "";

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// Starts the Simulation
		rooms = runSim();
		Stage secondStage = new Stage();
		simMain.start(secondStage);
		// UI setup
		stage.setTitle("Light Controller");
		final ToggleGroup group = new ToggleGroup();
		// The horizontal box for the rooms
		HBox selection = new HBox();
		selection.setPadding(new Insets(10));
		selection.setSpacing(5);
		// Adding in the buttons from the simulated home
		for (int i = 0; i < rooms.size(); i++) {
			ToggleButton button = rooms.get(i).getButton();
			group.getToggles().addAll(button);
			selection.getChildren().addAll(button);
		}
		// The vertical box for the light buttons
		VBox lights = new VBox();
		lights.setPadding(new Insets(10));
		lights.setSpacing(5);

		// Listens for a user to change or close a room
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle, final Toggle new_toggle) {
				// Clears the current light buttons
				clear(lights);
				if (new_toggle != null) {
					for (int i = 0; i < rooms.size(); i++) {
						// Checks for what room was pressed
						if (rooms.get(i).getName() == ((ToggleButton) new_toggle).getText()) {
							for (int j = 0; j < rooms.get(i).getLights().size(); j++) {
								// Adds in the light buttons for that room
								Button light = rooms.get(i).getLights().get(j).getLightSwitch();
								Label statusLabel = new Label(rooms.get(i).getLights().get(j).getStatus());
								Label timeToggled = new Label("");
								statusLabel.setStyle("-fx-padding: 3;" + "-fx-border-style: solid inside;");
								// Workaround variables
								final Integer innerI = i;
								final Integer innerJ = j;
								// Button Functionality
								light.setOnAction(event -> {
									// Toggles the lights on or off
									rooms.get(innerI).getLights().get(innerJ).toggleStatus();
									// Updates the labels to match the current status of the lights
									statusLabel.setText(rooms.get(innerI).getLights().get(innerJ).getStatus());
									// Creates a Timestamp for the user to se when the light was last toggled
									Calendar time = Calendar.getInstance();
									String hourString = StringUtilities.pad(2, ' ',
											time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
									String minuteString = StringUtilities.pad(2, '0', time.get(Calendar.MINUTE) + "");
									String secondString = StringUtilities.pad(2, '0', time.get(Calendar.SECOND) + "");
									String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
									timeToggled.setText(
											hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
									timeToggled.setStyle("-fx-padding: 3;" + "-fx-border-style: solid inside;");
								});
								HBox row = new HBox();
								lights.setStyle("-fx-padding: 3;");
								row.getChildren().addAll(light, statusLabel, timeToggled);
								lights.getChildren().addAll(row);
							}
						}
					}
				}
			}
		});
		// Vertical box for all content to be in
		VBox root = new VBox();
		root.getChildren().addAll(selection, lights);
		root.setSpacing(10);
		root.setMinSize(600, 400);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// Runs the simulated background
	private static ArrayList<Room> runSim() {
		return SimRun.runSim();
	}

	// Method that clears away all light buttons
	private void clear(VBox lights) {
		lights.getChildren().clear();
	}

}


//Class that helps with the building of time stamps
class StringUtilities {
	public static String pad(int fieldWidth, char padChar, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}
}
