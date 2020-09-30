package org.aplas.basicappx;

import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class TestA1BasicUIX071 extends ViewTest {
    private MainActivity activity;
    private RelativeLayout mainLayout;
    private RadioGroup layout;

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
        layout =  (RadioGroup) mainLayout.getChildAt(5);
    }

    private void checkCompletion() throws NullPointerException, ClassCastException {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(androidx.appcompat.widget.AppCompatRadioButton.class); //Element 1
        elements.add(androidx.appcompat.widget.AppCompatRadioButton.class); //Element 2
        elements.add(androidx.appcompat.widget.AppCompatRadioButton.class); //Element 3
        /************************/

        //JUnit Test
        int prevElement = 0;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_RadioGroup_Properties() { //Check Layout Specification
        //Preprocessing
        RadioGroup component = layout;
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("radioGroup");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(RadioGroup.HORIZONTAL);
        comp.testLayoutBelow(mainLayout.getChildAt(4).getId());
    }

    @Test
    public void check_02_RadioButton_Properties() { //Check Layout Specification
        //Preprocessing
        RadioButton component = (RadioButton) layout.getChildAt(0);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("rbTemp");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testTextString("Temperature");
        comp.testSelected(true);
    }

    @Test
    public void check_03_RadioButton_Properties() { //Check Layout Specification
        //Preprocessing
        RadioButton component = (RadioButton) layout.getChildAt(1);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("rbDist");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testTextString("Distance");
        comp.testSelected(false);
    }

    @Test
    public void check_04_RadioButton_Properties() { //Check Layout Specification
        //Preprocessing
        RadioButton component = (RadioButton) layout.getChildAt(2);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("rbWeight");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testTextString("Weight");
        comp.testSelected(false);
    }

}
