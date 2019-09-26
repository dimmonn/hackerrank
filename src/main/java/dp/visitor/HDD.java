package dp.visitor;

public class HDD implements Visitable {

    private String id;

    public HDD(String id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "HDD{" +
                "id='" + id + '\'' +
                '}';
    }
}
