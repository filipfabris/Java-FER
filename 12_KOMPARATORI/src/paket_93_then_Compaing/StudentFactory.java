package paket_93_then_Compaing;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
