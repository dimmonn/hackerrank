package dp.visitor;

public class Monitor implements Visitable {
    private String id;

    public Monitor(String id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id='" + id + '\'' +
                '}';
    }
}
