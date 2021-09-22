package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// UI setup
		stage.setTitle("Train Race");
		StackPane stackPane = new StackPane();
		Button btn = new Button("Stop!");
		stackPane.getChildren().add(btn);
		Scene scene = new Scene(stackPane, 200, 200);
		stage.setScene(scene);
		stage.show();
		// Main Code
		Train train = new Train("tågett", 900);
		Train train2 = new Train("tågtvå");
		Train train3 = new Train("tågtre", 769);
		train.start();
		train2.start();
		train3.start();
		// Button Functionality
		EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				train.interrupt();
				train2.interrupt();
				train3.interrupt();
				System.out.println("------Stop!-------");
			}
		};
		btn.setOnAction(e);
	}

}
