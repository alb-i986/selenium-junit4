package me.alb_i986.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Provides initialized {@link WebDriver} instances.
 */
public interface WebDriverProvider {

    /**
     * @return a non-null driver
     * @throws IllegalStateException if the driver to be returned is null
     */
    WebDriver getDriver() throws IllegalStateException;
}
