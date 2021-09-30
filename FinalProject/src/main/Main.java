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
	ArrayList<Room> rooms = new ArrayList<Room>();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		rooms = runSim();
		// UI setup
		stage.setTitle("Light Controller");
		// Choice box for room selection

		final ToggleGroup group = new ToggleGroup();
		HBox selection = new HBox();
		selection.setPadding(new Insets(10));
		selection.setSpacing(5);
		for (int i = 0; i < rooms.size(); i++) {
			ToggleButton button = rooms.get(i).getButton();
			group.getToggles().addAll(button);
			selection.getChildren().addAll(button);
		}
		VBox lights = new VBox();
		lights.setPadding(new Insets(10));
		lights.setSpacing(5);
		
		// Button Functionality
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(event);
			}
		};

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle, final Toggle new_toggle) {
				clear(lights);
				if (new_toggle != null) {
					for (int i = 0; i < rooms.size(); i++) {
						if (rooms.get(i).getName() == ((ToggleButton) new_toggle).getText()) {
							for(int j=0;j<rooms.get(i).getLights().size();j++) {
								Button light = rooms.get(i).getLights().get(j).getLightSwitch();
								light.setOnAction(event);
								lights.getChildren().addAll(light);
							}
						}
					}
				}
			}
		});

		VBox root = new VBox();
		root.getChildren().addAll(selection, lights);
		root.setSpacing(10);
		root.setMinSize(600, 400);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene testScene = new Scene(root);

		stage.setScene(testScene);
		stage.show();

		

	}

	private static ArrayList<Room> runSim() throws Exception {
		SimMain simMain = new SimMain();
		Stage secondStage = new Stage();
		simMain.start(secondStage);
		return simMain.getRooms();
	}

	private void clear(VBox lights) {
		lights.getChildren().clear();
		;
	}
}
