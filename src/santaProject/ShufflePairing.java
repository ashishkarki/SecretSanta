package santaProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author ASHISH KARKI_
 * @Description Pairing based on shuffling of participants (after remove the
 *              current participant). Uses Java's Collection.shuffle method.
 */
public class ShufflePairing implements ISecretSanta {

	@Override
	public String[] generateAssignments(String[] participants) {
		// number of participants
		int n = participants.length;
		// assignments
		String[] assignments = new String[n];

		// Create ArrayList copy of participants for easy manipulation
		ArrayList<String> assignmentsList = new ArrayList<String>(
				Arrays.asList(participants));

		int assigneeIndex = -1;
		
		/*
		 * During each loop, we shuffle the assignmentsList, choose member 0 as
		 * our assignee. If it is the same person, just move the assignee index
		 * to 1.
		 */
		for (int i = 0; i < participants.length; i++) {
			Collections.shuffle(assignmentsList);

			assigneeIndex = 0;
			// If its the same person, move the index by one
			if (participants[i].equals(assignmentsList.get(assigneeIndex))) {
				assigneeIndex++;
			}
			assignments[i] = assignmentsList.get(assigneeIndex);

			// Remove the new assignee from assignments arraylist
			assignmentsList.remove(assigneeIndex);
		}

		return assignments;
	}

}
