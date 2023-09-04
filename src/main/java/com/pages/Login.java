package com.pages;

import com.microsoft.playwright.Page;
import com.qa.managers.FileReader;

public class Login {
    private Page page;//input[@id='Username']
    private final String baseURL = FileReader.getInstance().getConfigReader().getBaseUrl();

    public Login(Page page) {
        this.page = page;
    }
    private String  loginLink="//a[contains(text(),'Log in')]";
    private String  username = "//input[@id='Username']";
    private String  password = "//input[@id ='Password']";
    private String  loginBtn = "//button[contains(text(),'Log in')]";
    private String  validation = "//*[text()='Log out']";

   // private  String popup = "//span[contains(text(),'x')]";


    public void gotoHomePage() {

        page.navigate(baseURL);

    }
    public void popUPClick() {

        page.click("//*[@id='news-letter-popup-modal']/div/span");
//        page.onDialog(dialog -> {
//            dialog.dismiss();
//        });
//        page.click(popup);
//        Page popup = page.waitForPopup(() -> {
//            page.click("//*[@id='news-letter-popup-modal']/div/span");
//        });
//        popup.close();

    }
    public void loginMenuClick(){
        page.click(loginLink);
    }
    public void usernameInput(String str)
    {
        page.fill(username,str);
    }
    public void passwordInput(String pass)
    {
        page.fill(password,pass);
    }
    public void loginButtonClick()
    {
        page.click(loginBtn);
    }
    public String validationLoginPage()
    {
        return page.textContent(validation);
    }
}
