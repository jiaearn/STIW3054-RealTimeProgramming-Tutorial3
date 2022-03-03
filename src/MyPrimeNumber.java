import java.util.Scanner;

public class MyPrimeNumber {

    static int x, y, z, totalFirst, totalSecond, total;


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Please input x: ");
            x = sc.nextInt();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Please insert an integer.");
        }

        y = x + 5;
        z = x + 10;
        Thread t1 = new Thread(MyPrimeNumber::firstThread);
        Thread t2 = new Thread(MyPrimeNumber::secondThread);
        t1.start();
        t2.start();

        Thread.sleep(200);
        total = totalFirst + totalSecond;
        System.out.println("Total: " + total);
    }

    private static boolean checkPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void firstThread() {
        for (int i = x; i <= y; i++) {
            if (checkPrime(i)) {
                totalFirst = totalFirst + i;
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    public static void secondThread() {
        for (int i = y; i <= z; i++) {
            if (checkPrime(i)) {
                totalSecond = totalSecond + i;
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
