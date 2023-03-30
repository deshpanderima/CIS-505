public class CustomerDB {
    public static Customer getCustomer(Integer id) {
        Customer customer;
        if (id == 1007) {
            customer = new Customer("Jennifer Patterson", "8422 Grover Ave.", "Bellevue", "68123");
        } else if (id == 1008) {
            customer = new Customer("Hans Klopek", "6693 Agatha Christie Way", "Los Angeles", "90038");
        } else if (id == 1009) {
            customer = new Customer("Ray Peterson", "6671 Bonnie Brae", "Mayfield Place", "44124");
        } else {
            customer = new Customer("Default", "", "", "");
        }
        return customer;
    }
}
