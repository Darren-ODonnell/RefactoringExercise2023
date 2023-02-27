import javax.swing.*;
import java.awt.*;

public class TextFieldValidator implements InputValidator{
    private final JTextField textField;

    public TextFieldValidator(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public boolean validate() {
        boolean valid = true;
        if (textField.isEditable() && textField.getText().trim().isEmpty()) {
            textField.setBackground(new Color(255, 150, 150));
            valid = false;
        }
        return valid;
    }
}
