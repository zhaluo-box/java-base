import com.example.learn.pattern.builder.BenzBuilder;
import com.example.learn.pattern.builder.BenzModel;
import com.example.learn.pattern.builder.BwmBuilder;
import com.example.learn.pattern.builder.CarBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final  List<String> sequenceList =  new ArrayList<>(  );;

    @Before
    public void before(){
        sequenceList.add( "stop" );
        sequenceList.add( "start" );
        sequenceList.add( "engine boom" );
    }


    @Test
    public  void test1() {
        final BenzModel benzModel = new BenzModel(sequenceList, "奔驰" );
        benzModel.run();
    }


    @Test
    public  void test2(){
        final BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence( sequenceList );
        benzBuilder.getCarModel().run();
    }

    @Test
    public  void test3(){
        final BwmBuilder benzBuilder = new BwmBuilder();
        benzBuilder.setSequence( sequenceList );
        benzBuilder.getCarModel().run();
    }
}
