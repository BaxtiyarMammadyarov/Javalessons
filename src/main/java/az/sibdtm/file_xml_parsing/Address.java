package az.sibdtm.file_xml_parsing;

public class Address {
    private String city;
    private String region;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public Address(String city, String region) {
        this.city = city;
        this.region = region;
    }
}

