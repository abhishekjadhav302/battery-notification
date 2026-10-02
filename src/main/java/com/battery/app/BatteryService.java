package com.battery.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatteryService {

	public static int getBatteryPercentage() throws Exception {

		Process process = Runtime.getRuntime().exec(
				"\"powershell.exe -Command \\\"Get-CimInstance Win32_Battery | Select-Object -ExpandProperty EstimatedChargeRemaining\\\"\"");

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String batteryLevel = reader.readLine();

		reader.close();

		if (batteryLevel == null || batteryLevel.isBlank()) {
			throw new IllegalStateException("Unable to read battery percentage.");
		}

		return Integer.parseInt(batteryLevel.trim());
	}
}
