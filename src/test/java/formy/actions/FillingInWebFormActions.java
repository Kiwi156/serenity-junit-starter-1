package formy.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

public class FillingInWebFormActions extends UIInteractions {

    @Step()
    public void forANewCustomer(String firstName,
                                String lastName,
                                String jobTitle,
                                String education,
                                String sex,
                                int yearsOfExperience) {

        openUrl("https://formy-project.herokuapp.com/form");


        $("#first-name").type(firstName);

        $("#last-name").type(lastName);

        $("#job-title").type(jobTitle);

        switch (education) {
            case "High School" -> {
                $("#radio-button-1").click();
            }
            case "College" -> {
                $("#radio-button-2").click();
            }
            case "Grad School" -> {
                $("#radio-button-3").click();
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }

        switch (sex) {
            case "Male" -> {
                $("#checkbox-1").click(); //Male selected
            }
            case "Female" -> {
                $("#checkbox-2").click(); // Female selected
            }
            case "Prefer not to say" -> {
                $("#checkbox-3").click(); // Prefer not to say selected
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }

        switch (yearsOfExperience) {
            case 0, 1 -> {
                $("[value='1']").click();
            }
            case 2, 3, 4 -> {
                $("[value='2']").click();
            }
            case 5, 6, 7, 8, 9 -> {
                $("[value='3']").click();
            }
            default -> {
                $("[value='4']").click(); // 10 years plus experience

            }
        }

        $("#datepicker").click(); // Current day will be selected.

        $("[role='button']").click();
    }
 }

