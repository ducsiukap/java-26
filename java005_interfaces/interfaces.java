package java005_interfaces;

// inteface và abstract class bổ sung tính `abstraction - trừu tượng` cho Java OOP.
// ---------------
// > keyword:
// - abstract class: abstract class, extends
// - interface: interface, implements
// ---------------
// > relation
// - abstract: IS-A -> (class can extend only one class)
// - interface: CAN-DO -> (class can implement multiple interfaces)
//      // interface can extends other interface
// ---------------
// > properties
// - abstract: can be: private, protected, public, static, non-static, ...
// - interface: only one type: public static final (constant)
// ---------------
// > methods:
// - abstract: như class bình thương + bổ sung abstract method
// - interface: mặc định là public abstract method 
//      + Java 8: bổ sung default/static method
//      + Java 9: bổ sung private method -> logic cho default/static method

// syntax
interface Vehicle {
    int MAX_SPEED = 120; // public static final

    // public abstract
    void speedUp(int speed);

    void applyBrakes(int speed);

    // default method
    static void honk() {
        System.out.println("Beep Beep!");
    }

    // static method
    default void showInfo() {
        System.out.println("This is a Vehicle");
    }
}

//
interface Flyable {
    void fly();
}

// class implements
class Car implements Vehicle {
    private int speed;

    public Car(int speed) {
        this.speed = speed > MAX_SPEED ? MAX_SPEED : speed < 0 ? 0 : speed;
    }

    // have to override all abstract methods
    @Override
    public void speedUp(int speed) {
        int change = Math.min(speed, MAX_SPEED - this.speed);
        this.speed += change;
        System.out.println("Car is speeding up by " + change + " km/h");
    }

    @Override
    public void applyBrakes(int speed) {
        int change = Math.min(speed, this.speed - 0);
        this.speed -= change;
        System.out.println("Car is slowing down by " + change + " km/h");
    }

    // can override default method
    @Override
    public void showInfo() {
        System.out.println("vehicle: Car, current speed: " + this.speed + " km/h");
    }
}

// implements multiple interfaces
class AirPlane implements Vehicle, Flyable {
    private int speed;
    boolean isFlying;

    public AirPlane(int speed) {
        this.speed = speed > MAX_SPEED ? MAX_SPEED : speed < 0 ? 0 : speed;
        this.isFlying = this.speed > 0 ? true : false;
    }

    private void changeFlyingStatus() {
        if (this.speed > 0 && !this.isFlying) {
            this.isFlying = true;
        } else if (this.speed == 0 && this.isFlying) {
            this.isFlying = false;
        }
    }

    public void start() {
        start(5);
    }

    public void start(int speed) {
        if (speed <= 0 || speed > MAX_SPEED)
            speed = 5;
        this.speed = speed;
        changeFlyingStatus();
    }

    public void land() {
        this.speed = 0;
        changeFlyingStatus();
    }

    // have to override all abstract methods
    @Override
    public void speedUp(int speed) {
        if (!isFlying) {
            System.out.println("Let start flying first!");
            return;
        }
        int change = Math.min(speed, MAX_SPEED - this.speed);
        this.speed += change;
        System.out.println("Airplane is speeding up by " + change + " km/h");
    }

    @Override
    public void applyBrakes(int speed) {
        if (!isFlying) {
            System.out.println("Let start flying first!");
            return;
        }

        int change = Math.min(speed, this.speed - 0);
        this.speed -= change;
        System.out.println("Airplane is slowing down by " + change + " km/h");

        if (this.speed == 0) {
            land();
        }
    }

    @Override
    public void fly() {
        System.out.printf("Airplain is %s!%n",
                this.isFlying ? "flying, current speed: %s km/h".formatted(this.speed) : "not flying");
    }
}

public class interfaces {
    public static void main(String[] args) {

        System.out.println();
        Vehicle vehicle = new Car(50);
        vehicle.speedUp(30);
        vehicle.applyBrakes(10);
        // invoke default method
        // if not override, -> default implementation in interface will be invoked
        vehicle.showInfo();
        // invoke static method
        Vehicle.honk();

        System.out.println();
        // note: nếu implement multiple interfaces,
        // mà tạo object bằng interface cha, muốn gọi method của interface khác
        // thì phải ép kiểu về interface tương ứng để gọi method của interface đó
        //
        // tốt nhất nên tạo bằng class
        AirPlane airPlane = new AirPlane(0);
        airPlane.speedUp(50);
        airPlane.start(30);
        airPlane.applyBrakes(20);
        airPlane.speedUp(80);
        airPlane.fly();
        airPlane.land();
        airPlane.fly();
        airPlane.showInfo(); // not override yet -> call default method in Vehicle interface
        Vehicle.honk(); // airPlane().honk()
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}