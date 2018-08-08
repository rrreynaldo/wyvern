package wyvern.tools.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import wyvern.target.corewyvernIL.expression.Value;
import wyvern.tools.REPL;
import wyvern.tools.parsing.coreparser.ParseException;

public class ReplTests {
    private REPL repl = new REPL();

    @Test
    public void testIdentityREPL() throws ParseException {
        repl.interpretREPL("reset");
        String input = "((x: Int) => x)(3)";
        String v = repl.interpretREPL(input);
        // REPL.interpret("exit");
        assertEquals(v, "3");
    }

    @Test
    public void testVarREPL() throws ParseException {
        repl.interpretREPL("reset");
        String input = "var y:Int = 5";
        String input1 = "y";
        repl.interpretREPL(input);
        String v = repl.interpretREPL(input1);
        assertEquals(v, "5");
    }

    @Test
    public void testValREPL() throws ParseException {
        repl.interpretREPL("reset");
        String input = "val v = 6";
        String input1 = "v";
        repl.interpretREPL(input);
        String v = repl.interpretREPL(input1);
        assertEquals(v, "6");
    }

    @Test
    public void testFunction() throws ParseException {
        repl.interpretREPL("reset");
        String input = "def factorial(n:Int):Int";
        String input1 = "   (n < 2).ifTrue(";
        String input2 = "       () => 1,";
        String input3 = "       () => n * factorial(n-1)";
        String input4 = ")";
        repl.interpretREPL(input);
        repl.interpretREPL(input1);
        repl.interpretREPL(input2);
        repl.interpretREPL(input3);
        repl.interpretREPL(input4);
        String v = repl.interpretREPL("factorial(6)");
        assertEquals(v, "720");
    }

    @Test
    public void testVarVal() throws ParseException {
        repl.interpretREPL("reset");
        String input = "var c:Int = 33";
        String input1 = "val v = 22";
        repl.interpretREPL(input);
        repl.interpretREPL(input1);
        String v = repl.interpretREPL("c");
        String v1 = repl.interpretREPL("v");
        assertEquals(v, "33");
        assertEquals(v1, "22");
    }

    @Test
    public void testValVar() throws ParseException {
        repl.interpretREPL("reset");
        String input = "var c:Int = 33";
        String input1 = "val v = 22";
        repl.interpretREPL(input);
        repl.interpretREPL(input1);
        String v = repl.interpretREPL("c");
        String v1 = repl.interpretREPL("v");
        assertEquals(v, "33");
        assertEquals(v1, "22");
    }

}
