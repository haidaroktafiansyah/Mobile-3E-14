package org.aplas.basicappx;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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

public class TestA1BasicUIX061 extends ViewTest {
    private MainActivity activity;
    private RelativeLayout mainLayout;
    private LinearLayout layout;

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
        mainLayout = (RelativeLayout) activity.findViewById(compId);
        layout = (LinearLayout) mainLayout.getChildAt(4);
    }

    private void checkCompletion() throws NullPointerException, ClassCastException {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(androidx.appcompat.widget.AppCompatCheckBox.class); //Element 1
        elements.add(androidx.appcompat.widget.AppCompatCheckBox.class);  //Element 2
        /************************/

        //JUnit Test
        int prevElement = 0;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_ChildLayout_Properties() throws Exception { //Check Button Specification
        //Component properties value
        LinearLayout component = layout;
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("child2");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.HORIZONTAL);
        comp.testTopMargin(11);
        comp.testLayoutBelow(mainLayout.getChildAt(3).getId());
    }

    @Test
    public void check_02_Checkbox_Properties() { //Check Layout Specification
        //Preprocessing
        CheckBox component = (CheckBox) layout.getChildAt(0);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("chkRounded");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testTextString("Rounded");
        comp.testTextSize((float)18);
        comp.testGravity(Gravity.CENTER);
        comp.testSelected(true);
    }

    @Test
    public void check_03_Checkbox_Properties() { //Check Layout Specification
        //Preprocessing
        CheckBox component = (CheckBox) layout.getChildAt(1);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("chkFormula");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testTextString("Show Formula");
        comp.testTextSize((float)18);
        comp.testGravity(Gravity.CENTER);
        comp.testSelected(false);
    }
}
