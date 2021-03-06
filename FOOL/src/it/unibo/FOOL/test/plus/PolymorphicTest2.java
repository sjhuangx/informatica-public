/**
 * An bytecode compiler and interpreter for FOOL+ language in Java/ANTLR
 * 
 * Course project for COMPILATORI E INTERPRETI (ANALISI STATICA DI PROGRAMMI)
 * Copyright(R) 2017  Chun Tian, University of Bologna
 */

package it.unibo.FOOL.test.plus;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unibo.FOOL.test.*;

/*
 * Polymorphic Type Test #2: classic multimethods with boxing of primitive types
 */

public final class PolymorphicTest2 extends UnitTest {
    @Test
    public void testPolymorphicType2() {
	prog = "   class A = object end;				\n"
		+ "class B = object inherit A; end;			\n"
		+ "let int foo(A o1, A o2, int x) 1+x;			\n"
		+ "    int foo(A o1, B o2, int x) 2+x;			\n"
		+ "    int foo(B o1, A o2, int x) 3+x;			\n"
		+ "    int foo(B o1, B o2, int x) 4+x;			\n"
		+ "    A obj = new B();					\n"
		+ "in obj.foo(obj, 6);					\n";
	result = 10;
	trace = true;
	assertEquals(run(), result);
    }
}
