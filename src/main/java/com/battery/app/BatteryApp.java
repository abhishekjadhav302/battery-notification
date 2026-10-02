package com.battery.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BatteryApp extends Application {

	@Override
	public void start(Stage stage) {

		// Start battery monitoring
		BatteryMonitor.startMonitoring();

		// Small main application window
		Label label = new Label("🔋 Battery Guardian is running...");

		Scene scene = new Scene(label, 400, 200);

		stage.setTitle("Battery Guardian");

		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}