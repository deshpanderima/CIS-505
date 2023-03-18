/* Deshpande Rima, (2023). CIS505-T301 Intermediate Java Programming (2235-1). Bellevue University, all rights reserved. */
public class TestFanApp {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.FAST, true, 10, "yellow");

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());
    }
}