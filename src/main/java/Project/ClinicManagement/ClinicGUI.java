package Project.ClinicManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClinicGUI {
    private JFrame frame;
    private JTextField nameField, ageField, diseaseField;
    private JComboBox<String> genderComboBox, doctorComboBox, slotComboBox;
    private JButton submitButton, viewButton;
    private List<Patient> patients = new ArrayList<>();

    public ClinicGUI() {
        frame = new JFrame("Clinic Management");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Project logo
        JLabel logoLabel = new JLabel(new ImageIcon("logo-color.png"));  // Add your logo.png to the project directory
        logoLabel.setBounds(500, 40, 800, 800);  // Adjust size and position of the logo
        frame.add(logoLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        frame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 100, 100, 30);
        frame.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 100, 200, 30);
        frame.add(ageField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 150, 100, 30);
        frame.add(genderLabel);

        genderComboBox = new JComboBox<>(new String[] {"Male", "Female"});
        genderComboBox.setBounds(150, 150, 200, 30);
        frame.add(genderComboBox);

        JLabel diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(50, 200, 100, 30);
        frame.add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(150, 200, 200, 30);
        frame.add(diseaseField);

        JLabel doctorLabel = new JLabel("Doctor:");
        doctorLabel.setBounds(50, 250, 100, 30);
        frame.add(doctorLabel);

        doctorComboBox = new JComboBox<>(new String[] {"Dr. Smith", "Dr. Jones"});
        doctorComboBox.setBounds(150, 250, 200, 30);
        frame.add(doctorComboBox);

        JLabel slotLabel = new JLabel("Slot:");
        slotLabel.setBounds(50, 300, 100, 30);
        frame.add(slotLabel);

        slotComboBox = new JComboBox<>(new String[] {"9AM - 10AM", "10AM - 11AM"});
        slotComboBox.setBounds(150, 300, 200, 30);
        frame.add(slotComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 350, 100, 30);
        frame.add(submitButton);

        // Button to view saved data
        viewButton = new JButton("View Data");
        viewButton.setBounds(200, 350, 150, 30);
        frame.add(viewButton);
        
        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(300, 420, 100, 30);
        frame.add(closeButton);
        
        // Team Members Information
        JLabel teamInfoLabel = new JLabel("<html>Team Members:<br>1. Kerolos Emad<br>2. Ahmad Hesham<br>3. Ahmed Galal<br>4. Hussien Bakr<br>5. Abdelhay Elkemary<br>6. Mohamed Hussien<br>7. Mahmoud Abbas</html>");
        teamInfoLabel.setBounds(150, 470, 200, 100);  // Adjust size and position
        frame.add(teamInfoLabel);

        // Submit button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = (String) genderComboBox.getSelectedItem();
                String disease = diseaseField.getText();

                Patient patient = new Patient(name, age, gender, disease);
                patients.add(patient);

                try {
                    ExcelHandler.writeDataToExcel(patients);
                    JOptionPane.showMessageDialog(frame, "Patient added and data saved to Excel!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // View data button action
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<String[]> data = ExcelHandler.readDataFromExcel();
                    JFrame dataFrame = new JFrame("Patient Data");
                    dataFrame.setSize(600, 400);
                    JTextArea dataArea = new JTextArea();

                    for (String[] row : data) {
                        for (String cell : row) {
                            dataArea.append(cell + "\t");
                        }
                        dataArea.append("\n");
                    }

                    JScrollPane scrollPane = new JScrollPane(dataArea);
                    dataFrame.add(scrollPane);
                    dataFrame.setVisible(true);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error reading Excel file!");
                    ex.printStackTrace();
                }
            }
        });
        
        // Close action
        closeButton.addActionListener(e -> frame.dispose());  // This will close the GUI

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ClinicGUI();
    }
}