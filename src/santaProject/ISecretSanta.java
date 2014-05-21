package santaProject;

/**
 * @author ASHISH KARKI_
 * 
 * @Description All Pairing (of secret santa) implement this skeleton
 * 
 */
public interface ISecretSanta {

	/**
	 * Set of people participating in this draw.
	 */
	final String[] participants = new String[] { "Kyle", "Kenny", "Eric",
			"Stan", "Stewie", "Brian" };

	/**
	 * @param participants
	 *            people participating in the Secret Santa Draw.
	 * @return list of giftees, here called assignments. Each assignment is
	 *         matched with their participant in corresponding list index.
	 */
	public String[] generateAssignments(final String participants);

}
