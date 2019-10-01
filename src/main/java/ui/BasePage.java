package ui;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.PageFactory;
 import org.openqa.selenium.support.ui.ExpectedCondition;
 import org.openqa.selenium.support.ui.WebDriverWait;


 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.PageFactory;
 import org.openqa.selenium.support.ui.ExpectedCondition;
 import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    public static WebDriver driver;

    private String title;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public boolean isElementDisplayed(WebElement elementToCheck)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until((ExpectedCondition<Boolean>) wd -> elementToCheck.isDisplayed());

        return  true;
    }

    public boolean checkIfPageHasLoadedContainsHeading(WebElement element, String elementExpectedText){

        String elementText = "";
        System.out.println();

        for (int i=0; i<3; i++) {

            boolean elementFound = this.isElementDisplayed(element);

            if (elementFound){

                elementText = element.getText();
                if (elementText.contains(elementExpectedText))
                {
                    return true;
                }
                else{
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("### Did not find page with heading: " + elementExpectedText);
        System.out.println("### Actually found page with heading: " + elementText);

        try {
            throw new AssertionError();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
