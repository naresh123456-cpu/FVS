package pages;

import com.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class ElementsPage extends TestBase {
    @FindBy(xpath = "//a[.='Manage Projects']")
    public WebElement manageProjectsTab;
    @FindBy(xpath = "//input[@id='PrjNewTitle']")
    public WebElement newProjectTitleInput;
    @FindBy(xpath = "//button[@id='PrjNew']")
    public WebElement makeNewProjectButton;
    @FindBy(xpath = "//button[@id='searchNext']")
    public WebElement findButton;
    @FindBy(xpath = "//button[.='Open selected project']")
    public WebElement openProject;
    @FindBy(xpath = "//a[.='Import input data']")
    public WebElement importInputDataTab;
    @FindBy(xpath = "//label[@id='uploadNewDB-label']/parent::div/div/label/span/input")
    public WebElement uploadFile;
    @FindBy(xpath = "//button[@id='installNewDB']")
    public WebElement installNewDBButton;
    @FindBy(xpath = "//b[normalize-space()='Uploaded data:']")
    public WebElement verifyUploadedData;
    @FindBy(xpath = "//a[.='Simulate']")
    public WebElement simulateTab;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement runTitleInputButton;
    @FindBy(xpath = "//button[@id='saveRun']")
    public WebElement saveButton;
    @FindBy(xpath = "//a[.='Stands']")
    public WebElement standsTab;
    @FindBy(xpath = "//option[@value='All_Stands']")
    public WebElement allStandsOption;
    @FindBy(xpath = "//input[@value='All']")
    public WebElement allRadioButton;
    @FindBy(xpath = "//button[@id='inAddGrp']")
    public WebElement addStandsSelectedGroups;
    @FindBy(xpath = "//a[.='Time']")
    public WebElement timeTab;
    @FindBy(xpath = "//input[@id='startyr']")
    public WebElement startYearInput;
    @FindBy(xpath = "//input[@id='endyr']")
    public WebElement endYearInput;
    @FindBy(xpath = "//input[@id='cyclelen']")
    public WebElement intervalInput;
    @FindBy(xpath = "//a[.='Components']")
    public WebElement componentsTab;
    @FindBy(xpath = "//a[.='Modifiers']")
    public WebElement modifiersTab;
    @FindBy(xpath = "//select[@id='addModCats']")
    public WebElement categoriesDropdown;
    @FindBy(xpath = "//select[@id='addModCmps']")
    public WebElement componentsDropdown;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 5-inch')]//following-sibling::input")
    public WebElement fiveinch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 10-inch')]//following-sibling::input")
    public WebElement tenInch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 15-inch')]//following-sibling::input")
    public WebElement fifteenInch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 20-inch')]//following-sibling::input")
    public WebElement twentyInch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 25-inch')]//following-sibling::input")
    public WebElement twentyFiveInch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 30-inch')]//following-sibling::input")
    public WebElement thirtyInch;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for a 35-inch')]//following-sibling::input")
    public WebElement thirtyFive;
    @FindBy(xpath = "//label[contains(.,'Volume defect proportion for 40 inch and larger trees')]//following-sibling::input")
    public WebElement fourtyInch;
    @FindBy(xpath = "//button[@id='cmdSaveInRun']")
    public WebElement saveInRunButton;
    @FindBy(xpath = "//a[.='Select Outputs']")
    public WebElement selectOutputTab;
    @FindBy(xpath = "//input[@value='autoTreelists']")
    public WebElement treeListCheckBox;
    @FindBy(xpath = "//input[@value='autoCarbon']")
    public WebElement autoCarbonCheckBox;
    @FindBy(xpath = "//input[@value='autoDelOTab']")
    public WebElement autoDelOTabCheckBox;
    @FindBy(xpath = "//b[normalize-space()='*Run*']")
    public WebElement RunTab;
    @FindBy(xpath = "//button[@id='saveandrun']")
    public WebElement saveAndRunButton;
    @FindBy(xpath = "//*[@id='runPlot']/img")
    public WebElement graph;


    public ElementsPage() {

        PageFactory.initElements(getWebdriver(), this);
    }
    public boolean isElementPresent_locator(By by) {
        try {
            getWebdriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isElementPresent_webelement(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean clickWebElement(WebElement element) throws Exception {
        try {
            boolean elementIsClickable = element.isEnabled();
            if (elementIsClickable) {
                element.click();
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw e;
        }
    }
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void log(String message) {
        Reporter.log(message, true);
    }
    public void dropDownsCategory(WebElement element){
        Select option=new Select(element);
        option.selectByVisibleText("Volume Modifiers");
    }
    public void dropDownsComp(WebElement element){
        Select option=new Select(element);
        option.selectByVisibleText("Add Volume Defect");
    }
    public void getScreenShot() throws IOException {
        TakesScreenshot ts= (TakesScreenshot)getWebdriver();
        File filesource=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(filesource,new File("C:\\Users\\NareshRagula\\IdeaProjects\\FVSOnline\\ScreenShots1\\"+timestamp()+".jpeg"));
    }
    public static String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    public void fluentWait(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(40));
        wait.pollingEvery(Duration.ofSeconds(300));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void action(WebElement element){
        Actions act= new Actions(getWebdriver());
        act.doubleClick(element).perform();
}
  public void dropdowns(WebElement element){
         Select option= new Select(element);
         option.selectByVisibleText("");
  }
}
