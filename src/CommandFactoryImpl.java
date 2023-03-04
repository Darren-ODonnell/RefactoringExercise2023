public class CommandFactoryImpl implements CommandFactory {
    private final EmployeeDetails parent;

    public CommandFactoryImpl(EmployeeDetails parent) {
        this.parent = parent;
    }

    @Override
    public Command createCommand(Object source) {
        if (this.parent.closeApp == source) {
            return new CloseAppCommand(this.parent);
        } else if (this.parent.open == source) {
            return new OpenFileCommand(this.parent);
        } else if (this.parent.save == source) {
            this.parent.change = false;
            return new SaveFileCommand(this.parent);
        } else if (this.parent.saveAs == source) {
            this.parent.change = false;
            return new SaveAsCommand(this.parent);
        } else if (this.parent.searchById == source) {
            return new SearchByIdCommand(this.parent);
        } else if (this.parent.searchBySurname == source) {
            return new SearchBySurnameDialogCommand(this.parent);
        } else if (this.parent.searchId == source || this.parent.searchByIdField == source) {
            return new SearchIdCommand(this.parent);
        } else if (this.parent.searchSurname == source || this.parent.searchBySurnameField == source) {
            return new SearchSurnameCommand(this.parent);
        } else if (this.parent.saveChange == source) {
            return new SaveChangesCommand(this.parent);
        } else if (this.parent.cancelChange == source) {
            return new CancelChangeCommand(this.parent);
        } else if (this.parent.firstItem == source || this.parent.first == source) {
            return new FirstItemCommand(this.parent);
        } else if (this.parent.prevItem == source || this.parent.previous == source) {
            return new PreviousItemCommand(this.parent);
        } else if (this.parent.nextItem == source || this.parent.next == source) {
            return new NextItemCommand(this.parent);
        } else if (this.parent.lastItem == source || this.parent.last == source) {
            return new LastItemCommand(this.parent);
        } else if (this.parent.listAll == source || this.parent.displayAll == source) {
            return new ListAllCommand(this.parent);
        } else if (this.parent.create == source || this.parent.add == source) {
            return new CreateAddRecordDialogCommand(this.parent);
        } else if (this.parent.modify == source || this.parent.edit == source) {
            return new ModifyCommand(this.parent);
        } else if (this.parent.delete == source || this.parent.deleteButton == source) {
            return new DeleteCommand(this.parent);
        } else {
            throw new IllegalArgumentException("Invalid event source: " + source);
        }
    }
}