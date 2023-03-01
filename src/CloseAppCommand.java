public class CloseAppCommand extends Command{

    public CloseAppCommand(EmployeeDetails employeeDetails){
        super(employeeDetails);
    }
    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.exitApp();
    }
}
