
package espoch.edu.ec.yasuni.objects;

public class Trail {

    private String name;
    private double lengthTrail;
    private double time;
    private boolean enabled;
    private Tour owner;

    public Trail(String name, double lengthTrail, double time) {
        this.name = name;
        this.lengthTrail = lengthTrail;
        this.time = time;
        this.enabled = true;
        this.owner = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLengthTrail() {
        return lengthTrail;
    }

    public void setLengthTrail(double lengthTrail) {
        if (lengthTrail >= 0 && Double.isFinite(lengthTrail)) {
            this.lengthTrail = lengthTrail;
        }
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        if (time >= 0 && Double.isFinite(time)) {
            this.time = time;
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Tour getOwner() {
        return owner;
    }

    // Asignar sendero a un único tour
    boolean assignTo(Tour tour) {

        if (tour == null || owner != null) {
            return false;
        }

        owner = tour;
        return true;
    }

    // Deshabilitar sendero
    void disable() {
        enabled = false;
    }
}
