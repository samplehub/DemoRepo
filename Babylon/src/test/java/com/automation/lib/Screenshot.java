package com.automation.lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takePicture(WebDriver driver , String name)
	{
		
		try {
		   TakesScreenshot ts =(TakesScreenshot)driver;
	       File src   = ts.getScreenshotAs(OutputType.FILE);
	    
			FileUtils.copyFile(src, new File("./Screenshots/"+ name + ".png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}