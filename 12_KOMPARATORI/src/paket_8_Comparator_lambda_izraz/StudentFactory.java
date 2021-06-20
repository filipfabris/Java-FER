package paket_8_Comparator_lambda_izraz;

public interface StudentFactory<S> {
	S create(String lastName, String firstName, String studentID);

}
