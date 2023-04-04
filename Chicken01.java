package coba;

public class Chicken01 {
    public static void main(String[] args) {
        int eggsPerChicken1 = 5;
        int chickenCount1 = 3;
        int totalEggs1 = 0;
        totalEggs1 += eggsPerChicken1 * chickenCount1; // Monday
        chickenCount1++; // gain 1 chicken on Tuesday
        totalEggs1 += eggsPerChicken1 * chickenCount1; // Tuesday
        chickenCount1 /= 2; // half the chickens on Wednesday
        totalEggs1 += eggsPerChicken1 * chickenCount1; // Wednesday
        System.out.println("Total eggs collected between Monday and Wednesday with 3 chickens and 5 eggs/chicken " + totalEggs1);
        
        int eggsPerChicken2 = 4;
        int chickenCount2 = 8;
        int totalEggs2 = 0;
        totalEggs2 += eggsPerChicken2 * chickenCount2; // Monday
        chickenCount2++; // gain 1 chicken on Tuesday
        totalEggs2 += eggsPerChicken2 * chickenCount2; // Tuesday
        chickenCount2 /= 2; // half the chickens on Wednesday
        totalEggs2 += eggsPerChicken2 * chickenCount2; // Wednesday
        System.out.println("Total eggs collected between Monday and Wednesday with 8 chickens and 4 eggs/chicken: " + totalEggs2);
        
    }
}

