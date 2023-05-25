package no.restaff.fresher.tasks.operate_in;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import no.restaff.fresher.entity.BaseNominationObject;
import no.restaff.fresher.entity.Category;

public class Operate {
    public static Performable inCommentCategory(Category category) {
        return Tasks.instrumented(OperateInCommentCategory.class, category);
    }
    public static Performable inObjectManagement(BaseNominationObject baseNominationObject) {
        return Tasks.instrumented(OperateInObjectManagement.class, baseNominationObject);
    }
}
