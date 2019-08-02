package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("I am loggined")
    public void iAmLoggined() {
        open("https://new.tender.pro/");
    }

    @And("I check title page {string}")
    public void iCheckTitlePage(String arg0) {
        $("a.iac--btn").shouldBe(Condition.visible).shouldHave(text(arg0));
    }
}
