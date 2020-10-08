package org.aplas.colorgamex;

import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.Switch;
import androidx.appcompat.widget.AppCompatTextView;

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

public class TestB2AdvancedWidgetsX031 extends ViewTest {
    private MyActivity activity;
    private LinearLayout mainLayout;

    @Before
    public void initTest() {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MyActivity.class).create().get();

        //Load main layout
        String layoutName = "mainLayout";
        int compId = activity.getResources().getIdentifier(layoutName, "id", activity.getPackageName());
        mainLayout = (LinearLayout) activity.findViewById(compId);

        checkCompletion();
    }

    private void checkCompletion() {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatTextView.class); //Element 1
        elements.add(LinearLayout.class);  //Element 2
        elements.add(LinearLayout.class);  //Element 3
        elements.add(RelativeLayout.class);  //Element 4
        elements.add(Space.class);  //Element 5
        elements.add(RelativeLayout.class);  //Element 6
        elements.add(LinearLayout.class);  //Element 7
        elements.add(LinearLayout.class);  //Element 8

        /************************/
        testCompletion(0,elements,mainLayout);
    }

    @Test
    public void check_0_Layout_mainLayout() {
        //Component properties value
        ElementTest comp = new ElementTest(mainLayout);

        //Test each item
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testOrientation(LinearLayout.VERTICAL);
    }

    @Test
    public void check_1_TextView_appTitle() {
        //Preprocessing
        AppCompatTextView component = (AppCompatTextView) mainLayout.getChildAt(0);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("appTitle");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(40);
        comp.testTextString("APLAS COLOR GAME");
        comp.testTextStyle(Typeface.BOLD);
        comp.testTextSize(27);
        comp.testGravity(Gravity.CENTER);
        comp.testBgColor(-65625);
    }

    @Test
    public void check_2_LinearLayout_accessBox() {
        //Preprocessing
        LinearLayout component = (LinearLayout) mainLayout.getChildAt(1);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("accessBox");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.HORIZONTAL);
        comp.testVisibility(View.VISIBLE);

        //check_accessBox_Components(component);
    }

    @Test
    public void check_2_1_accessBox_Components() {
        ViewGroup layout=(LinearLayout) mainLayout.getChildAt(1);

        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatEditText.class); //Element 1
        elements.add(AppCompatButton.class);  //Element 2
        testCompletion(0,elements,layout);

        //Check 1st element
        AppCompatEditText component1 = (AppCompatEditText) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("appCode");
        comp1.testWidth(200);
        comp1.testHeight(30);
        comp1.testInputType(129);
        comp1.testHintText("Enter password here!");
        comp1.testBgColor(-328966);

        //Check 2nd element
        AppCompatButton component2 = (AppCompatButton) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("submitBtn");
        comp2.testWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        comp2.testHeight(30);
        comp2.testTextString("Enter");
        comp2.testOnClickMethod("openGame");
        comp2.testBgColor(-5592406);
    }


    @Test
    public void check_3_LinearLayout_colorBox() {
        //Preprocessing
        LinearLayout component = (LinearLayout) mainLayout.getChildAt(2);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("colorBox");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.VERTICAL);
        comp.testVisibility(View.INVISIBLE);

        //check_colorBox_Components(component);
    }

    @Test
    public void check_3_1_colorBox_Components() {
        LinearLayout layout = (LinearLayout) mainLayout.getChildAt(2);

        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatTextView.class); //Element 1
        elements.add(Space.class);  //Element 2
        elements.add(AppCompatTextView.class);  //Element 3
        testCompletion(0,elements,layout);

        //Check 1st element
        AppCompatTextView component1 = (AppCompatTextView) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("clrText");
        comp1.testWidth(150);
        comp1.testHeight(55);
        comp1.testTextSize(36);
        comp1.testTextStyle(Typeface.BOLD);
        comp1.testTextString("");
        comp1.testTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        comp1.testBgColor(-1907998);
        comp1.testGravity(Gravity.CENTER);

        //Check 2nd element
        Space component2 = (Space) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("spaceText1");
        comp2.testWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        comp2.testHeight(10);

        //Check 3rd element
        AppCompatTextView component3 = (AppCompatTextView) layout.getChildAt(2);
        ElementTest comp3 = new ElementTest(component3);
        comp3.testIdName("appText1");
        comp3.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp3.testHeight(30);
        comp3.testTextSize(18);
        comp3.testTextStyle(Typeface.BOLD);
        comp3.testTextString("Select one of these colors according to text");
        comp3.testGravity(Gravity.CENTER);
    }

    @Test
    public void check_4_RelativeLayout_buttonBox1() {
        //Preprocessing
        RelativeLayout component =(RelativeLayout) mainLayout.getChildAt(3);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("buttonBox1");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testVisibility(View.INVISIBLE);

        //check_buttonBox1_Components(component);
    }

    @Test
    public void check_4_1_buttonBox1_Components() {
        ViewGroup layout = (RelativeLayout) mainLayout.getChildAt(3);

        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatButton.class); //Element 1
        elements.add(AppCompatButton.class);  //Element 2
        elements.add(AppCompatButton.class);  //Element 3
        testCompletion(0,elements,layout);

        int styleWidth = 111;
        int styleHeight = 44;
        int styleTextSize = 18;

        //Check 1st element
        AppCompatButton component1 = (AppCompatButton) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("color1");
        comp1.testWidth(styleWidth);
        comp1.testHeight(styleHeight);
        comp1.testTextSize(styleTextSize);
        comp1.testTextString("A");
        comp1.testBgColor(-65536);
        comp1.testOnClickMethod("submitColor");

        //Check 2nd element
        AppCompatButton component2 = (AppCompatButton) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("color2");
        comp2.testWidth(styleWidth);
        comp2.testHeight(styleHeight);
        comp2.testTextSize(styleTextSize);
        comp2.testTextString("B");
        comp2.testBgColor(-2304);
        comp2.testOnClickMethod("submitColor");
        comp2.testCenterInParent();

        //Check 3rd element
        AppCompatButton component3 = (AppCompatButton) layout.getChildAt(2);
        ElementTest comp3 = new ElementTest(component3);
        comp3.testIdName("color3");
        comp3.testWidth(styleWidth);
        comp3.testHeight(styleHeight);
        comp3.testTextSize(styleTextSize);
        comp3.testTextString("C");
        comp3.testBgColor(-16769281);
        comp3.testOnClickMethod("submitColor");
        comp3.testAlignParentEnd();
    }

    @Test
    public void check_5_Space() {
        //Preprocessing
        Space component = (Space) mainLayout.getChildAt(4);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("spaceBox");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(10);
    }

    @Test
    public void check_6_RelativeLayout_buttonBox2() {
        //Preprocessing
        RelativeLayout component = (RelativeLayout) mainLayout.getChildAt(5);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("buttonBox2");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testVisibility(View.INVISIBLE);

        //check_buttonBox2_Components(component);
    }

    @Test
    public void check_6_1_buttonBox2_Components() {
        ViewGroup layout= (RelativeLayout) mainLayout.getChildAt(5);

        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatButton.class); //Element 1
        elements.add(AppCompatButton.class);  //Element 2
        elements.add(AppCompatButton.class);  //Element 3
        testCompletion(0,elements,layout);

        int styleWidth = 111;
        int styleHeight = 44;
        int styleTextSize = 18;

        //Check 1st element
        AppCompatButton component1 = (AppCompatButton) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("color4");
        comp1.testWidth(styleWidth);
        comp1.testHeight(styleHeight);
        comp1.testTextSize(styleTextSize);
        comp1.testTextString("D");
        comp1.testBgColor(-16711915);
        comp1.testOnClickMethod("submitColor");

        //Check 2nd element
        AppCompatButton component2 = (AppCompatButton) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("color5");
        comp2.testWidth(styleWidth);
        comp2.testHeight(styleHeight);
        comp2.testTextSize(styleTextSize);
        comp2.testTextString("E");
        comp2.testBgColor(-37120);
        comp2.testOnClickMethod("submitColor");
        comp2.testCenterInParent();

        //Check 3rd element
        AppCompatButton component3 = (AppCompatButton) layout.getChildAt(2);
        ElementTest comp3 = new ElementTest(component3);
        comp3.testIdName("color6");
        comp3.testWidth(styleWidth);
        comp3.testHeight(styleHeight);
        comp3.testTextSize(styleTextSize);
        comp3.testTextString("F");
        comp3.testBgColor(-7012097);
        comp3.testOnClickMethod("submitColor");
        comp3.testAlignParentEnd();
    }

    @Test
    public void check_7_LinearLayout_scoreBox() {
        //Preprocessing
        LinearLayout component = (LinearLayout) mainLayout.getChildAt(6);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("scoreBox");
        comp.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.VERTICAL);
        comp.testVisibility(View.INVISIBLE);
        comp.testGravity(Gravity.CENTER);

        //check_scoreBox_Components(component);
    }

    @Test
    public void check_7_1_scoreBox_Components() {
        LinearLayout layout = (LinearLayout) mainLayout.getChildAt(6);

        List<Class> elements = new ArrayList<>();
        elements.add(AppCompatTextView.class); //Element 1
        elements.add(AppCompatTextView.class);  //Element 2
        elements.add(AppCompatTextView.class);  //Element 3
        testCompletion(0,elements,layout);

        //Check 1st element
        AppCompatTextView component1 = (AppCompatTextView) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("timerText");
        comp1.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp1.testHeight(40);
        comp1.testTextSize(31);
        comp1.testTextString("timer");
        //Typeface t = Typeface.create("serif-monospace",Typeface.BOLD);
        //comp1.testTextStyle(t.getStyle());
        comp1.testTextFont("serif-monospace");
        comp1.testTextStyle(Typeface.BOLD);
        comp1.testTopMargin(4);
        comp1.testGravity(Gravity.CENTER);

        //Check 2nd element
        AppCompatTextView component2 = (AppCompatTextView) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("appText2");
        comp2.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp2.testHeight(30);
        comp2.testTextSize(13);
        comp2.testTextString("SCORE");
        comp2.testTextStyle(Typeface.BOLD);
        comp2.testGravity(Gravity.CENTER);

        //Check 3rd element
        AppCompatTextView component3 = (AppCompatTextView) layout.getChildAt(2);
        ElementTest comp3 = new ElementTest(component3);
        comp3.testIdName("scoreText");
        comp3.testWidth(120);
        comp3.testHeight(55);
        comp3.testTextSize(36);
        comp3.testTextStyle(Typeface.BOLD);
        comp3.testTextString("0");
        comp3.testBgColor(-1907998);
        comp3.testTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        comp3.testGravity(Gravity.CENTER);
    }

    @Test
    public void check_8_LinearLayout_progressBox() {
        //Preprocessing
        LinearLayout component = (LinearLayout) mainLayout.getChildAt(7);
        ElementTest comp = new ElementTest(component);

        //Component items test
        comp.testIdName("progressBox");
        comp.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp.testOrientation(LinearLayout.VERTICAL);
        comp.testVisibility(View.INVISIBLE);
        comp.testGravity(Gravity.CENTER);

        //check_progressBox_Components(component);
    }

    @Test
    public void check_8_1_progressBox_Components() {
        ViewGroup layout = (LinearLayout) mainLayout.getChildAt(7);

        List<Class> elements = new ArrayList<>();
        elements.add(Space.class); //Element 1
        elements.add(ProgressBar.class);  //Element 2
        elements.add(Switch.class);  //Element 3
        elements.add(AppCompatButton.class);  //Element 4
        testCompletion(0,elements,layout);

        //Check 1st element
        Space component1 = (Space) layout.getChildAt(0);
        ElementTest comp1 = new ElementTest(component1);
        comp1.testIdName("spaceBox2");
        comp1.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp1.testHeight(10);

        //Check 2nd element
        ProgressBar component2 = (ProgressBar) layout.getChildAt(1);
        ElementTest comp2 = new ElementTest(component2);
        comp2.testIdName("progressScore");
        comp2.testWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        comp2.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp2.testProgressProgressBar(0);
        comp2.testMaxProgressBar(100);

        //Check 3rd element
        Switch component3 = (Switch) layout.getChildAt(2);
        ElementTest comp3 = new ElementTest(component3);
        comp3.testIdName("isMinus");
        comp3.testWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        comp3.testHeight(ViewGroup.LayoutParams.WRAP_CONTENT);;
        comp3.testTextString("With minus score counter");
        comp3.testPaddingBottom(20);

        //Check 4th element
        AppCompatButton component4 = (AppCompatButton) layout.getChildAt(3);
        ElementTest comp4 = new ElementTest(component4);
        comp4.testIdName("startBtn");
        comp4.testWidth(150);
        comp4.testHeight(80);;
        comp4.testTextString("Start Game");
        comp4.testTextSize(18);
        comp4.testTextStyle(Typeface.BOLD);
        comp4.testGravity(Gravity.CENTER);
        comp4.testOnClickMethod("startGame");
        String resName = "round_btn";
        int resId = activity.getResources().getIdentifier("round_btn", "drawable", getClass().getPackage().getName());
        comp4.testBgDrawable(resName,activity.getDrawable(resId));
    }
}
