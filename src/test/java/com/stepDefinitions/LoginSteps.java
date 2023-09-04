package com.stepDefinitions;

import com.microsoft.playwright.Page;
import com.pages.Login;
import com.qa.managers.DriverFactory;
import com.qa.utilities.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {
    private final Login loginPage = new Login(DriverFactory.getPage());

    Xls_Reader dataAccess = new Xls_Reader("./src/test/resources/TestData/nopStationTestData.xlsx");
    String loginCredentials = "LoginInfo";
    @Given("Go to home page")
    public void goToHomePage() {

        loginPage.gotoHomePage();
      //  loginPage.popUPClick();

        loginPage.loginMenuClick();
    }

    @And("User input email and password in login page")
    public void userInputEmailAndPasswordInLoginPage() {
        String user_emailID = dataAccess.getCellData(loginCredentials, "EmailID", 2).trim();
        String user_Password = dataAccess.getCellData(loginCredentials, "Password", 2).trim();


        loginPage.usernameInput(user_emailID);
        loginPage.passwordInput(user_Password);
        loginPage.loginButtonClick();
    }

    @And("Click login button")
    public void clickLoginButton() {
        String _validationLoginMSG = loginPage.validationLoginPage();
        String exLoginMSG = "Log out";
        Assertions.assertEquals(_validationLoginMSG, exLoginMSG);
    }

    @Then("verify that user login successfully")
    public void UserLoginSuccessfully() {

    }

}


