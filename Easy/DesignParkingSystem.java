/*
Question:
Design a parking system with 3 types of slots:
1 = Big, 2 = Medium, 3 = Small.

Implement:
- ParkingSystem(int big, int medium, int small)
- boolean addCar(int carType)

Return true if parking available, else false.
*/

class ParkingSystem {

    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 && big > 0) {
            big--;
            return true;
        }
        if (carType == 2 && medium > 0) {
            medium--;
            return true;
        }
        if (carType == 3 && small > 0) {
            small--;
            return true;
        }
        return false;
    }
}
