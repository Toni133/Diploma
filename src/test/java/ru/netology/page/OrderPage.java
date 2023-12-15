package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderPage {
    private SelenideElement heading = $(".heading").shouldBe(Condition.text("Путешествие дня"));
    private SelenideElement payButton = $$("button").findBy(Condition.text("Купить"));
    private SelenideElement creditButton = $$("button").findBy(Condition.text("Купить в кредит"));

    public void startPage() {
        heading.shouldBe(Condition.visible);
    }

    public PaymentPage pay() {
        payButton.click();
        return new PaymentPage();
    }

    public CreditPage payByCredit() {
        creditButton.click();
        return new CreditPage();
    }

}
