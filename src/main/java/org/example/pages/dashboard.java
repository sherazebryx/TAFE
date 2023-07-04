package org.example.pages;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class dashboard {

    private WebDriver driver;

    // Locators
    private By coursesearchfld = By.id("homePageSearch");
    private By searchbtn = By.xpath("//button[@type='button' and @aria-label='Submit search']");
    private By viewcourse = By.xpath("//*[ contains (text(),'View course')]");
    private By filterdropdown = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[3]/div[1]/div[2]/button");
    private By selectoncampus = By.id("on-campus");

    private By filter = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/button[1]");



    // Constructor
    public dashboard(WebDriver driver) {

        this.driver = driver;
    }

    // Methods/actions

    public void entercoursename(String course) {
        WebElement searchfield = driver.findElement(coursesearchfld);
        searchfield.click();
        searchfield.sendKeys(course);
    }

    public void clicksearchbutton() {
        WebElement searchButton = driver.findElement(searchbtn);
        searchButton.click();
    }

    public void applyfilterdropdownbutton() {
        WebElement filterdropdownbutton = driver.findElement(filterdropdown);
        filterdropdownbutton.click();

    }
    public void clickcheckboxoncampus() {
        WebElement oncampuscheckbox = driver.findElement(selectoncampus);
        oncampuscheckbox.click();

    }


    public boolean checkviewcoursebutton(){

        return driver.findElement(viewcourse).isDisplayed();
    }

    public boolean checkfilter(){
        return driver.findElement(filter).isDisplayed();
    }
}
