import javax.xml.validation.Validator;
import java.io.File;

public abstract class InputValidator {
    protected InputValidator nextValidator;

    public InputValidator setNextValidator(InputValidator nextValidator) {
        this.nextValidator = nextValidator;
        return nextValidator;
    }
    abstract boolean validate();
}