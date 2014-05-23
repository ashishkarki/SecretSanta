package santaProject;

/**
 * @author ASHISH KARKI_
 * 
 * @Description All Pairing (of secret santa) implement this skeleton/blueprint
 * 
 */
public interface ISecretSanta {

	/**
	 * @param participants
	 *            people participating in the Secret Santa Draw.
	 * @return list of giftees, here called assignments. Each assignment is
	 *         matched with their participant in corresponding list index.
	 */
	public String[] generateAssignments(final String[] participants);

}
