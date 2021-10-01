package simulation;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import main.Room;
import main.Main;

public class SimMain extends Application {
	public static ArrayList<Room> rooms;

	// Creates a second window that shows the lights of the house
	@Override
	public void start(Stage stage) throws Exception {
		rooms = Main.rooms;
		// UI setup
		stage.setTitle("Simulation");
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
								Label nameLabel = new Label(rooms.get(i).getLights().get(j).getName());
								nameLabel.setStyle("-fx-padding: 3;" + "-fx-border-style: solid inside;");
								Circle lightIndicator = new Circle(10, 10, 10);
								/*SimLights simLight = new SimLights(lightIndicator,i,j);
								simLight.run();*/
								if (rooms.get(i).getLights().get(j).getState()) {
									lightIndicator.setFill(javafx.scene.paint.Color.GREEN);
								} else {
									lightIndicator.setFill(javafx.scene.paint.Color.RED);
								}
								lightIndicator.setStyle("-fx-padding: 3;");
								HBox row = new HBox();
								lights.setStyle("-fx-padding: 3;");
								row.getChildren().addAll(nameLabel, lightIndicator);
								lights.getChildren().addAll(row);
							}
						}
					}
				}
			}
		});
		lights.setPadding(new Insets(10));
		lights.setSpacing(5);
		VBox root = new VBox();
		root.getChildren().addAll(selection, lights);
		root.setSpacing(10);
		Scene scene = new Scene(root, 300, 600);
		stage.setScene(scene);
		stage.show();

	}

	private void clear(VBox lights) {
		lights.getChildren().clear();
	}

}
