package designer.facade;

import java.util.concurrent.TimeUnit;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:29
 * 外观模式
 * 解决类与类之间的依赖关系
 * 把类与类的关系聚集起来管理
 * 用于解耦
 */
public class Computer {

    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startUp() {
        System.out.println("---Computer starting---");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("---Computer started---");
    }

    public void shutDown() {
        System.out.println("---Computer closing");
        disk.shutDown();
        memory.shutDown();
        cpu.shutDown();
        System.out.println("---Computer closed");
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startUp();
        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        computer.shutDown();
    }
}
