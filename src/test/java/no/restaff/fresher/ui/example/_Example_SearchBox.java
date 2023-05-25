package no.restaff.fresher.ui.example;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class _Example_SearchBox {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));
}
