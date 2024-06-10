import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;
import static com.codeborne.selenide.files.DownloadActions.click;
import static com.codeborne.selenide.Selectors.withText;
@ExtendWith({SoftAssertsExtension.class})
//файл загружен в GitHub
public class rzdSearch {
    @Test
    void MoscowSochi(){
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://www.rzd.ru/");
        $("#direction-from").setValue("Москва Каз");
        $(withText("Казанский вокзал")).shouldBe(exist).click();
        $("[wfd-id=id27]").setValue("Сочи Кра");
        $(withText("Сочи")).shouldBe(exist).click();
        $("#datepicker-from").click();
        $("#datepicker-from").setValue("19.08.2024");
        $("#rzd-datepicker-div > div.rzd-datepicker-group.rzd-datepicker-group-first > table > tbody > tr:nth-child(5) > td:nth-child(1) > a").click();
        $("#datepicker-to").click();
        $("#datepicker-to").setValue("30.08.2024");
        $(".rzd-button-wrapper.rzd-cell.rzd-cell-15").click();
        sleep(20000);
        $("body > rzd-app > main > div > rzd-search-results > div > div > rzd-base-result-theme > div > div > div.results-cards > rzd-search-results-card-list > div > rzd-search-results-card-railway-flat-card.E2E_TEST_SEARCH_RESULTS_CARD_RAILWAY_1.ng-star-inserted").shouldBe(exist);
        $("body > rzd-app > main > div > rzd-search-results > div > div > rzd-base-result-theme > div > div > div.results-cards > rzd-search-results-card-list > div > rzd-search-results-card-railway-flat-card.E2E_TEST_SEARCH_RESULTS_CARD_RAILWAY_1.ng-star-inserted").click();
        $(byXpath("/html/body/rzd-app/main/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[1]/label/div[2]/rzd-railway-service-class-selection-item/div")).click();
        $("body > rzd-app > main > div > rzd-trip-component > rzd-booking-rail-container > div > div.booking-body > rzd-railway-service-class-selection-list > rzd-class-selection-footer > div.class-selection-footer__panel--sticky.class-selection-footer__panel.d-block > div > ui-kit-button > button").click();
        $(withText("Вагон 02")).should(exist);
        sleep(2000);
    }
}
