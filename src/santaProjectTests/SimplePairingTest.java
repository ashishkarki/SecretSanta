package santaProjectTests;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import santaProject.ISecretSanta;
import santaProject.SecretSantaFactory;

public class SimplePairingTest {
	ISecretSanta simplePairing;

	final String[] participants = new String[] { "Kyle", "Kenny", "Eric",
			"Stan", "Stewie", "Brian" };

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		simplePairing = SecretSantaFactory.getSecretSantaImplementation();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if no participant and his/her assignee are the same.
	 */
	@Test
	public void testGenerateAssignments() {

		final String[] assignments = simplePairing
				.generateAssignments(participants);

		for (int i = 0; i < participants.length; i++) {
			assertFalse("The participant must be different than assignee.",
					participants[i].equals(assignments[i]));
		}
	}

	/**
	 * Check if the solution is simply shifting the participants to their left
	 * or right.
	 */
	@Test
	public void testShiftLeftNRight() {
		final String[] assignments = simplePairing
				.generateAssignments(participants);

		// Shift the whole participants array to its left and check
		String[] leftRotatedAssignments = rotateLeft(assignments.clone());

		for (int i = 0; i < participants.length; i++) {
			assertFalse("The participant must be different than assignee.",
					participants[i].equals(leftRotatedAssignments[i]));
		}
	}

	/**
	 * @param arrayToRotateLeft
	 * @return array that is rotated (each element shifted) left
	 */
	public String[] rotateLeft(String[] arrayToRotateLeft) {
		String firstElem = arrayToRotateLeft[0];

		for (int i = 0; i < arrayToRotateLeft.length; i++) {
			arrayToRotateLeft[i] = arrayToRotateLeft[i + 1];
		}
		arrayToRotateLeft[arrayToRotateLeft.length] = firstElem;

		return arrayToRotateLeft;
	}

}
