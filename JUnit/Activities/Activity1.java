import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

    static ArrayList<String> list;

    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }


    @Test
    public void insertTest() {

        assertEquals(list.size(),2, "Wrong size");
        list.add(2, "gama");
        assertEquals(3, list.size(), "Wrong size");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gama", list.get(2), "Wrong element");
    }

// where is the 3rd element gama?
    @Test
    public void replaceTest() {
        assertEquals(2, list.size(), "Wrong size");
        list.add(2,"new element");
        assertEquals(3,list.size(),"Wrong size");
        list.set(1, "Meena");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("Meena", list.get(1), "Wrong element");
        assertEquals("new element", list.get(2), "Wrong element");
    }
}