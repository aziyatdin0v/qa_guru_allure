package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.pages.GitHubPages;

import static io.qameta.allure.Allure.step;

public class LambdaStepTest extends BaseTest {
    private static final String REPO_NAME = "aziyatdin0v/qa_guru_demoqa";
    private static final String ISSUE_NAME = "test";
    GitHubPages gitHubPages = new GitHubPages();

    @Test
    @DisplayName("Тест с lamda")
    public void testLambdaStep() {

        step("Открываем главную страницу", () -> {
            gitHubPages.openPage();
        });

        step("Ищем репозиторий " + REPO_NAME, () -> {
            gitHubPages.searchInputClick()
                    .searchInputSetValue(REPO_NAME)
                    .searchInputSubmit();
        });

        step("Кликаем по ссылке репозитория " + REPO_NAME, () -> {
            gitHubPages.repoLinkClick();
        });

        step("Открываем таб Issues", () -> {
            gitHubPages.issueTabClick();
        });

        step("Проверяем наличие Issue с наименованием " + ISSUE_NAME, () -> {
            gitHubPages.checkIssueExist(ISSUE_NAME);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("aziyatdinov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест с аннотацией @Step")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPO_NAME);
        steps.clickOnRepositoryLink(REPO_NAME);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NAME);
    }
}
