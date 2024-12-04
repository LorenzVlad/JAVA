package fsm;

import com.example.fsm.FiniteStateMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FiniteStateMachineTest {

    @Test
    void testValidSequence() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        assertEquals("F", fsm.process("abcTESTabc"));
        assertEquals("F", fsm.process("TEST"));
    }

    @Test
    void testIncompleteSequence() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        assertEquals("3", fsm.process("abcTES"));
        assertEquals("S", fsm.process("TESabcT"));
    }

    @Test
    void testEdgeCases() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        assertEquals("S", fsm.process("TESET")); // Неправильна послідовність
        assertEquals("S", fsm.process("TESST")); // Зайвий символ
        assertEquals("F", fsm.process("TTEST")); // Додатковий T, але рядок коректний
        assertEquals("S", fsm.process("TEEST")); // Зайвий E
    }

    @Test
    void testEmptyInput() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        assertEquals("S", fsm.process(""));
    }
}
