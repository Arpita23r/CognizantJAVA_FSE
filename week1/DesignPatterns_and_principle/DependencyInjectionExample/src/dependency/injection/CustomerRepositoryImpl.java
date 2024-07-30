package dependency.injection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        return new Customer(id, "Arpita");
    }
}
