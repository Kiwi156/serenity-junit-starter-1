package formy.acceptancetests;

import formy.actions.FillingInWebFormActions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
@ExtendWith(SerenityJUnit5Extension.class)
public class CompleteWebFormTests extends UIInteractions {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    FillingInWebFormActions fillingInWebForm;

    @Test
    public void shouldEnterDetailsAndSubmitForm(){


        fillingInWebForm.forANewCustomer("Jo",
                "Grant",
                "CEO",
                "College",
                "Female",
                13);

        waitForTextToAppear("The form was successfully submitted!");
    }
    @Test
    public void shouldEnterWithoutAJobWithNoExperience(){

        fillingInWebForm.forANewCustomer("Billie",
                "Smith",
                " ",
                "High School",
                "Female",
                0);

        waitForTextToAppear("The form was successfully submitted!");
    }
    @Test
    public void shouldEnterWithALongName(){

        fillingInWebForm.forANewCustomer("Hubert-Giovanni-Leonardo",
                "Wolfeschlegelsteinhausenbergerorff",
                "Teacher",
                "Grad School",
                "Male",
                11);

        waitForTextToAppear("The form was successfully submitted!");
    }

}



