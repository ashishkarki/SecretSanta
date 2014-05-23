package santaProjectTests;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import santaProject.ISecretSanta;
import santaProject.SecretSantaFactory;

public class SecretSantaTest {
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
	public void testParticipantVsAssignee() {

		final String[] assignments = simplePairing
				.generateAssignments(participants);
		printArray(assignments);

		assertThat("The participant must be different than assignee.",
				participants, not(assignments));
	}

	/**
	 * Check if the solution is simply shifting the participants to their left
	 * or right.
	 */
	@Test
	public void testShiftLeftNRight() {
		final String[] assignments = simplePairing
				.generateAssignments(participants);
		printArray(assignments);

		// Shift the whole participants array to its left and check
		String[] leftRotatedAssignments = rotateLeft(participants.clone());

		assertThat("Shiting names left is not acceptable solution.",
				assignments, not(leftRotatedAssignments));

		// Shift the whole participants array to its right and check
		String[] rightRotatedAssignments = rotateRight(participants.clone());

		assertThat("Shiting names right is not acceptable solution.",
				assignments, not(rightRotatedAssignments));
	}

	/**
	 * This checks that no two assignments are the same person.
	 */
	@Test
	public void testAssignmentsAreUnique() {
		final String[] assignments = simplePairing
				.generateAssignments(participants);
		printArray(assignments);

		// Assume there may be duplicate elements, put them in a Set
		Set<String> assignmentsSet = new LinkedHashSet<String>(
				Arrays.asList(assignments));

		// If these two are still same, then all elements are still unique
		Assert.assertArrayEquals("All assignment have to be unique.",
				assignments, assignmentsSet.toArray());
	}

	/**
	 * @param arrayToRotateLeft
	 * @return array that is rotated (each element shifted) left
	 */
	public String[] rotateLeft(String[] arrayToRotateLeft) {
		String firstElem = arrayToRotateLeft[0];

		for (int i = 0; i < arrayToRotateLeft.length - 2; i++) {
			arrayToRotateLeft[i] = arrayToRotateLeft[i + 1];
		}
		arrayToRotateLeft[arrayToRotateLeft.length - 1] = firstElem;

		return arrayToRotateLeft;
	}

	/**
	 * @param arrayToRotateRight
	 * @return array that is rotated (each element shifted) right
	 */
	public String[] rotateRight(String[] arrayToRotateRight) {
		String lastElem = arrayToRotateRight[arrayToRotateRight.length - 1];

		for (int i = 0; i < arrayToRotateRight.length - 2; i++) {
			arrayToRotateRight[i + 1] = arrayToRotateRight[i];
		}
		arrayToRotateRight[0] = lastElem;

		return arrayToRotateRight;
	}

	/**
	 * @param array
	 *            : array to be printed out using for loop
	 */
	public static void printArray(String[] array) {
		System.out.println("The resulting assignment is:");
		for (String element : array) {
			System.out.print(element + ", ");
		}
		System.out.println("\n********************************");
	}
}
