
package espoch.edu.ec.yasuni.objects;

public class Guide {

    private String cardId;
    private String name;
    private boolean available;

    public Guide(String cardId, String name, boolean available) {
        this.cardId = cardId;
        this.name = name;
        this.available = available;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
