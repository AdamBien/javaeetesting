package com.airhacks;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author airhacks.com
 */
@Location("http://localhost:8080/pageobject/faces/index.xhtml")
public class IndexPage {

    @FindBy
    WebElement input;

    @FindBy
    WebElement output;

    @FindBy
    WebElement ok;

    public String copy(String inputText) {
        input.sendKeys(inputText);
        Graphene.guardHttp(ok).click();
        return output.getAttribute("value");
    }

}
