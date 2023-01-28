import JUnitTest.HelloWorld;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void should_return_world_as_string() {
        System.out.println( HelloWorld.hello());
    }
    @Test
    public void should_return_world_as_string2() {
        Assert.assertEquals("Hello, world!", HelloWorld.hello());
    }
    @Test
    public void assert_array_equals() {
        int[] input = {1, 2, 5, 7, 0};
        Arrays.sort(input);

        int[] expected = {0, 1, 2, 5, 7};
        assertArrayEquals("expected array should be sorted",expected, input);
    }
    @Test
    public void assert_not_null() {
        assertNotNull("should not be null", Integer.valueOf("10"));
    }
    @Test
    public void should_be_same() {
        assertSame(Runtime.getRuntime(), Runtime.getRuntime());
    }
    public static String helloAndNow() {
        return "Hello, world!" + System.currentTimeMillis();
    }

    @Test
    public void should_start_with_hello() {
        assertThat(helloAndNow(), startsWith("Hello"));
    }
}
