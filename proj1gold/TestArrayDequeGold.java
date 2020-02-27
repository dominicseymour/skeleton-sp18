import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {

    String message = "";

    @Test
    public void randomTest() {

        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        while (true) {

            double randomNumber = StdRandom.uniform();

            if (randomNumber < 0.25) {
                randomAddFirst(student, solution);

            } else if (randomNumber < 0.5) {
                randomAddLast(student, solution);

            } else if (randomNumber < 0.75 && !student.isEmpty()) {
                randomRemoveFirst(student, solution);

            } else if (!student.isEmpty()) {
                randomRemoveLast(student, solution);
            }
        }

    }

    private void randomAddFirst(StudentArrayDeque<Integer> student, ArrayDequeSolution<Integer> solution) {

        Integer randomNumber = StdRandom.uniform(9);

        student.addFirst(randomNumber);
        solution.addFirst(randomNumber);

        message += "\naddFirst(" + randomNumber + ")";
    }

    private void randomAddLast(StudentArrayDeque<Integer> student, ArrayDequeSolution<Integer> solution) {

        Integer randomNumber = StdRandom.uniform(9);

        student.addLast(randomNumber);
        solution.addLast(randomNumber);

        message += "\naddLast(" + randomNumber + ")";
    }

    private void randomRemoveFirst(StudentArrayDeque<Integer> student, ArrayDequeSolution<Integer> solution) {

        Integer actual = student.removeFirst();
        Integer expected = solution.removeFirst();

        message += "\nremoveFirst()";

        Assert.assertEquals(message, expected, actual);
    }

    private void randomRemoveLast(StudentArrayDeque<Integer> student, ArrayDequeSolution<Integer> solution) {

        Integer actual = student.removeLast();
        Integer expected = solution.removeLast();

        message += "\nremoveLast()";

        Assert.assertEquals(message, expected, actual);
    }
}
