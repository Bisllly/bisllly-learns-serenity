package no.restaff.fresher.tasks.navigate_to;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

public class Navigate {

    public static Performable toCommentCategory() {
        return Tasks.instrumented(NavigateToCommentCategory.class);
    }

    public static Performable toObjectManagement() {
        return Tasks.instrumented(NavigateToObjectManagement.class);
    }
}
