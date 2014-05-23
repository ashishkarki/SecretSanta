package santaProject;

/**
 * @author ASHISH KARKI_
 * 
 * @Description Controls access to one of the implementations and displays result
 */
public class SecretSantaDemo {

	public SecretSantaDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/**
		 * Set of people participating in this draw.
		 */
		final String[] participants = new String[] { "Kyle", "Kenny", "Eric",
				"Stan", "Stewie", "Brian" };

		ISecretSanta mySecretSanta = SecretSantaFactory
				.getSecretSantaImplementation();
		final String[] assignments = mySecretSanta
				.generateAssignments(participants);

		printArray(assignments);
	}

	/**
	 * @param array
	 *            : array to be printed
	 */
	public static void printArray(String[] array) {
		System.out.println("The resulting assignment is:");
		for (String element : array) {
			System.out.print(element + ", ");
		}
	}

}
