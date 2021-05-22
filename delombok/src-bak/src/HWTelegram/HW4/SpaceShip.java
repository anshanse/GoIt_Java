package HWTelegram.HW4;

public class SpaceShip {
    private String name;
    private String serialNumber;

    public void setName(String name) {
        if ((name.strip().length() ==0)){
            this.name = "Walker";
        }
        else if (name.length()>100){
            this.name = "Walker";
        }
        else this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        if (!serialNumber.startsWith("SN") || serialNumber.length()>8) {

        } else this.serialNumber = serialNumber;
    }

    public void printInfo(){
        System.out.println("Name is " + name + ", serial number is " + serialNumber);
    }

    public static void main(String[] args) {
        SpaceShip ship = new SpaceShip();
        //System.out.println(ship.getName()); //Should be null
        //ship.setName("Walker");
        //System.out.println(ship.getName()); //Should be Walker
        ship.setName("Walker");
        /*System.out.println(ship.getName()); //Should be Walker

        ship.setName("");
        System.out.println(ship.getName()); //Should be Walker, empty value ignored

        ship.setName("Voyager ".repeat(100));
        System.out.println(ship.getName()); //Should be Walker, too long value ignored*/

        ship.setSerialNumber("SN506788");
        /*System.out.println(ship.getSerialNumber()); //Should be SN506788

        ship.setSerialNumber("EE123456");
        System.out.println(ship.getSerialNumber()); //Should be SN506788 - old value*/

        //Name is Voyager, serial number is SN504030
        ship.printInfo();
    }
}
