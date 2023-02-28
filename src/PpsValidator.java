import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class PpsValidator extends InputValidator {
    protected final JTextField ppsField;
    protected final long currentByteStart;
    protected RandomFile application;
    protected File file;


    public PpsValidator(JTextField ppsField, long currentByteStart, RandomFile application, File file) {
        super();
        this.application = application;
        this.file = file;
        this.ppsField = ppsField;
        this.currentByteStart = currentByteStart;

    }

    @Override
    public boolean validate() {
        boolean valid = true;

        if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
            ppsField.setBackground(new Color(255, 150, 150));
            valid = false;
        } // end if
        if (ppsField.isEditable() && correctPps(ppsField.getText().trim(), currentByteStart)) {
            ppsField.setBackground(new Color(255, 150, 150));
            valid = false;
        } // end if

        return valid;
    }

    public boolean correctPps(String pps, long currentByte){
        // check for correct PPS format based on assignment description
        if (pps.length() == 8 || pps.length() == 9) {
            if(Character.isDigit(pps.charAt(0)) && Character.isDigit(pps.charAt(1))
                    && Character.isDigit(pps.charAt(2)) && Character.isDigit(pps.charAt(3))
                    && Character.isDigit(pps.charAt(4)) && Character.isDigit(pps.charAt(5))
                    && Character.isDigit(pps.charAt(6)) && Character.isLetter(pps.charAt(7))
                    && (pps.length() == 8 || Character.isLetter(pps.charAt(8))))
                return false;
        }
        return true;
    }



}