import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void randomTest() {

        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        int i = 0;
        String message = "";
        while (true) {

            double randomNumber = StdRandom.uniform();

            if (randomNumber < 0.25) {
                student.addFirst(i);
                solution.addFirst(i);
                message += "\naddFirst(" + i + ")";

            } else if (randomNumber < 0.5) {
                student.addLast(i);
                solution.addLast(i);
                message += "\naddLast(" + i + ")";

            } else if (randomNumber < 0.75 && !student.isEmpty()) {
                student.removeFirst();
                solution.removeFirst();
                message += "\nremoveFirst(" + i + ")";

            } else if (!student.isEmpty()) {
                student.removeLast();
                solution.removeLast();
                message += "\nremoveLast(" + i + ")";
            }

            for (int j = 0; j < student.size(); j++) {

                Assert.assertEquals(message, student.get(j), solution.get(j));
            }

            i++;
        }

    }
}
