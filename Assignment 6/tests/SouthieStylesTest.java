import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SouthieStylesTest {

    @Test
    void testReplaceRWithH() {
        assertEquals("cah", SouthieStyles.replaceRWithH("car"));
        assertEquals("choppeh", SouthieStyles.replaceRWithH("chopper"));
        assertEquals("yakih", SouthieStyles.replaceRWithH("yakir"));
        assertEquals("jaws", SouthieStyles.replaceRWithH("jaws"));
        assertEquals("ABCDEFG", SouthieStyles.replaceRWithH("ABCDEFG"));
    }

    @Test
    void testAddRToA() {
        assertEquals("idear", SouthieStyles.addRToA("idea"));
        assertEquals("LUNAR", SouthieStyles.addRToA("LUNA"));
        assertEquals("tunar", SouthieStyles.addRToA("tuna"));
        assertEquals("cake", SouthieStyles.addRToA("cake"));
        assertEquals("yakir", SouthieStyles.addRToA("yakir"));
        assertEquals("hhaahhaabbaar", SouthieStyles.addRToA("hhaahhaabbaa"));
    }

    @Test
    void testVeryToWicked() {
        assertEquals("WICKED", SouthieStyles.veryToWicked("VERY"));
        assertEquals("wicked", SouthieStyles.veryToWicked("very"));
        assertEquals("wicked", SouthieStyles.veryToWicked("vErY"));
        assertEquals("yakir", SouthieStyles.veryToWicked("yakir"));
        assertEquals("programdesign", SouthieStyles.veryToWicked("programdesign"));
    }

    @Test
    void testRExceptions() {
        assertEquals("YAKIYAH", SouthieStyles.rExceptions("YAKIR"));
        assertEquals("dEeyah", SouthieStyles.rExceptions("dEer"));
        assertEquals("ssttrriinngg", SouthieStyles.rExceptions("ssttrriinngg"));
        assertEquals("doowah", SouthieStyles.rExceptions("door"));
        assertEquals("floowah", SouthieStyles.rExceptions("floor"));

    }


}