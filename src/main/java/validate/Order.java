package validate;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

/**
 * @author ： fjl
 * @date ： 2018/12/25/025 10:20
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -1377598933831914213L;

    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    public void check() {
        checkWithGroup();
    }

    /**
     * jsr3校验参数
     *
     * @param groups
     */
    public void checkWithGroup(Class<?>... groups) {
        Set<ConstraintViolation<Order>> validates = ValidatorFacgory.INSTANCE.getValidator().validate(this, groups);
        validate(validates);
    }

    /**
     * 根据校验参数返回的错误信息,抛出错误到系统
     *
     * @param violations
     * @param <T>
     */
    public <T> void validate(Set<ConstraintViolation<T>> violations) {
        if (violations != null && !violations.isEmpty()) {
            for (ConstraintViolation<T> violation : violations) {
                throw new RuntimeException(violation.getMessage());
            }
        }
    }
}
