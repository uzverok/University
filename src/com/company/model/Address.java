package Students.model;

public class Address {
    private String city;
    private String street;
    private int house_number;
    private int flat_number;

    public Address(String city, String street, int house_number, int flat_number){
        this.city = city;
        this.street = street;
        setHouseNumber(house_number);
        setFlatNumber(flat_number);
    }
    Address(String city, String street, int house_number){
        this.city = city;
        this.street = street;
        setHouseNumber(house_number);
    }
    void setHouseNumber(int house_number){
        if (house_number > 0) {
            this.house_number = house_number;
        }

    }
    void setFlatNumber(int flat_number){
        if (flat_number > 0) {
            this.flat_number = flat_number;
        }

    }
//    String getAddress(){
//        return (this.city+", "+this.street+", "+this.house_number+((this.flat_number!=0)?("-"+this.flat_number):("")));
//    }

    @Override
    public String toString() {
        return "Адрес{" +
                "город='" + city + '\'' +
                ", улица='" + street + '\'' +
                ", дом=" + house_number +
                ((this.flat_number!=0)?(", квартира=" + flat_number):(""))+
                '}';
    }
}
