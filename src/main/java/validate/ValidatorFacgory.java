package validate;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author ： fjl
 * @date ： 2018/12/25/025 10:18
 */
public enum ValidatorFacgory {

    /**
     *
     */
    INSTANCE {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        @Override
        public Validator getValidator() {
            return validatorFactory.getValidator();
        }
    };

    public abstract Validator getValidator();
}
