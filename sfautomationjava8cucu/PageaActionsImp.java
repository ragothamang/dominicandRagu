package com.sf.automation.uiServices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageaActionsImp implements PageActions {
	public WebDriver driver;
	public WebDriverWait wait;

	@Override
	public WebElement locateWebElement(String locator, String locatorValue) {
		// TODO Auto-generated method stub

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locatorValue)); 
			case "class": return driver.findElement(By.className(locatorValue));
			case "name": return driver.findElement(By.name(locatorValue));
			case "link":return driver.findElement(By.linkText(locatorValue));
			case "partialLink": return driver.findElement(By.partialLinkText(locatorValue));
			case "xpath": return driver.findElement(By.xpath(locatorValue));
			case "css_Selector": return driver.findElement(By.cssSelector(locatorValue));
			default:
				break;
			}

		}catch (Exception e) {
			// TODO: handle exception			
			System.out.println("Element not located >> "+e.getMessage());
		}
		return null;
	}

	@Override
	public void click(WebElement element) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not clicked >> "+e.getMessage());
		}
	}

	@Override
	public void type(WebElement element, CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		try {
			element.clear();
			element.sendKeys(keysToSend);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> "+e.getMessage());
		}
	}
	
	public void typeAndAppend(WebElement element, CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		try {			
			element.sendKeys(keysToSend);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> "+e.getMessage());
		}
	}


}
