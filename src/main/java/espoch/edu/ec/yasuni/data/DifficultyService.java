
package espoch.edu.ec.yasuni.data;

public class DifficultyService {

    public double simulateIncrease(double currentFactor, double percentage) {

        if (!Double.isFinite(currentFactor)
                || !Double.isFinite(percentage)
                || currentFactor <= 0
                || percentage < 0) {

            return currentFactor;
        }

        double newFactor = currentFactor * (1 + percentage / 100.0);

        if (!Double.isFinite(newFactor)) {
            return currentFactor;
        }

        return newFactor;
    }
}
