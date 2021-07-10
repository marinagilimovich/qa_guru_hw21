package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@DisplayName("Wikipedia Android Tests")
public class WikipediaTests extends BaseTest {
    String firstPageTitle = "The Free Encyclopedia …in over 300 languages";
    String secondPageTitle = "New ways to explore";
    String thirdPageTitle = "Reading lists with sync";
    String forthPageTitle = "Send anonymous data";

    void checkPageTitle(String title) {
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text(title));
    }

    void clickContinue() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
    }

    void clickGetStartedButton() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
    }

    @Test
    @DisplayName("Getting started test")
    void checkingGettingStartedPagesTest() {
        step("Check the first page", () -> {
            checkPageTitle(firstPageTitle);
            clickContinue();
        });

        step("Check the second page", () -> {
            checkPageTitle(secondPageTitle);
            clickContinue();
        });

        step("Check the third page", () -> {
            checkPageTitle(thirdPageTitle);
            clickContinue();
        });

        step("Check the forth page", () -> {
            checkPageTitle(forthPageTitle);
            clickGetStartedButton();
        });

        step("Check the Search page is open", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_container")).should(Condition.appear);
        });
    }
}
