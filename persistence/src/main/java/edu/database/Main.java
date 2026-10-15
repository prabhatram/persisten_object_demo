package edu.database;

public class Main {

    public static void main(String[] args) throws Exception {

        CustomerRepository repository = new CustomerRepository();

        //Create a Java object in memory
        Customer customer = new Customer(
            "Bob",
            "bob@example.com"
        );

        System.out.println("Before saving:");
        System.out.println(customer);

        //Persist the object's state
        repository.save(customer);

        System.out.println("After saving:");
        System.out.println(customer);

        // 3. Retrieve a new object from PostgreSQL
        Customer restored = repository.findById(customer.getId());

        System.out.println("Restored object:");
        System.out.println(restored);

        // 4. Compare object identities
        System.out.println("Same Java object? " + (customer == restored));
    }
}