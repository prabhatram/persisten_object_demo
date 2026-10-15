package edu.database;

public class Main {

    public static void main(String[] args) throws Exception {

        /* COMMENT THE FOLLOWING WHEN TESTING THE RESTORE FUNCTIONALITY */
        CustomerRepository repository = new CustomerRepository();
        
        Customer customer = new Customer(
            "Martha",
            "martha@example.com"
        );

        System.out.println("Before saving:");
        System.out.println(customer);

        
        repository.save(customer);

        System.out.println("After saving:");
        System.out.println(customer);

        
        // UNCOMMENT THE FOLLOWING LINES TO TEST THE RESTORE FUNCTIONALITY
        // DO IT ONLY AFTER RUNNING THE PROGRAM ONCE TO CREATE THE DATABASE RECORD
        // THEN CLOSE THE PROGRAM AND RUN IT AGAIN TO SEE THE RESTORE FUNCTIONALITY IN ACTION
        
        /* CustomerRepository repository = new CustomerRepository();
        Customer restored = repository.findById(1);

        System.out.println("Restored object:");
        System.out.println(restored); */

        /* THE FOLLOWING CODE TESTS THE UPDATE FUNCTIONALITY */
        /* CREATE AND PERSISTS AS MANY OBJECTS FIRST, AND THEN UNCOMMENT THE FOLLOWING LINES TO TEST THE UPDATE FUNCTIONALITY 
        CHANGE THE ID TO A DIFFERENT ONE, ONLY IF IT EXISTS IN THE DATABASE*/
        
        /* Customer restored = repository.findById(1);
        restored.changeEmail("alice.new@example.com");
        repository.update(restored);
        System.out.println("Updated: " + repository.findById(1)); */

        /* THE FOLLOWING CODE TESTS THE DELETE FUNCTIONALITY */
        /* CREATE AND PERSISTS AS MANY OBJECTS FIRST, AND THEN UNCOMMENT THE FOLLOWING LINES TO TEST THE DELETE FUNCTIONALITY 
        CHANGE THE ID TO A DIFFERENT ONE, ONLY IF IT EXISTS IN THE DATABASE */

        /* repository.delete(1);
        System.out.println("After deletion: " + repository.findById(1)); */
    }
}