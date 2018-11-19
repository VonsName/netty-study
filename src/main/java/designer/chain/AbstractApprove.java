package designer.chain;

/**
 * @author ： fjl
 * @date ： 2018/11/19/019 10:44
 * 责任链模式
 */
public abstract class AbstractApprove {
    protected AbstractApprove nextApprove;

    /**
     * aa
     * @param money
     */
    public abstract void approve(double money);

    public AbstractApprove addApprove(AbstractApprove approve) {
        this.nextApprove = approve;
        return nextApprove;
    }
}
