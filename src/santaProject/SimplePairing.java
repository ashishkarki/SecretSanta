package santaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ASHISH KARKI_
 * 
 * @Description Follows Simple Pairing wherein each participant has been chosen
 *              one assignment/giftee based on randomization. Follows a check to
 *              ensure no LOGICAL_ERROR occur (i) no any (participant =
 *              assignment) (ii) The participants and their assignees are unique
 *              pair.
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
	public String[] generateAssignments(String[] participants) {
		// number of participants
		int n = participants.length;
		// our assignments
		String[] assignments = new String[n];
		// giftee/assignment index generated from each random generation cycle
		int gifteeIndex = 0;
		// The index of giftees who are already matched/paired
		List<Integer> alreadyPaired = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {

			// Check for LOGICAL_ERROR conditions
			// 1. A person is not assigned to him/herself
			// 2. The participants and their assignees are unique pair

			do {
				gifteeIndex = randomNoGenerator.nextInt(n);
			} while (gifteeIndex == i || alreadyPaired.contains(gifteeIndex));

			// assignments
			alreadyPaired.add(gifteeIndex);
			assignments[i] = participants[gifteeIndex];
		}

		return assignments;
	}
}
