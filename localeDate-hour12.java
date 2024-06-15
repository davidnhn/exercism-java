import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("M/d/yyyy H:mm:ss");
        LocalDateTime datetime = LocalDateTime.parse(appointmentDateDescription, parser);

        return datetime;
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return LocalDateTime.now().isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {

        String dayOfTheWeek = appointmentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
        String month = appointmentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
        
       
        int day = appointmentDate.getDayOfMonth();
        int year = appointmentDate.getYear();
        int hour = appointmentDate.getHour();
        int minute = appointmentDate.getMinute();
        int second = appointmentDate.getSecond();

        int hour12 = hour % 12;

        if(hour % 12 == 0){
            hour12 = 12;
        }

        StringBuilder description = new StringBuilder();

        description.append("You have an appointment on ")
            .append(dayOfTheWeek).append(", ")
            .append(month).append(" ")
            .append(day).append(", ")
            .append(year).append(", at ")
            .append(hour12).append(":")
            .append(String.format("%02d", minute)).append(" ");

        if(this.isAfternoonAppointment(appointmentDate)) {
            description.append("PM.");
        }else {
            description.append("AM.");
        }
        return description.toString();        
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}
