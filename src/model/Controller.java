package model;


public class Controller {

    private int floors = 12;
    private int devicesPerFloor = 4;
    private Device [][]  deviceMatrix;

    private int totalDevicesah;

    public Controller() {
        deviceMatrix = new Device[floors][devicesPerFloor];
    }

    public boolean addDevice(String serial, double consumption, String description, int floor) {
        
        if (searchDevice(serial) != null) {
            return false;
        }
        for (int j = 0; j < deviceMatrix[floor].length; j ++) {
            if(deviceMatrix[floor][j] == null) {
                deviceMatrix[floor][j] = new Device(serial, consumption, description);
                return true;
            }
        }
        return false;
    }

    public boolean registerEventToDevice(String serial, double duration) {

    }

    public double calculateTotalConsumption(String serial) {
        Device foundDevice = searchDevice(serial);
        if (foundDevice != null) {
            double totalHours = foundDevice.calculateTotalHours();

            double totalConsumption = totalHours * foundDevice.getConsumption();
            return totalConsumption;
        }
    }

    public String getHighConsumptionReport() {

    }

    private Device searchDevice(String serial) {
    for (int i = 0; i < floors; i++) {
        for (int j = 0; j < devicesPerFloor; j++) {
            
            if (deviceMatrix[i][j] != null && deviceMatrix[i][j].getSerial().equals(serial)) {
                return deviceMatrix[i][j];
            }
        }
    }
    return null; 
}

}
