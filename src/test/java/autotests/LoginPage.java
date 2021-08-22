package autotests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class  LoginPage extends TestBase{
    protected String Site = "https://tt-develop.quality-lab.ru";
    protected String SiteLogin = "https://tt-develop.quality-lab.ru/login";
    protected String SiteEdit = "https://tt-develop.quality-lab.ru/report/group/edit";
    protected String Login = "Авто Пользователь";
    protected String Email = "1241242@m.r";
    protected String Password = "12345678";
    protected String FoundText = "Invalid credentials.";

    @FindBy (xpath = "//input[@name = '_username']")
    WebElement XpathUser;

    @FindBy (xpath = "//input[@id = 'password']")
    WebElement XpathPass;

    @FindBy (xpath = "//input[@id = '_submit']")
    WebElement XpathButton;

    @FindBy (xpath = "//div [@class = 'm-stack__item m-topbar__nav-wrapper']")
    WebElement XpathAvatar;

    @FindBy (xpath = "//span [@class = 'm-card-user__name m--font-weight-500']")
    WebElement XpathLoginName;

    @FindBy (xpath = "//span[@class='m-card-user__email m--font-weight-300 m-link']")
    WebElement XpathEmail;

}