package paket_4;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
