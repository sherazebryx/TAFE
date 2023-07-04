package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.example.pages.dashboard;
import java.util.concurrent.TimeUnit;

public class dashboardstepdef {

    private WebDriver driver;
    private dashboard Dashboard;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the TAFE dashboard page")
    public void i_am_on_the_TAFE_dashboard_page(){
        driver.get("https://www.tafensw.edu.au/");
        Dashboard = new dashboard(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Given("Search for the course using search box")
    public void search_for_the_course_using_search_box() {
        Dashboard.entercoursename("advanced barista skills");
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button(){
        Dashboard.clicksearchbutton();
    }
    @Then("verify course appears")
    public void verify_course_appears(){
         Assert.assertEquals(Dashboard.checkviewcoursebutton(), true);
    }
    @When("apply filter on campus")
    public void apply_filter_on_campus() {
        Dashboard.applyfilterdropdownbutton();
        Dashboard.clickcheckboxoncampus();
    }
    @Then("verify filter is applied")
    public void verify_filter_is_applied() {
        Assert.assertEquals(Dashboard.checkfilter(), true);
    }
 }

