package simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimMain extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// UI setup
		arg0.setTitle("Lights");
		StackPane stackPane = new StackPane();
		Button btn = new Button("test");
		stackPane.getChildren().add(btn);
		Scene livingRoom = new Scene(stackPane, 1200, 600);
		arg0.setScene(livingRoom);
		arg0.show();
	}



}
