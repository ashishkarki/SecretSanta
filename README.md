SECRET SANTA PROJECT (Ashish Karki)
--------------------------------
<br>

Implementation
-------------

1. <b>ISecretSanta</b> interface is used as a blueprint to implement two simple algorithms. There are two class files named: <b>SimplePairing</b> and <b>ShufflePairing</b>, both of which implement ISecretSanta. Each class file has their version of generateAssignments() method.
2. Class <b>SimplePairing</b> uses Random class from Java to randomly choose an assignment/assignee/giftee for a particular participant. 
3. Class <b>ShufflePairing</b> uses Collection.shuffle() to shuffle assignmentsList. AssignmentsList is simply a ArrayList copy of participants array.
4. Both implementations also ensures that: 
    + No participant is same as his/her assignee.  
    + The participants and their assignees are unique. 
    + It also logically follows that all the assignments are from the list of passed participants.
5. A factory class called <b>SecretSantaFactory</b> is also defined. This class has a static factory method that is responsible for creating and returning one of the Secret Santa concrete classes. Using such design has the advantage of choosing any specific implementation as per requirement. The JUnit test class also utilizes this factory method to test the current implementation.
<br>

Unit Testing
------------
1. Unit testing is performed using JUnit framework.
2. A single test class is kept in the package <b>santaProjectTests</b> within the source folder. The test class is called <b>SecretSantaTest</b>. SecretSantaTest contains three different tests to check for the following cases:
    + No participant is same as his/her assignment.
    + The assignments are not simple left or right rotation of the participants.
    + All assignments are unique, that is, no two assignees are the same.

