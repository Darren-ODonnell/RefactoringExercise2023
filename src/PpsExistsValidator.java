import javax.swing.*;
import java.io.File;

public class PpsExistsValidator extends PpsValidator{

    public PpsExistsValidator(JTextField ppsField, long currentByteStart, RandomFile application, File file) {
        super(ppsField, currentByteStart, application, file);
    }

    @Override
    public boolean correctPps(String pps, long currentByte) {
        boolean ppsExist = false;
        // check for correct PPS format based on assignment description
        if (pps.length() == 8 || pps.length() == 9) {
            if (Character.isDigit(pps.charAt(0)) && Character.isDigit(pps.charAt(1))
                    && Character.isDigit(pps.charAt(2))	&& Character.isDigit(pps.charAt(3))
                    && Character.isDigit(pps.charAt(4))	&& Character.isDigit(pps.charAt(5))
                    && Character.isDigit(pps.charAt(6))	&& Character.isLetter(pps.charAt(7))
                    && (pps.length() == 8 || Character.isLetter(pps.charAt(8)))) {
                // open file for reading
                application.openReadFile(file.getAbsolutePath());
                // look in file is PPS already in use
                ppsExist = application.isPpsExist(pps, currentByte);
                application.closeReadFile();// close file for reading
            } // end if
            else
                ppsExist = true;
        } // end if
        else
            ppsExist = true;

        return ppsExist;
    }// end correctPPS
}
