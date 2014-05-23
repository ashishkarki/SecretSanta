package santaProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ASHISH KARKI_
 * @Description Pairing based on shuffling of participants (after remove the
 *              current participant). Uses Java's Collection.shuffle method.
 */
public class ShufflePairing implements ISecretSanta {

	ShufflePairing() {
	}

	@Override
	public String[] generateAssignments(String[] participants) {
		// number of participants
		int n = participants.length;
		// assignments
		String[] assignments = new String[n];

		// Create ArrayList copy of participants for easy manipulation
		ArrayList<String> participantsList = new ArrayList<String>(
				Arrays.asList(participants));
		ArrayList<String> assignmentsList = (ArrayList<String>) participantsList
				.clone();

		for (int i = 0; i < participants.length; i++) {
			Collections.shuffle(assignmentsList);

			assignments[i] = assignmentsList.get(0);
			// if its the same person, move the index by one
			if (participants[i].equals(assignments[0])) {
				assignments[i] = assignmentsList.get(1);
			}
		}

		return assignments;
	}

}
