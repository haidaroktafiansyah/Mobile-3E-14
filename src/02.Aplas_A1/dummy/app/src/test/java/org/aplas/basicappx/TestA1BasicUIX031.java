package org.aplas.basicappx;

import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

public class TestA1BasicUIX031 extends ViewTest {
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
        elements.add(androidx.appcompat.widget.AppCompatTextView.class); //Element 1
        elements.add(androidx.appcompat.widget.AppCompatButton.class);  //Element 2
        /************************/
        int prevElement = 0;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_Layout_Specification() { //Check Layout Specification
        //Component properties value
        ElementTest comp = new ElementTest(layout);

        //Test each item
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testPaddingLeft(5);
        comp.testPaddingRight(5);
        comp.testBgColor(-16728065);
    }

    @Test
    public void check_02_TextView_Properties() { //Check Layout Specification
        //Preprocessing
        Typeface compStyle = Typeface.create("fonts/cambria.ttf", Typeface.BOLD);
        TextView component = (TextView) layout.getChildAt(0);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("myTextView1");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(67);
        comp.testTextString("Unit Converter");
        comp.testTextFace(compStyle);
        comp.testTextStyle(compStyle.getStyle());
        comp.testTextColor(-16777216);
        comp.testTextSize(31);
        comp.testGravity(Gravity.CENTER);
    }

    @Test
    public void check_03_Button_Properties() throws Exception { //Check Button Specification
        //Preprocessing
        int compIdx = 1;
        Typeface compStyle = Typeface.create("fonts/lucida.ttf", Typeface.NORMAL);
        Button component = (Button) layout.getChildAt(compIdx);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("convertButton");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(44);
        comp.testTextString("Convert");
        comp.testTextFace(compStyle);
        comp.testTextStyle(compStyle.getStyle());
        comp.testTextColor(-16777216);
        comp.testTextSize(24);
        comp.testBgColor(-23296);
        //comp.testAllCaps(false);
        comp.testLayoutBelow(layout.getChildAt(compIdx-1).getId());
    }
}
