package main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simulation.SimMain;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		runSim();
		// UI setup
		stage.setTitle("Light Controller");
		// Choice box for room selection
		final ChoiceBox<String> cb = new ChoiceBox<String>(
				FXCollections.observableArrayList("Livingroom", "Bedroom", "Kitchen", "Hallway"));
		
		Button btn = new Button("!");
		VBox choiceVBox = new VBox(cb);

		choiceVBox.setPadding(new Insets(50));
		choiceVBox.setAlignment(Pos.TOP_LEFT);
		Scene startScene = new Scene(choiceVBox, 1200, 600);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue ov, Number value, Number new_value) {
				switch (new_value.intValue()) {
				case 0:
					clear();
					livingroom(stage);
					break;
				case 1:
					clear();
					bedroom(stage);
					break;
				case 2:
					clear();
					kitchen(stage);
					break;
				case 3:
					clear();
					hallway(stage);
					break;
				default:
					clear();	
					break;
				}
			}


		});

		stage.setScene(startScene);
		stage.show();

		// Button Functionality
		EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

			}
		};
		btn.setOnAction(e);
	}

	private static void runSim() throws Exception {
		SimMain simMain = new SimMain();
		Stage secondStage = new Stage();
		simMain.start(secondStage);
	}

	private void livingroom(Stage stage) {


		
		
		
		System.out.println("livingroom selected");
	}

	private void bedroom(Stage stage) {
		stage.close();
		System.out.println("bedroom selected");
	}

	private void kitchen(Stage stage) {
		// TODO Auto-generated method stub
		System.out.println("kitchen selected");
	}

	private void hallway(Stage stage) {
		// TODO Auto-generated method stub
		System.out.println("hallway selected");
	}

	private void clear() {
		// TODO Auto-generated method stub

	}
}
