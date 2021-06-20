package paket_92_reverzni_API;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
