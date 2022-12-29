package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Book Flight Functionality")
@Feature("Verify Book Flight Functionality")
public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    @Description("Test Case #1, verify Registration Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, verify Registration Feature")
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    @Description("Test Case #2, verify Registration Confirmation Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, verify Registration Confirmation Feature")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    @Description("Test Case #3, verify Flight Details Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, verify Flight Details Feature")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    @Description("Test Case #4, verify Find Flight Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, verify Find Flight Feature")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    @Description("Test Case #5, verify Flight Confirmation Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #5, verify Flight Confirmation Feature")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
