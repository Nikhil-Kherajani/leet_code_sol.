class ParkingSystem {
    int nbig = 0;
    int nmedium = 0;
    int nsmall = 0;

    public ParkingSystem(int big, int medium, int small) {
        nbig = big;
        nmedium = medium;
        nsmall = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (nbig > 0) {
                    nbig--;
                    return true;
                }
                break;
            case 2:
                if (nmedium > 0) {
                    nmedium--;
                    return true;
                }
                break;
            case 3:
                if (nsmall > 0) {
                    nsmall--;
                    return true;
                }
                break;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */