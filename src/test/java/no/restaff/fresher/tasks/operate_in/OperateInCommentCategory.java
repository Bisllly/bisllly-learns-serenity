package no.restaff.fresher.tasks.operate_in;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import no.restaff.fresher.actions.ClearField;
import no.restaff.fresher.entity.Category;
import no.restaff.fresher.tasks.Pause;
import no.restaff.fresher.ui.comment_category_ui.CreateCommentCategoryBox;
import no.restaff.fresher.ui.comment_category_ui.CreateCommentCategoryUI;
import no.restaff.fresher.ui.comment_category_ui.UpdateCommentCategoryBox;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OperateInCommentCategory implements Task {

    private Category category;
    public OperateInCommentCategory(Category category) {
        this.category = category;
    }

    @Override
    @Step("{0} operate in comment category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreateCommentCategoryUI.ADD_BUTTON_HOVER, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(CreateCommentCategoryUI.ADD_BUTTON_HOVER),
                Enter.theValue(category.getName()).into(CreateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Pause.seconds(5),
                Click.on(CreateCommentCategoryBox.COMMENT_CATEGORY_SAVE_BTN),
                Click.on(CreateCommentCategoryUI.ADDED_EDIT_BUTTON.of(category.getName())),
                ClearField.the(UpdateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Enter.theValue(category.getUpdatedName()).into(UpdateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Click.on(UpdateCommentCategoryBox.COMMENT_CATEGORY_SAVE_BTN),
                Click.on(CreateCommentCategoryUI.ADDED_DELETE_BUTTON.of(category.getUpdatedName())),
                Click.on(CreateCommentCategoryUI.CONFIRM_DELETE_BTN)
        );
    }
}
