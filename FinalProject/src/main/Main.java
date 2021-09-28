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
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue ov, Number value, Number new_value) {
				switch (new_value.intValue()) {
				case 0:
					clear();
					livingroom();
					break;
				case 1:
					clear();
					bedroom();
					break;
				case 2:
					clear();
					kitchen();
					break;
				case 3:
					clear();
					hallway();
					break;
				default:
					clear();	
					break;
				}
			}


		});

		Button btn = new Button("!");
		VBox vBox = new VBox(cb);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(15));
		vBox.setAlignment(Pos.TOP_LEFT);
		Scene livingRoom = new Scene(vBox, 1200, 600);
		stage.setScene(livingRoom);
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

	private void livingroom() {
		// TODO Auto-generated method stub
		System.out.println("livingroom selected");
	}

	private void bedroom() {
		// TODO Auto-generated method stub
		System.out.println("bedroom selected");
	}

	private void kitchen() {
		// TODO Auto-generated method stub
		System.out.println("kitchen selected");
	}

	private void hallway() {
		// TODO Auto-generated method stub
		System.out.println("hallway selected");
	}

	private void clear() {
		// TODO Auto-generated method stub

	}
}
