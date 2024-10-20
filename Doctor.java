import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private Specialization specialization;
    private List<Appointment> availableAppointments;
    public Doctor(String name, Specialization specialization)
    {
        this.name = name;
        this.specialization = specialization;
        this.availableAppointments = new ArrayList<>();
    }
    public void addAppointment(Appointment appointment)
    {
        availableAppointments.add(appointment);
    }

    public List<Appointment> getAvailableAppointments() {
        return availableAppointments;
    }
}