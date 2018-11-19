package designer.chain;

/**
 * @author ： fjl
 * @date ： 2018/11/19/019 10:38
 */
public class Staff extends AbstractApprove {


    @Override
    public void approve(double money) {
        if (money <= 5000) {
            System.out.println("Staff--通过");
        } else {
            this.nextApprove.approve(money);
        }
    }
}
