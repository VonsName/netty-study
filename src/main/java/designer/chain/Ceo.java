package designer.chain;

/**
 * @author ： fjl
 * @date ： 2018/11/19/019 10:48
 */
public class Ceo extends AbstractApprove {

    @Override
    public void approve(double money) {
        if (money <= 10000) {
            System.out.println("Ceo--通过");
        } else {
            System.out.println("驳回");
        }
    }

    public static void main(String[] args) {
        AbstractApprove approve = new Staff();
        approve.addApprove(new Manager()).addApprove(new Ceo());
        approve.approve(100000);
    }
}
