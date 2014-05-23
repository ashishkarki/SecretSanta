package santaProject;

/**
 * @author ASHISH KARKI_
 * 
 * @Description Allows user to alter the type of Secret Santa Implementation
 *              that is called
 * 
 */
public class SecretSantaFactory {

	// Can call any one of the Implementations
	public static ISecretSanta getSecretSantaImplementation() {
		// return new SimplePairing();
		return new ShufflePairing();
	}
}
