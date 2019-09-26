package algos.hackerrank.dc;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.Objects;

public class SuperHashMapTest {
    private static Key[] key = new Key[109999];
    private static Value[] value = new Value[109999];

    @BeforeClass
    public static void setUp() {
        setUpKv();
    }

    private static void setUpKv() {
        for (int i = 1; i < 110000; i++) {
            key[i - 1] = new Key(i);

        }
        for (int i = 1; i < 110000; i++) {
            value[i - 1] = new Value("test_" + i);

        }
    }

    @Test
    public void sizeTest() {
    }

    @Test
    public void putTest() {
      //  Stopwatch stopwatch = new Stop();
        SuperHashMap<Key, Value> keyValueSuperHashMap = new SuperHashMap<>();
        for (int i = 0; i < 109999; i++) {
            keyValueSuperHashMap.put(key[i], value[i]);
        }
        System.out.println("start getting");
        int i = 0;
        for (Key key : key) {
            i++;
            Assert.assertEquals(key + " validating " + new Value("test_" + i), new Value("test_" + i), keyValueSuperHashMap.get(key));
        }
    }

    private static class Key {
        private int a;

        public Key(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return a == key.a;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "a=" + a +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }
    }

    private static class Value {
        private String id;

        public Value(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Value)) return false;
            Value value = (Value) o;
            return Objects.equals(id, value.id);
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}