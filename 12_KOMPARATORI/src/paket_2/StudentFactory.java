package paket_2;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
