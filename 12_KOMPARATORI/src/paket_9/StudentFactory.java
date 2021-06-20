package paket_9;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
