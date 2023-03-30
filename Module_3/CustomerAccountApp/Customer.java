public class Customer {
    private String name;
    private String address;
    private String city;
    private String zip;

    // no-argument constructor
    public Customer() {
        this.name = "Default";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    // argument constructor
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // accessor methods
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getZip() {
        return this.zip;
    }

    // override the toString() method
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Address: " + this.address + "\n" +
                "City: " + this.city + "\n" +
                "Zip: " + this.zip;
    }
}
