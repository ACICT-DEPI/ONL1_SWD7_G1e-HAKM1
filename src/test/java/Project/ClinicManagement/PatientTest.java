package Project.ClinicManagement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void testPatientCreation() {
        // Create a new Patient object
        Patient patient = new Patient("John Doe", 30, "Male", "Flu");

        // Test if the name, age, gender, and disease are set correctly
        assertEquals("John Doe", patient.getName());
        assertEquals(30, patient.getAge());
        assertEquals("Male", patient.getGender());
        assertEquals("Flu", patient.getDisease());
    }

    @Test
    public void testGetDisease() {
        // Create a new Patient object
        Patient patient = new Patient("Jane Doe", 25, "Female", "Cold");

        // Test if the getDisease method returns the correct disease
        assertEquals("Cold", patient.getDisease());
    }

    @Test
    public void testGetRole() {
        // Create a new Patient object
        Patient patient = new Patient("Alice", 40, "Female", "Headache");

        // Test if the getRole method returns "Patient"
        assertEquals("Patient", patient.getRole());
    }
}