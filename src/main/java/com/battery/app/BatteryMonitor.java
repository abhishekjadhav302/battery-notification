package com.battery.app;

import javafx.application.Platform;

public class BatteryMonitor {

	private static boolean notificationShown = false;

	public static void startMonitoring() {

		Thread monitorThread = new Thread(() -> {

			System.out.println("Battery Monitor Started...");

			while (true) {

				try {

					int battery = BatteryService.getBatteryPercentage();

					System.out.println("Battery: " + battery + "%");

					// LOW BATTERY notification

					if (battery <= 20 && !notificationShown) {

						Platform.runLater(() -> {

							BatteryNotification.show(battery);

						});

						notificationShown = true;
					}

					// RESET - when battery is greater than 20%

					if (battery > 20) {

						notificationShown = false;
					}

					// Check every 30 seconds
					Thread.sleep(30000);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		});

		// Don't prevent JavaFX from shutting down
		monitorThread.setDaemon(true);

		monitorThread.start();
	}
}