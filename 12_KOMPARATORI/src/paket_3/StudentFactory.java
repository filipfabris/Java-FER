package paket_3;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
