package santaProject;

import java.util.Random;

/**
 * @author ASHISH KARKI_
 * 
 * @Description Follows Simple Pairing wherein each participant has been chosen
 *              one assignment/giftee based on randomization. Follows a check to
 *              ensure no LOGICAL_ERROR occur (i) no any (participant =
 *              assignment) (ii) there is no left or right shift of names
 */
public class SimplePairing implements ISecretSanta {

	/**
	 * Generates a random number to pair participant with assignments
	 */
	Random randomNoGenerator;

	// Default: we are using a factory method
	SimplePairing() {
		randomNoGenerator = new Random();
	}

	@Override
	public String[] generateAssignments(String participants) {
		// number of participants
		int n = participants.length();
		// our assignments
		String[] assignments = new String[n];
		// giftee/assignment index generated from each random generation cycle
		int gifteeIndex = 0;
		// Index of the participant to the left of current participant
		int left = -1;
		// Index of the participant to the right of current participant
		int right = -1;

		for (int i = 0; i < n; i++) {
			gifteeIndex = randomNoGenerator.nextInt(n);

			// Check for LOGICAL_ERROR conditions
			// 1. A person is not assigned to him/herself
			// 2. Check the assignee is not simply the participant to left/right
			left = (i == 0) ? n - 1 : i - 1;
			right = (i == n - 1) ? 0 : i + 1;
			if (gifteeIndex == i || gifteeIndex == left || gifteeIndex == right) {
				gifteeIndex = randomNoGenerator.nextInt(n);
			}

			// assignments
			assignments[i] = ISecretSanta.participants[gifteeIndex];
		}

		return assignments;
	}

}
