package org.aplas.basicappx;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestA1BasicUIX041 extends ViewTest {
    private MainActivity activity;
    private RelativeLayout layout;

    @Before
    public void initTest() {
        startActivity();
        checkCompletion();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MainActivity.class).create().get();

        //Load layout
        int compId = activity.getResources().getIdentifier(layoutName, "id", activity.getPackageName());
        layout = (RelativeLayout) activity.findViewById(compId);
    }

    private void checkCompletion() throws NullPointerException, ClassCastException {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(Space.class); //Element 1
        elements.add(LinearLayout.class);  //Element 2
        /************************/

        //JUnit Test
        int prevElement = 2;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_Space_Properties() { //Check Layout Specification
        //Component properties value
        int compIdx = 2;
        Space component = (Space) layout.getChildAt(compIdx);
        ElementTest comp = new ElementTest(component);

        //Test each item
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(11);
        comp.testLayoutBelow(layout.getChildAt(compIdx-1).getId());
    }

    @Test
    public void check_02_ChildLayout_Properties() throws Exception { //Check Button Specification
        //Component properties value
        int compIdx=3;
        LinearLayout component = (LinearLayout) layout.getChildAt(compIdx);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("child1");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.HORIZONTAL);
        comp.testLayoutBelow(layout.getChildAt(compIdx-1).getId());
    }

}
