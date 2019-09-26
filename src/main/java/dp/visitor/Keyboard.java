package dp.visitor;

public class Keyboard implements Visitable {
    private String id;

    public Keyboard(String id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "id='" + id + '\'' +
                '}';
    }
}
