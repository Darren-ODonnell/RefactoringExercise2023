public class EmployeeTableColumnStrategy implements TableColumnStrategy{
    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;
            case 4:
                return Character.class;
            case 6:
                return Double.class;
            case 7:
                return Boolean.class;
            default:
                return String.class;
        }
    }
}
