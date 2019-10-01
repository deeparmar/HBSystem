package testcases;

import com.aventstack.extentreports.ExtentTest;
import org.junit.*;
import ui.BookingPage;
import ui.testdata.BookingData;


public class TestCase_Booking extends BaseWebDriverTestCase {

    protected BookingPage bookingPage;

    @Before
    public void Setup() {

        bookingPage = new BookingPage(driver);
    }

    @Test
    public void WhenUserNavigatesToTheBookingPage_PageHasLoaded() {
        //TODO
    }

    @Test
    public void WhenThePageIsLoaded_CheckDepositeDropDownValues() {
        //TODO
    }

    @Test
    public void WhenUserCreatesABooking_BookingCreated() {

        //1 when user enter data in the form
        bookingPage.setBookingData(BookingData.Booking_Record_1());

        //2 user submits the data
        bookingPage.clickSubmit();

        //3. Then the booking is created
        Assert.assertTrue(bookingPage.bookingCreated());

    }

    @Test
    public void WhenUserDeletesABooking_BookingIsDeleted() {

        //1 Given that user has added a booking record
        bookingPage.setBookingData(BookingData.Booking_Record_1());
        bookingPage.clickSubmit(); //store id of newly created Row
        Assert.assertTrue(bookingPage.bookingCreated());

        //2 When user deletes the recorddeleteBookingRecord, record is deleted
        bookingPage.deleteBookingRecord();
        Assert.assertTrue(bookingPage.isDeleted);
    }

    @After
    public void TearDown1() throws Exception {


    }

}