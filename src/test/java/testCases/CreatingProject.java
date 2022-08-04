package testCases;

import com.base.TestBase;
import com.base.TestBaseTwo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.base.TestBaseTwo.*;
import static com.base.TestBaseTwo.portNumber;

public class CreatingProject extends TestBase {

    @Test(priority =1)
     public void setup() throws Exception {
       // getWebdriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        initialization();
        TestBaseTwo base=new TestBaseTwo();
        getelementsPage().waitForElement(elementsPage.manageProjectsTab);
        getelementsPage().manageProjectsTab.click();
        getelementsPage().waitForElement(elementsPage.newProjectTitleInput);
        getelementsPage().newProjectTitleInput.sendKeys("Test@2");
        Thread.sleep(5000);
        getelementsPage().makeNewProjectButton.click();
        Thread.sleep(6000);
        getelementsPage().waitForElement(elementsPage.openProject);
        getelementsPage().clickWebElement(elementsPage.openProject);
        getelementsPage().clickWebElement(elementsPage.openProject);
        Thread.sleep(5000);
        base.subInitialization();
        Thread.sleep(5000);
        String portNumber1 = base.portNumber;
        System.out.println(portNumber1);
        getWebdriver().navigate().to(url1+portNumber1);
        System.out.println("child browser Launched successfully "+url1+portNumber1);
        getelementsPage().manageProjectsTab.click();
        getelementsPage().importInputDataTab.click();
        getelementsPage().uploadFile.sendKeys("C:\\Users\\NareshRagula\\OneDrive - Motivity Labs\\Desktop\\Demo_FVS_Input.xlsx");
        getelementsPage().waitForElement(elementsPage.installNewDBButton);
        getelementsPage().installNewDBButton.click();
        getelementsPage().waitForElement(elementsPage.verifyUploadedData);
        getelementsPage().verifyUploadedData.isDisplayed();
        getelementsPage().simulateTab.click();
        getelementsPage().runTitleInputButton.clear();
        getelementsPage().runTitleInputButton.sendKeys("Test@2");
        getelementsPage().saveButton.click();
        getelementsPage().standsTab.click();
        getelementsPage().allStandsOption.click();
        getelementsPage().allRadioButton.click();
        getelementsPage().addStandsSelectedGroups.click();
        getelementsPage().waitForElement(elementsPage.timeTab);
        getelementsPage().timeTab.click();
        getelementsPage().startYearInput.clear();
        getelementsPage().startYearInput.sendKeys("2021");
        getelementsPage().endYearInput.clear();
        getelementsPage().endYearInput.sendKeys("2121");
        getelementsPage().intervalInput.clear();
        getelementsPage().intervalInput.sendKeys("5");
        getelementsPage().componentsTab.click();
        getelementsPage().modifiersTab.click();
        getelementsPage().dropDownsCategory(elementsPage.categoriesDropdown);
        getelementsPage().dropDownsComp(elementsPage.componentsDropdown);
        getelementsPage().waitForElement(elementsPage.fiveinch);
        getelementsPage().fiveinch.clear();
        getelementsPage().fiveinch.sendKeys("0.25");
        getelementsPage().tenInch.clear();
        getelementsPage().tenInch.sendKeys("0.25");
        getelementsPage().fifteenInch.clear();
        getelementsPage().fifteenInch.sendKeys("0.25");
        getelementsPage().twentyInch.clear();
        getelementsPage().twentyInch.sendKeys("0.25");
        getelementsPage().twentyFiveInch.clear();
        getelementsPage().twentyFiveInch.sendKeys("0.25");
        getelementsPage().thirtyInch.clear();
        getelementsPage().thirtyInch.sendKeys("0.25");
        getelementsPage().thirtyFive.clear();
        getelementsPage().thirtyFive.sendKeys("0.25");
        getelementsPage().fourtyInch.clear();
        getelementsPage().fourtyInch.sendKeys("0.25");
        getelementsPage().waitForElement(elementsPage.saveInRunButton);
        getelementsPage().saveInRunButton.click();
        getelementsPage().selectOutputTab.click();
        getelementsPage().treeListCheckBox.click();
        getelementsPage().autoCarbonCheckBox.click();
        getelementsPage().autoDelOTabCheckBox.click();
        getelementsPage().RunTab.click();
        getelementsPage().saveAndRunButton.click();
        Thread.sleep(50000);
        getelementsPage().waitForElement(elementsPage.graph);
       getelementsPage().fluentWait(elementsPage.graph);
        if(getelementsPage().graph.isDisplayed()){
            getelementsPage().log("Executed TestCases Successfully");
            }else {
           Assert.fail("Increase the load time");
        }
    }
   @Test(priority = 2)
   public void closeBrowser(){
        getWebdriver().quit();
   }

}


