package qa.guru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.pages.GitHubPages;


public class SelenideTest extends BaseTest {
    private static final String REPO_NAME = "aziyatdin0v/qa_guru_demoqa";
    private static final String ISSUE_NAME = "test";
    GitHubPages gitHubPages = new GitHubPages();

    @Test
    @DisplayName("Тест selenide")
    public void testIssueSearch() {
        gitHubPages.openPage()
                .searchInputClick()
                .searchInputSetValue(REPO_NAME)
                .searchInputSubmit()
                .repoLinkClick()
                .issueTabClick()
                .checkIssueExist(ISSUE_NAME);
    }
}
