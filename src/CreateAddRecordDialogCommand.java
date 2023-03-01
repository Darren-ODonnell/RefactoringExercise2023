public class CreateAddRecordDialogCommand extends Command {
    public CreateAddRecordDialogCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            new AddRecordDialog(employeeDetails);
    }
}

