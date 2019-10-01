package ui;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.testdata.Booking;
import java.util.ArrayList;
import java.util.List;


public class BookingPage extends BasePage {

    public static Integer beforeCount;
    public static String expectedFirstName;
    public boolean isDeleted = false;

    public String expPageHeading = "Hotel booking form";


    public BookingPage(WebDriver driver)
    {
        super(driver);

    }

    @FindBy(css = "div[class='jumbotron']")
    public WebElement pageHeading;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "totalprice")
    private WebElement totalPrice;

    @FindBy(id = "depositpaid")
    private WebElement depositPaid;

    @FindBy(id = "checkin")
    private WebElement checkIn;

    @FindBy(id = "checkout")
    private WebElement checkOut;

    @FindBy(css = "input[value=' Save ']")
    private WebElement save;

    @FindBy(css = "input[value='Delete']")
    private WebElement delete;


    @FindBy(css = "div[id='bookings']")
    public WebElement bookingRecords;

    public void setFirstName(String fName) {

        if(isElementDisplayed(firstName))
        {
            firstName.clear();
            firstName.sendKeys(fName);
            expectedFirstName =fName;
        }
    }
    public void setLastName(String lName) {

        if(isElementDisplayed(lastName))
        {
            lastName.clear();
            lastName.sendKeys(lName);
        }
    }
    public void setTotalPrice(String tPrice) {

        if(isElementDisplayed(totalPrice))
        {
            totalPrice.clear();
            totalPrice.sendKeys(tPrice);
        }
    }

    public void selectDepositPaid(String dPaid) {

        if(isElementDisplayed(depositPaid))
        {
            Select dropdown = new Select(depositPaid);
            dropdown.selectByVisibleText(dPaid);
        }
    }

    public void setCheckInDate(String chkInDate) {

        if(isElementDisplayed(checkIn))
        {
            checkIn.clear();
            checkIn.sendKeys(chkInDate);
        }
    }

    public void setCheckOutDate(String chkOutDate) {

        if(isElementDisplayed(checkOut))
        {
            checkOut.clear();
            checkOut.sendKeys(chkOutDate);
        }
    }

    public void setIsDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }
    public Boolean IsDeleted() {
        return isDeleted;
    }
    public void setBookingData(Booking booking)
    {
        setFirstName(booking.firstName);
        setLastName(booking.lastName);
        setTotalPrice(booking.price);
        setCheckInDate(booking.checkIn);
        setCheckOutDate(booking.checkOut);
    }

    public void  deleteBookingRecord()
    {

        List<Booking> listbookingObjects = new ArrayList<Booking>();

        List<WebElement> rows = bookingRecords.findElements(By.className("row"));

        for(int i = 1 ; i < rows.size() ; i++) {

            WebElement row = rows.get(i);

            Booking booking = new Booking();
            booking.firstName = row.findElement(By.cssSelector("div[class*='col-md']")).getText();

           if (expectedFirstName.equalsIgnoreCase( booking.firstName))
            {
                row.findElement(By.cssSelector("input[type='button']")).click();
                setIsDeleted(true);
                break;
            }
            else
                listbookingObjects.add(booking);
        }

    }

    public void clickSubmit()
    {
        //Store count of total record before the creation of the new one
        beforeCount = getBeforeCount();
        save.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBeforeCount(){

        List<WebElement> rows = bookingRecords.findElements(By.className("row"));
        beforeCount = rows.size();
        return beforeCount;
    }

     public boolean bookingCreated()
     {
        Boolean created =false;

         List<WebElement> rows = bookingRecords.findElements(By.className("row"));

         if (rows.size() > beforeCount) {
             created= true;
         }
         return  created;
     }

}
