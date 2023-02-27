import javax.swing.*;
import java.awt.*;

public class SalaryValidator implements InputValidator{
    private final JTextField salary;


    public SalaryValidator(JTextField salary) {
        this.salary = salary;
    }

    @Override
    public boolean validate() {
        boolean valid = true;
        try {
            double salaryVal = Double.parseDouble(salary.getText());
            if (salaryVal < 0) {
                salary.setBackground(new Color(255, 150, 150));
                valid = false;
            }
        } catch (NumberFormatException e) {
            if (salary.isEditable()) {
                salary.setBackground(new Color(255, 150, 150));
                valid = false;
            }
        }
        return valid;
    }
}
