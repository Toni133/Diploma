package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private final SelenideElement heading = $$(".heading").findBy(Condition.text("Оплата по карте"));
    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $("[placeholder='08']");
    private final SelenideElement year = $("[placeholder='22']");
    private final SelenideElement holder = $$(".input").find(exactText("Владелец")).$(".input__control");
    private final SelenideElement cvc = $("[placeholder='999']");
    private final SelenideElement button = $$("button").findBy(Condition.text("Продолжить"));

    public void fillCardNumber(String cardInput) {
        cardNumber.setValue(cardInput);
    }

    public void fillMonth(String monthInput) {
        month.setValue(monthInput);
    }

    public void fillYear(String yearInput) {
        year.setValue(yearInput);
    }

    public void fillHolder(String holderInput) {
        holder.setValue(holderInput);
    }

    public void fillCVC(String cvcInput) {
        cvc.setValue(cvcInput);
    }

    public void continueClick() {
        button.click();
    }

    public void notificationIfSuccess() {
        $(".notification_status_ok").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(exactText("Успешно\n" + "Операция одобрена Банком."));
    }

    public void notificationIfFailure() {
        $(".notification_status_error").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(exactText("Ошибка\n" + "Ошибка! Банк отказал в проведении операции."));
    }

    public void messageIfIncorrect() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверный формат"));
    }

    public void messageIfNull() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Поле обязательно для заполнения"));
    }

    public void messageIfCardNumberIsIncorrect() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверно указан номер карты"));
    }

    public void messageIfPeriodIsIncorrect() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверно указан срок действия карты"));
    }

    public void messageIfExpired() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Истёк срок действия карты"));
    }

    public void messageIfHolderISLong() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Значение не должно превышать 20 символов"));
    }

    public String getFieldValue(int index) {
        return fields.get(index).getAttribute("value");
    }
}
