public class Sock {

    int id;
    String color;
    boolean isLeft;

    public Sock(int id, String color, boolean isLeft) {
        this.id = id;
        this.color = color;
        this.isLeft = isLeft;
    }

    @Override
    public String toString() {
        return "Sock{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", isLeft=" + isLeft +
                '}';
    }
}
