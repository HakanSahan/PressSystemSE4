package be.springPressOrder.resources;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;



public class MyStepdefs {

    WebDriver driver;

    @Given("^I am on the page where I can add one Order$")
    public void i_am_on_the_page_where_I_can_introduce_a_new_person() throws Throwable{
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");

        //driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/order/new");
    }


    @When("^I enter (\\d+) in the amount field$")
    public void iEnterInTheAmountField(int arg0) {

    }

    @And("^I enter \"([^\"]*)\" in the juice field$")
    public void iEnterInTheJuiceField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^I enter (\\d+) in the client id field$")
    public void iEnterInTheClientIdField(int arg0) {

    }

    @And("^I press submit$")
    public void iPressSubmit() {

    }

    @Then("^I should see the following on the screen$")
    public void iShouldSeeTheFollowingOnTheScreen() {

    }

    @When("^I click the OrdersList link$")
    public void iClickTheOrdersListLink() {

    }

    @Then("^I should see a list cointaining \"([^\"]*)\"$")
    public void iShouldSeeAListCointaining(String arg0) throws Throwable {

    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() {
    }
}
