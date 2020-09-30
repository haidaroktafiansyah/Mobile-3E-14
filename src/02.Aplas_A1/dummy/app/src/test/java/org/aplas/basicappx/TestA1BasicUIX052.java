package org.aplas.basicappx;

import android.graphics.Typeface;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
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

public class TestA1BasicUIX052 extends ViewTest {
    private MainActivity activity;
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
        layout = (LinearLayout) ((RelativeLayout) activity.findViewById(compId)).getChildAt(3);
    }

    private void checkCompletion() throws NullPointerException, ClassCastException {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(androidx.appcompat.widget.AppCompatEditText.class); //Element 1
        elements.add(androidx.appcompat.widget.AppCompatSpinner.class);  //Element 2
        elements.add(androidx.appcompat.widget.AppCompatTextView.class); //Element 1
        elements.add(androidx.appcompat.widget.AppCompatEditText.class);  //Element 2
        elements.add(androidx.appcompat.widget.AppCompatSpinner.class); //Element 1
        /************************/

        //JUnit Test
        int prevElement = 0;
        testCompletion(prevElement,elements,layout);
    }

    @Test
    public void check_01_EditText_Properties() { //Check Layout Specification
        //Preprocessing
        EditText component = (EditText) layout.getChildAt(0);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("inputText");
        comp.testWidth(0);
        comp.testHeight(44);
        comp.testWeight((float)0.2);
        comp.testTextString("0");
        Typeface compStyle = Typeface.create("fonts/cambria.ttf", Typeface.BOLD);
        comp.testTextFace(compStyle);
        comp.testTextStyle(compStyle.getStyle());
        comp.testTextSize((float)22);
        comp.testTextColor(-16777216);
        comp.testGravity(Gravity.CENTER);
        comp.testHintText("Enter any value");
        comp.testInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Test
    public void check_02_Spinner_Properties() { //Check Layout Specification
        //Preprocessing
        Spinner component = (Spinner) layout.getChildAt(1);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("oriList");
        comp.testWidth(0);
        comp.testHeight(44);
        comp.testWeight((float)0.24);
        comp.testPromptText("Choose");
        comp.testSpinnerMode(Spinner.MODE_DIALOG);
        comp.testGravity(Gravity.CENTER);
        comp.testSpinnerContent("°C,°F,K");
    }

    @Test
    public void check_03_TextView_Properties() { //Check Layout Specification
        //Preprocessing
        Typeface compStyle = Typeface.create("fonts/cambria.ttf", Typeface.BOLD);
        TextView component = (TextView) layout.getChildAt(2);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("myTextView2");
        comp.testWidth(0);
        comp.testHeight(44);
        comp.testWeight((float)0.12);
        comp.testTextString("->");
        comp.testTextFace(compStyle);
        comp.testTextStyle(compStyle.getStyle());
        comp.testTextColor(-16777216);
        comp.testTextSize(31);
        comp.testGravity(Gravity.CENTER);
    }

    @Test
    public void check_04_EditText_Properties() { //Check Layout Specification
        //Preprocessing
        EditText component = (EditText) layout.getChildAt(3);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("outputText");
        comp.testWidth(0);
        comp.testHeight(44);
        comp.testWeight((float)0.2);
        comp.testTextString("0");
        Typeface compStyle = Typeface.create("fonts/cambria.ttf", Typeface.BOLD);
        comp.testTextFace(compStyle);
        comp.testTextStyle(compStyle.getStyle());
        comp.testTextSize((float)22);
        comp.testTextColor(-16777216);
        comp.testGravity(Gravity.CENTER);
        comp.testIsEnabled(false);
        comp.testInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Test
    public void check_05_Spinner_Properties() { //Check Layout Specification
        //Preprocessing
        Spinner component = (Spinner) layout.getChildAt(4);
        ElementTest comp = new ElementTest(component);

        //Component properties value
        comp.testIdName("convList");
        comp.testWidth(0);
        comp.testHeight(44);
        comp.testWeight((float)0.24);
        comp.testPromptText("Choose");
        comp.testSpinnerMode(Spinner.MODE_DIALOG);
        comp.testGravity(Gravity.CENTER);
        comp.testSpinnerContent("°C,°F,K");
    }

    /*
    @Test
    public void check_02_ChildLayout_Properties() throws Exception { //Check Button Specification
        //Preprocessing
        LinearLayout layout = childLayout;
        Spinner component = (Spinner) layout.getChildAt(1);
        ArrayList<HashMap> testList = new ArrayList<>();

        //Component properties value
        testList.add(itemTest("child1",activity.getResources().getResourceEntryName(component.getId()),"Element Id name is not suitable",1));
        testList.add(itemTest(ViewGroup.LayoutParams.MATCH_PARENT,component.getLayoutParams().width,"Element width is not suitable",1));
        testList.add(itemTest(ViewGroup.LayoutParams.WRAP_CONTENT,component.getLayoutParams().height,"Element height is not suitable",1));
        //testList.add(itemTest(LinearLayout.HORIZONTAL,component.getOrientation(),"Layout orientation is not suitable",1));

        testElement(testList);
    }
*/
}
