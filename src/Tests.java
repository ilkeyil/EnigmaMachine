import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testEncrypt1() {
        Machine m = new Machine(Main.r1_left, Main.r1_middle, Main.r1_right, Main.refB);
        int encrypted = m.encrypt(6);
        int expected = 7;
        Assertions.assertEquals(encrypted, expected);
    }

    @Test
    public void testEncrypt2() {
        Machine m = new Machine(Main.r2_left, Main.r2_middle, Main.r2_right, Main.refB);
        int encrypted = m.encrypt(6);
        int expected = 21;
        Assertions.assertEquals(encrypted, expected);
    }

    @Test
    public void testEncrypt3() {

    }

    @Test
    public void testEncrypt4() {

    }

    @Test
    public void testEncrypt5() {

    }

    @Test
    public void testEncrypt6() {

    }

    @Test
    public void testEncrypt7() {

    }

    @Test
    public void testEncrypt8() {

    }

    @Test
    public void testEncrypt9() {

    }

    @Test
    public void testEncrypt10() {

    }
}