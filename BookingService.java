public class BookingService {

    private AppointmentDAO appointmentDAO; // Adatbázis lekérdezésekhez
    private BookingDAO bookingDAO; // Foglalások kezeléséhez

    public BookingService(AppointmentDAO appointmentDAO, BookingDAO bookingDAO) {
        this.appointmentDAO = appointmentDAO;
        this.bookingDAO = bookingDAO;
    }

    // Foglalás létrehozása
    public boolean createBooking(Patient patient, Appointment appointment) {
        if (appointment.isBooked()) {
            return false; // Az időpont már foglalt
        }

        Booking booking = new Booking(patient, appointment);
        bookingDAO.save(booking); // Adatbázisba mentés
        appointment.setBooked(true);
        appointmentDAO.update(appointment); // Frissíti az időpont státuszát
        return true;
    }
}
