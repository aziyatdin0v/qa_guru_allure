package qa.guru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubPages {
    private static final String REPO_NAME = "aziyatdin0v/qa_guru_demoqa";
    private final SelenideElement
            searchInput = $(".header-search-input"),
            repoLink = $(linkText(REPO_NAME)),
            issueTab = $("#issues-tab"),
            issueName = $(withText("test issue"));

    public GitHubPages openPage() {

        open("/");
        return this;
    }

    public GitHubPages searchInputClick() {

        searchInput.click();
        return this;
    }

    public GitHubPages searchInputSetValue(String value) {

        searchInput.setValue(value);
        return this;
    }

    public GitHubPages searchInputSubmit() {

        searchInput.submit();
        return this;
    }

    public GitHubPages repoLinkClick() {

        repoLink.click();
        return this;
    }

    public GitHubPages issueTabClick() {

        issueTab.click();
        return this;
    }

    public GitHubPages checkIssueExist(String value) {

        issueName.should(Condition.exist);
        return this;
    }
}
