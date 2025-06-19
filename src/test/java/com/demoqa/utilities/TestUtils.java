package com.demoqa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demoqa.base.Base;
import com.google.common.io.Files;

public class TestUtils extends Base {
	public static void screenshot() throws IOException {
		SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String fileName = currDate.format(new Date());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("src/test/resources/screenshots/" + fileName + ".png"));
	}
}
