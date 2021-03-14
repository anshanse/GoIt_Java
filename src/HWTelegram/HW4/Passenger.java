package HWTelegram.HW4;

abstract class Passenger {
    public abstract String getType();

    public abstract int getTicketPrice();
}

class RegularPassenger extends Passenger{
    @Override
    public int getTicketPrice() {
        return 199;
    }

    @Override
    public String getType() {
        return "Regular";
    }
}

class VIPPassenger extends Passenger{
    @Override
    public String getType() {
        return "VIP";
    }

    @Override
    public int getTicketPrice() {
        return 399;
    }
}
