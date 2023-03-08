package e2;

import e2.logics.Logics;
import e2.logics.LogicsImpl;
import e2.model.World;
import e2.model.WorldFactory;
import e2.model.WorldFactoryImpl;
import e2.model.WorldImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogicsTest {

    private WorldFactory worldFactory;
    private int size;

    @BeforeEach
    void beforeEach() {
        this.size = 10;
        this.worldFactory = new WorldFactoryImpl();
    }

    @Test
    void test() {

    }

}
