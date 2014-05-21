package santaProject;

/**
 * @author ASHISH KARKI_
 * 
 * @Description Allows user to alter the type of Secret Santa Implementation
 *              that is called
 * 
 */
public class SecretSantaFactory {

	public SecretSantaFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ISecretSanta getSecretSantaImplementation() {
		return new SimplePairing();
	}
}
