
package espoch.edu.ec.yasuni.objects;

public class InterpretiveTour extends Tour {

    private double educationalTime;

    public InterpretiveTour(String code, String name, double educationalTime) {
        super(code, name);
        setEducationalTime(educationalTime);
    }

    public double getEducationalTime() {
        return educationalTime;
    }

    public void setEducationalTime(double educationalTime) {

        if (educationalTime >= 0
                && Double.isFinite(educationalTime)) {
            this.educationalTime = educationalTime;
        }
    }

    @Override
    public double calculateDuration() {
        return calculateWalkingTime() + educationalTime;
    }
}
