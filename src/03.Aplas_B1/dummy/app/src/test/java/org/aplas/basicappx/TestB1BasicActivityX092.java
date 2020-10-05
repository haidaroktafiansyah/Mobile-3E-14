package org.aplas.basicappx;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
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

public class TestB1BasicActivityX092 extends ViewTest {
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
        elements.add(androidx.appcompat.widget.AppCompatImageView.class); //Element 1
        /************************/

        //JUnit Test
        int prevElement = 8;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_ImageView_Properties() { //Check Layout Specification
        //Component properties value
        int compIdx = 8;
        ImageView component = (ImageView) layout.getChildAt(compIdx);
        ElementTest comp = new ElementTest(component);

        //Test each item
        comp.testIdName("imgFormula");
        comp.testWidth(-1);
        comp.testHeight(-1);
        comp.testImageSrc("formula");
        comp.testLayoutBelow(layout.getChildAt(compIdx-1).getId());
        comp.testLinearHorizontal(true);
        comp.testTopMargin(2);
        comp.testVisibility(View.INVISIBLE);
    }

    @Test
    public void check_02_FormulaBox_Event() { //Check Layout Specification
        int compIdx = 8;
        ImageView component = (ImageView) layout.getChildAt(compIdx);
        ElementTest comp = new ElementTest(component);

        //Check Visibility
        ((CheckBox)activity.findViewById(R.id.chkFormula)).setChecked(true);
        comp.testVisibility(View.VISIBLE);

        ((CheckBox)activity.findViewById(R.id.chkFormula)).setChecked(false);
        comp.testVisibility(View.INVISIBLE);
    }
}
