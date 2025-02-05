import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecOne());
        Thread t2 = new Thread(new ExecTwo());
        Thread t3 = new Thread(new ExecThree());

        t1.start();
        t2.start();
        t3.start();
    }
}

class ExecOne implements Runnable {
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= 50; i++) {
            System.out.println("thread #1" + ":" + i);
            try {
                Thread.sleep(rand.nextInt(100)); // ดีเลย์แบบสุ่ม 0-99 มิลลิวินาที
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExecTwo implements Runnable {
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= 50; i++) {
            System.out.println("thread #2" + ":" + i);
            try {
                Thread.sleep(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExecThree implements Runnable {
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= 50; i++) {
            System.out.println("thread #3" + ":" + i);
            try {
                Thread.sleep(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// ก่อนเพิ่ม Thread.sleep():
// แต่ละเธรดทำงานพร้อมกันและพิมพ์ข้อความลงคอนโซล
// ผลลัพธ์ที่ได้จะเป็นลำดับที่ไม่แน่นอน ขึ้นอยู่กับว่าThreadสามารถทำงานได้เร็วกว่า

// หลังเพิ่ม Thread.sleep():
// มีการหน่วงเวลาแบบสุ่ม ทำให้แต่ละเธรดหยุดรอสั้นๆ(อาจเท่ากันหรือไม่เท่ากัน)
// ผลลัพธ์ยังคงไม่เป็นลำดับแน่นอน

// การทำงานของมัลติเธรดใน Java:
// Java สามารถrun หลายๆเธรดได้พร้อมๆกัน
// โดยคำสั่ง Thread.sleep() ทำให้เธรดปัจจุบันหยุดพักและเปิดโอกาสให้เธรดอื่นทำงาน
// จึงทำให้ผลลัพธ์ที่ได้จะเปลี่ยนไปในแต่ละการรันโปรแกรม
