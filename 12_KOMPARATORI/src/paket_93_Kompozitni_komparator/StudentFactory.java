package paket_93_Kompozitni_komparator;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
