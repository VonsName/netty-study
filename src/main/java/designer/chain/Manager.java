package designer.chain;

/**
 * @author ： fjl
 * @date ： 2018/11/19/019 10:46
 */
public class Manager extends AbstractApprove {
    @Override
    public void approve(double money) {
        if (money <= 8000) {
            System.out.println("Manager--通过");
        } else {
            this.nextApprove.approve(money);
        }
    }
}
