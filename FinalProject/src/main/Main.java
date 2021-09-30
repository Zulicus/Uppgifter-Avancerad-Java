package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import simulation.SimMain;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ArrayList<Room>rooms=new ArrayList<Room>();
		rooms=runSim();
		// UI setup
		stage.setTitle("Light Controller");
		// Choice box for room selection

		ToggleButton room1 = new ToggleButton("Livingroom");
		ToggleButton room2 = new ToggleButton("Bedroom");
		ToggleButton room3 = new ToggleButton("Kitchen");
		ToggleButton room4 = new ToggleButton("Hallway");
		final ToggleGroup group = new ToggleGroup();
		for(int i=0;i<rooms.size();i++) {
			group.getToggles().addAll(rooms.get(i).getButton());
		}
		VBox lights = new VBox();
		lights.setPadding(new Insets(10));
		lights.setSpacing(5);
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle, final Toggle new_toggle) {
				String toggleBtn = "";
				if(new_toggle==null) {
					toggleBtn = "";
				}else {
					toggleBtn = ((ToggleButton) new_toggle).getText();
				}
				switch (toggleBtn) {
				case "Livingroom":
					livingroom(lights);
					break;
				case "Bedroom":
					bedroom(lights);
					break;
				case "Kitchen":
					kitchen(lights);
					break;
				case "Hallway":
					hallway(lights);
					break;
				default:
					clear(lights);
					break;
				}
			}
		});
		HBox selection = new HBox();
		selection.setPadding(new Insets(10));
		selection.setSpacing(5);
		selection.getChildren().addAll(room1, room2, room3, room4);

		VBox root = new VBox();
		root.getChildren().addAll(selection, lights);
		root.setSpacing(10);
		root.setMinSize(600, 400);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene testScene = new Scene(root);

		stage.setScene(testScene);
		stage.show();

		// Button Functionality
		EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

			}
		};
		// btn.setOnAction(e);
	}

	private static ArrayList<Room> runSim() throws Exception {
		SimMain simMain = new SimMain();
		Stage secondStage = new Stage();
		simMain.start(secondStage);
		return simMain.getRooms();
	}

	private void livingroom(VBox lights) {
		clear(lights);
		Button light1 = new Button("Ceiling Light (TV)");
		Button light2 = new Button("ceiling Light (Dining)");
		Button light3 = new Button("Window Light 1");
		Button light4 = new Button("Window Light 2");
		Button light5 = new Button("Window Light 3");
		Button light6 = new Button("Window Light 4");
		Button light7 = new Button("Floor Light 1");
		Button light8 = new Button("Floor Light 2");
		lights.getChildren().addAll(light1, light2, light3, light4, light5, light6, light7, light8);
	}

	private void bedroom(VBox lights) {
		clear(lights);
		Button light1 = new Button("Ceiling Light 1");
		Button light2 = new Button("Ceiling Light 2");
		Button light3 = new Button("Window Light");
		Button light4 = new Button("Night Light");
		lights.getChildren().addAll(light1, light2, light3, light4);
	}

	private void kitchen(VBox lights) {
		clear(lights);
		Button light1 = new Button("Ceiling Light");
		Button light2 = new Button("Stove Light");
		Button light3 = new Button("Workbench Light");
		Button light4 = new Button("Cupboard Light");
		Button light5 = new Button("Window Light 1");
		Button light6 = new Button("Window Light 2");
		lights.getChildren().addAll(light1, light2, light3, light4, light5, light6);
	}

	private void hallway(VBox lights) {
		clear(lights);
		Button light1 = new Button("Ceiling Light 1");
		Button light2 = new Button("Ceiling Light 2");
		Button light3 = new Button("Wall Light");
		lights.getChildren().addAll(light1, light2, light3);
	}

	private void clear(VBox lights) {
		lights.getChildren().clear();
		;
	}
}
