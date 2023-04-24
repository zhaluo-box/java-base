import com.example.learn.pattern.builder.BenzBuilder;
import com.example.learn.pattern.builder.BenzModel;
import com.example.learn.pattern.builder.BwmBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternTest {

    private static final List<String> sequenceList = new ArrayList<>();

    @BeforeEach
    public void before() {
        sequenceList.add("stop");
        sequenceList.add("start");
        sequenceList.add("engine boom");
    }

    @Test
    public void test1() {
        final BenzModel benzModel = new BenzModel(sequenceList, "奔驰");
        benzModel.run();
    }

    @Test
    public void test2() {
        final BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequenceList);
        benzBuilder.getCarModel().run();
    }

    @Test
    public void test3() {
        final BwmBuilder benzBuilder = new BwmBuilder();
        benzBuilder.setSequence(sequenceList);
        benzBuilder.getCarModel().run();
    }
}
