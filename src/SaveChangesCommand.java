public class SaveChangesCommand extends Command {
    public SaveChangesCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.saveChanges();
    }
}
