
package espoch.edu.ec.yasuni.objects;

public abstract class Tour {

    private String code;
    private String name;
    private Trail[] severalTrails;

    private Guide guide;
    private CommunicationDevice device;

    private double difficultyFactor;

    private static final int MAX_TRAILS = 10;

    public Tour(String code, String name) {
        this.code = code;
        this.name = name;
        this.severalTrails = new Trail[MAX_TRAILS];
        this.difficultyFactor = 1.0;
    }

    // Getters y setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Devuelve una copia del arreglo
    public Trail[] getSeveralTrails() {
        Trail[] copy = new Trail[severalTrails.length];

        for (int i = 0; i < severalTrails.length; i++) {
            copy[i] = severalTrails[i];
        }

        return copy;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public CommunicationDevice getDevice() {
        return device;
    }

    public void setDevice(CommunicationDevice device) {
        this.device = device;
    }

    public double getDifficultyFactor() {
        return difficultyFactor;
    }

    public void setDifficultyFactor(double difficultyFactor) {
        if (difficultyFactor > 0
                && Double.isFinite(difficultyFactor)) {
            this.difficultyFactor = difficultyFactor;
        }
    }

    // Agregar sendero
    public boolean addTrail(Trail trail) {

        if (trail == null) {
            return false;
        }

        for (int i = 0; i < severalTrails.length; i++) {
            if (severalTrails[i] == trail) {
                return false;
            }
        }

        for (int i = 0; i < severalTrails.length; i++) {

            if (severalTrails[i] == null) {

                if (!trail.assignTo(this)) {
                    return false;
                }

                severalTrails[i] = trail;
                return true;
            }
        }

        return false;
    }

    // Calcular distancia total
    public double calculateDistance() {

        double total = 0;

        for (int i = 0; i < severalTrails.length; i++) {

            if (severalTrails[i] != null
                    && severalTrails[i].isEnabled()) {

                total += severalTrails[i].getLengthTrail();
            }
        }

        return total;
    }

    // Calcular tiempo de caminata
    public double calculateWalkingTime() {

        double total = 0;

        for (int i = 0; i < severalTrails.length; i++) {

            if (severalTrails[i] != null
                    && severalTrails[i].isEnabled()) {

                total += severalTrails[i].getTime();
            }
        }

        return total * difficultyFactor;
    }

    // Cerrar sendero
    public boolean closeTrail(Trail trail) {

        if (trail == null
                || trail.getOwner() != this
                || !trail.isEnabled()) {
            return false;
        }

        for (int i = 0; i < severalTrails.length; i++) {

            if (severalTrails[i] == trail) {
                trail.disable();
                return true;
            }
        }

        return false;
    }

    // Método abstracto
    public abstract double calculateDuration();
}
