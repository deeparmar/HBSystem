package ui.testdata;

import org.apache.commons.lang3.RandomStringUtils;

public class BookingData {

    public void BookingData() {

    }

    public static Booking Booking_Record_1(){

        Booking booking  = new Booking();

        booking.firstName = "TestFirstname_" + RandomStringUtils.random(5, true, false);
        booking.lastName = "TestSurname_" + RandomStringUtils.random(5, true, false);
        booking.price = "100";
        booking.deposit = "true";
        booking.checkIn ="2019-10-30";
        booking.checkOut= "2019-11-30";;

        return booking;
    }


}
