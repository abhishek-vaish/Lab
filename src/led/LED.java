package led;

import java.util.Scanner;

public class LED {
    private String colorName;
    private boolean working;

    public LED(String colorName, boolean working) {
        this.colorName = colorName;
        this.working = working;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}

class LEDStrip {
    private LED[] leds;

    public LEDStrip(LED[] leds) {
        this.leds = leds;
    }

    public boolean isWorking() {
        return this.isWorking();
    }

    public LED[] getLeds() {
        return leds;
    }

    public void setLeds(LED[] leds) {
        this.leds = leds;
    }

    private int lengthOfStrip() {
        return this.leds.length;
    }

    private int numberOfDefectiveLEDs() {
        int count = 0;
        for (int i = 0; i < lengthOfStrip(); i++) {
            if (leds[i].isWorking() == false) {
                count++;
            }
        }
        return count;
    }

    private boolean isStripDefective() {
        return (numberOfDefectiveLEDs() > lengthOfStrip() / 2);
    }

    public String stripStatus() {
        return isStripDefective() ? "This strip is defective." : "This is strip is not defective.";
    }
}

class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        LED[] arr = new LED[num];
        for (int j = 0; j < num; j++) {
            String colorName = scan.next();
            boolean working = scan.nextBoolean();
            arr[j] = new LED(colorName, working);
        }
        LEDStrip ledstrip = new LEDStrip(arr);
        System.out.println(ledstrip.stripStatus());
        scan.close();
    }
}

