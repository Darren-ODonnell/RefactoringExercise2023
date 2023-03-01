public class SaveFileCommand extends Command {
    public SaveFileCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.saveFile();
    }
}

