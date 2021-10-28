package P3;

import P2.turtle.TurtleSoup;
import org.junit.Test;

import static org.junit.Assert.*;

public class FriendshipGraphTest {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }

    @Test
    public void getDistanceTest() {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);
        graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);
        assertEquals(1, graph.getDistance(rachel, ross), 0.001);
        assertEquals(2, graph.getDistance(rachel, ben), 0.001);
        assertEquals(0, graph.getDistance(rachel, rachel), 0.001);
        assertEquals(-1, graph.getDistance(rachel, kramer), 0.001);
    }
}