package qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import qa.guru.pages.GitHubPages;

public class WebSteps {
    GitHubPages gitHubPages = new GitHubPages();

    @Step("Открываем главную страницу")
    public void openMainPage() {
        gitHubPages.openPage();
    }

    @Step("Ищем репозиторий {value}")
    public void searchForRepository(String value) {
        gitHubPages.searchInputClick()
                .searchInputSetValue(value)
                .searchInputSubmit();
    }

    @Step("Кликаем по ссылке репозитория {value}")
    public void clickOnRepositoryLink(String value) {
        gitHubPages.repoLinkClick();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        gitHubPages.issueTabClick();
    }

    @Step("Проверяем наличие Issue с наименованием {value}")
    public void shouldSeeIssueWithNumber(String value) {
        gitHubPages.checkIssueExist(value);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}