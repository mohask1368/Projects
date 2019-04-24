
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestMyMath {

@Test
    public void testMultiply(){

    MyMath math = MyMath.getInstance();

    assertEquals(math.multiply(3,4),12);


}


}
