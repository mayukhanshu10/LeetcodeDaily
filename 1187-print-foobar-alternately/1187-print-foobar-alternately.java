import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    Semaphore foo;
    Semaphore bar;

    public FooBar(int n) {
        this.n = n;
        foo = new Semaphore(1); // Initially, foo is available
        bar = new Semaphore(0); // Initially, bar is not available
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire(); // Acquire the semaphore for foo
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release(); // Release the semaphore for bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire(); // Acquire the semaphore for bar
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release(); // Release the semaphore for foo
        }
    }
}
