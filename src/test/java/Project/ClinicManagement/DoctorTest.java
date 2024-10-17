package Project.ClinicManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    public void testDoctorCreation() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Smith", 45, "Male", "Cardiology");

        // Test if the name, age, gender, and specialty are set correctly
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals(45, doctor.getAge());
        assertEquals("Male", doctor.getGender());
        assertEquals("Cardiology", doctor.getSpecialty());
    }

    @Test
    public void testGetSpecialty() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Johnson", 50, "Female", "Neurology");

        // Test if the getSpecialty method returns the correct specialty
        assertEquals("Neurology", doctor.getSpecialty());
    }

    @Test
    public void testGetRole() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Adams", 38, "Male", "Pediatrics");

        // Test if the getRole method returns "Doctor"
        assertEquals("Doctor", doctor.getRole());
    }
}