import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeDetailsDialogBuilder {
    private JPanel empDetails = new JPanel(new MigLayout());
    private JPanel buttonPanel = new JPanel();
    private JTextField idField;
    private JTextField ppsField;
    private JTextField surnameField;
    private JTextField firstNameField;
    private JComboBox<String> genderCombo;
    private JComboBox<String> departmentCombo;
    private JTextField salaryField;
    private JComboBox<String> fullTimeCombo;
    private JButton save;
    private JButton cancel;
    private Font font;
    private String[] gender, department, fullTime;
    private ActionListener saveActionListener, cancelActionListener;

    public EmployeeDetailsDialogBuilder setEmpDetailsBorder(String title) {
        empDetails.setBorder(BorderFactory.createTitledBorder(title));
        return this;
    }

    public EmployeeDetailsDialogBuilder setIdField(JTextField idField, boolean editable, int id) {
        this.idField = idField;
        this.idField.setEditable(editable);
        this.idField.setText(Integer.toString(id));

        return this;
    }

    public EmployeeDetailsDialogBuilder setPpsFieldDocument(JTextField ppsFieldDocument) {
        ppsField = ppsFieldDocument;
        return this;
    }

    public EmployeeDetailsDialogBuilder setSurnameFieldDocument(JTextField surnameFieldDocument) {
        surnameField = surnameFieldDocument;
        return this;
    }

    public EmployeeDetailsDialogBuilder setFirstNameFieldDocument(JTextField firstNameFieldDocument) {
        firstNameField = firstNameFieldDocument;
        return this;
    }

    public EmployeeDetailsDialogBuilder setFont(Font font) {
        this.font = font;
        return this;
    }

    public EmployeeDetailsDialogBuilder setSaveButton(JButton saveButton, ActionListener actionListener) {
        save = saveButton;
        saveActionListener = actionListener;
        return this;
    }

    public EmployeeDetailsDialogBuilder setCancelButton(JButton cancelButton, ActionListener actionListener) {
        cancel = cancelButton;
        cancelActionListener = actionListener;
        return this;
    }

    public EmployeeDetailsDialogBuilder setFullTimeCombo(JComboBox<String> fullTimeCombo, String[] fullTime) {
        this.fullTimeCombo = fullTimeCombo;
        this.fullTime = fullTime;
        this.fullTimeCombo.setModel(new DefaultComboBoxModel<String>(fullTime));
        return this;
    }

    public EmployeeDetailsDialogBuilder setDepartmentCombo(JComboBox<String> departmentCombo, String[] department) {
        this.departmentCombo = departmentCombo;
        this.department = department;
        this.departmentCombo.setModel(new DefaultComboBoxModel<String>(department));
        return this;
    }
    public EmployeeDetailsDialogBuilder setGenderCombo(JComboBox<String> genderCombo, String[] gender) {
        this.genderCombo = genderCombo;
        this.gender = gender;
        this.genderCombo.setModel(new DefaultComboBoxModel<String>(gender));
        return this;
    }

    public EmployeeDetailsDialogBuilder setSalary(JTextField salaryField) {
        this.salaryField = salaryField;
        return this;
    }

    public JPanel build() {
        if(idField != null) {
            empDetails.add(new JLabel("ID:"), "growx, pushx");
            empDetails.add(idField, "growx, pushx, wrap");
        }

        if(ppsField != null) {
            empDetails.add(new JLabel("PPS Number:"), "growx, pushx");
            empDetails.add(ppsField, "growx, pushx, wrap");
        }

        if(surnameField != null) {
            empDetails.add(new JLabel("Surname:"), "growx, pushx");
            empDetails.add(surnameField, "growx, pushx, wrap");
        }

        if(firstNameField != null) {
            empDetails.add(new JLabel("First Name:"), "growx, pushx");
            empDetails.add(firstNameField, "growx, pushx, wrap");
        }

        if(genderCombo != null) {
            empDetails.add(new JLabel("Gender:"), "growx, pushx");
            empDetails.add(genderCombo, "growx, pushx, wrap");
        }

        if(departmentCombo != null) {
            empDetails.add(new JLabel("Department:"), "growx, pushx");
            empDetails.add(departmentCombo, "growx, pushx, wrap");
        }

        if(fullTimeCombo != null) {
            empDetails.add(new JLabel("Full Time:"), "growx, pushx");
            empDetails.add(fullTimeCombo, "growx, pushx, wrap");
        }
        if(salaryField != null) {
            empDetails.add(new JLabel("Salary:"), "growx, pushx");
            empDetails.add(salaryField, "growx, pushx, wrap");
        }

        if(saveActionListener != null){
            buttonPanel.add(save = new JButton("Save"));
            save.addActionListener(saveActionListener);
            save.requestFocus();
        }

        if(cancelActionListener != null){
            buttonPanel.add(cancel = new JButton("Cancel"));
            cancel.addActionListener(cancelActionListener);
        }

        if(buttonPanel != null)
            empDetails.add(buttonPanel, "span 2,growx, pushx,wrap");

        if(font != null)
            for (int i = 0; i < empDetails.getComponentCount(); i++) {
                empDetails.getComponent(i).setFont(font);
            }
        return empDetails;
    }



}