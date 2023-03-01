public class OpenFileCommand extends Command{
    public OpenFileCommand(EmployeeDetails employeeDetails){
        super(employeeDetails);
    }
    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.exitApp();
    }
}

