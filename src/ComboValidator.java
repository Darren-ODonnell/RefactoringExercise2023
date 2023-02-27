import javax.swing.*;
import java.awt.*;

public class ComboValidator extends InputValidator{
    private final JComboBox<String> combo;

    public ComboValidator(JComboBox<String> combo) {
        this.combo = combo;
    }

    @Override
    public boolean validate() {
        boolean valid = true;
        if (combo.getSelectedIndex() == 0 && combo.isEnabled()) {
            combo.setBackground(new Color(255, 150, 150));
            valid = false;
        }
        return valid;
    }

}
