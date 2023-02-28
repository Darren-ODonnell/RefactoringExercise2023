/*
 * 
 * This is a dialog for adding new Employees and saving records to file
 * 
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AddRecordDialog extends JDialog implements ActionListener {
	JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JButton save, cancel;
	EmployeeDetails parent;
	// constructor for add record dialog
	public AddRecordDialog(EmployeeDetails parent) {
		setTitle("Add Record");
		setModal(true);
		this.parent = parent;
		this.parent.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane(dialogPane());
		setContentPane(scrollPane);
		
		getRootPane().setDefaultButton(save);
		
		setSize(500, 370);
		setLocation(350, 250);
		setVisible(true);
	}// end AddRecordDialog

	// initialize dialog container
	public Container dialogPane() {

		EmployeeDetailsDialogBuilder builder = new EmployeeDetailsDialogBuilder();
		return builder.setEmpDetailsBorder("Employee Details")
				.setIdField(idField = new JTextField(20))
				.setIdFieldEditable(true)
				.setIdFieldText(Integer.toString(this.parent.getNextFreeId()))
				.setPpsFieldDocument(ppsField = new JTextField(9))
				.setSurnameFieldDocument(surnameField = new JTextField(9))
				.setFirstNameFieldDocument(firstNameField = new JTextField(9))
				.setFont(this.parent.font1)
				.setGenderCombo(genderCombo = new JComboBox<>())
				.setGender(this.parent.gender)
				.setDepartmentCombo(departmentCombo = new JComboBox<>())
				.setDepartment(this.parent.department)
				.setFullTimeCombo(fullTimeCombo = new JComboBox<>())
				.setFullTime(this.parent.fullTime)
				.setSalary(salaryField = new JTextField(20))
				.setSaveButton(save = new JButton("Save"))
				.setSaveActionListener(this)
				.setCancelButton(cancel = new JButton("Cancel"))
				.setCancelActionListener(this)
				.build();
	}

	// add record to file
	public void addRecord() {
		boolean fullTime = false;
		Employee theEmployee;

		if (((String) fullTimeCombo.getSelectedItem()).equalsIgnoreCase("Yes"))
			fullTime = true;
		// create new Employee record with details from text field
		EmployeeBuilder builder = new EmployeeBuilder();

		try{
			theEmployee = builder.setId(Integer.parseInt(idField.getText()))
					.setPps(ppsField.getText().toUpperCase())
					.setSurname(surnameField.getText().toUpperCase())
					.setFirstName(firstNameField.getText().toUpperCase())
					.setGender(genderCombo.getSelectedItem().toString().charAt(0))
					.setDepartment(departmentCombo.getSelectedItem().toString())
					.setSalary(Double.parseDouble(salaryField.getText()))
					.setFullTime(fullTime)
					.build();

			this.parent.currentEmployee = theEmployee;
			this.parent.addRecord(theEmployee);
			this.parent.displayRecords(theEmployee);
			}catch(IllegalStateException e){
				e.printStackTrace();
			}

	}

	// check for input in text fields
	private boolean checkInput() {
		boolean valid;
		// if any of inputs are in wrong format, colour text field and display
		// message

		InputValidator ppsValidator = new PpsExistsValidator(ppsField, this.parent.currentByteStart, this.parent.application, this.parent.file);
		InputValidator firstNameValidator = new TextFieldValidator(firstNameField);
		InputValidator surnameValidator = new TextFieldValidator(surnameField);
		InputValidator genderValidator = new ComboValidator(genderCombo);
		InputValidator departmentValidator = new ComboValidator(departmentCombo);
		InputValidator salaryValidator = new SalaryValidator(salaryField);
		InputValidator fullTimeValidator = new ComboValidator(fullTimeCombo);

		ppsValidator.setNextValidator(firstNameValidator)
				.setNextValidator(surnameValidator)
				.setNextValidator(genderValidator)
				.setNextValidator(departmentValidator)
				.setNextValidator(salaryValidator)
				.setNextValidator(fullTimeValidator);

		valid = ppsValidator.validate();
		// show error message
		if (!valid)
			JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
		// set text field to white colour if text fields are editable
		if (ppsField.isEditable())
			setToWhite();

		return valid;
	}

	// set text field to white colour
	public void setToWhite() {
		this.parent.setToWhite();

	}// end setToWhite

	// action performed
	public void actionPerformed(ActionEvent e) {
		// if chosen option save, save record to file
		if (e.getActionCommand().equals("Save")) {
			// if inputs correct, save record
			if (checkInput()) {
				addRecord();// add record to file
				dispose();// dispose dialog
				this.parent.changesMade = true;
			}// end if
			// else display message and set text fields to white colour
			else {
				JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
				setToWhite();
			}// end else
		}// end if
		else if (e.getActionCommand().equals("Cancel"))
			dispose();// dispose dialog
	}// end actionPerformed
}// end class AddRecordDialog