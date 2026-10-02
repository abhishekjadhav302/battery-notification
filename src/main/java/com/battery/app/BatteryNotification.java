package com.battery.app;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BatteryNotification {

	public static void show(int battery) {

		Stage stage = new Stage();

		// Remove normal Windows title bar
		stage.initStyle(StageStyle.TRANSPARENT);

		// Keep notification above other windows
		stage.setAlwaysOnTop(true);

		// Battery icon
		Label icon = new Label("🔋");

		icon.setStyle("""
				-fx-font-size: 45px;
				""");

		// Battery percentage
		Label percentage = new Label(battery + "%");

		percentage.setStyle("""
				-fx-font-size: 32px;
				-fx-font-weight: bold;
				-fx-text-fill: white;
				""");

		// Title
		Label title = new Label("Battery is Low");

		title.setStyle("""
				-fx-font-size: 20px;
				-fx-font-weight: bold;
				-fx-text-fill: white;
				""");

		// Message
		Label message = new Label("Please connect your charger.");

		message.setStyle("""
				-fx-font-size: 14px;
				-fx-text-fill: #F5F5F5;
				""");

		// Dismiss button
		Button dismissButton = new Button("Dismiss");

		dismissButton.setStyle("""
				-fx-background-color: white;
				-fx-text-fill: #C76D00;
				-fx-font-weight: bold;
				-fx-background-radius: 8px;
				-fx-padding: 8px 25px;
				-fx-cursor: hand;
				""");

		dismissButton.setOnAction(event -> stage.close());

		// Main layout
		VBox layout = new VBox(8, icon, percentage, title, message, dismissButton);

		layout.setAlignment(Pos.CENTER);

		layout.setStyle("""
				-fx-background-color:
				    linear-gradient(
				        to bottom right,
				        #FF9B25,
				        #C76D00
				    );

				-fx-background-radius: 18px;

				-fx-padding: 25px;

				-fx-effect:
				    dropshadow(
				        gaussian,
				        rgba(0,0,0,0.35),
				        20,
				        0.3,
				        0,
				        5
				    );
				""");

		// Create scene
		Scene scene = new Scene(layout, 330, 330);

		scene.setFill(Color.TRANSPARENT);

		stage.setScene(scene);

		// --------------------------------
		// Position bottom-right of screen
		// --------------------------------

		var screenBounds = Screen.getPrimary().getVisualBounds();

		double x = screenBounds.getMaxX() - 330 - 25;

		double y = screenBounds.getMaxY() - 330 - 25;

		stage.setX(x);
		stage.setY(y);

		// Show notification
		stage.show();
	}
}