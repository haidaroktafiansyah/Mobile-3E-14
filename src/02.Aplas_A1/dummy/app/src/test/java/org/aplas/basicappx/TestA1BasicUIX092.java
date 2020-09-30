package org.aplas.basicappx;

import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.View;

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

public class TestA1BasicUIX092 extends ViewTest {
    private MainActivity activity;
    private RelativeLayout mainLayout;
    private TableLayout layout;


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
        //Load layout
        int compId = activity.getResources().getIdentifier(layoutName, "id", activity.getPackageName());
        mainLayout = (RelativeLayout) activity.findViewById(compId);
        layout =  (TableLayout) mainLayout.getChildAt(7);
    }

    private void checkCompletion() throws NullPointerException, ClassCastException {
        /******** Check components completion ********/
        /** Specified Elements **/
        List<Class> elements = new ArrayList<>();
        elements.add(TableRow.class); //Element 1
        elements.add(TableRow.class); //Element 1
        elements.add(TableRow.class); //Element 1
        /************************/

        //JUnit Test
        int prevElement = 0;
        testCompletion(prevElement,elements,layout);
        int rowSize = elements.size();
        int colSize = 4;
        elements.clear();
        for (int i=0;i<4;i++) elements.add(androidx.appcompat.widget.AppCompatTextView.class);

        for (int i=0; i<rowSize; i++) {
            TableRow row = (TableRow) layout.getChildAt(i);
            testCompletion(prevElement,elements,row);
        }

    }

    @Test
    public void check_01_TableLayout_Properties() { //Check Layout Specification
        //Component properties value
        int compIdx = 7;
        ElementTest comp = new ElementTest(layout);

        //Test each item
        comp.testIdName("table");
        comp.testWidth(TableLayout.LayoutParams.WRAP_CONTENT);
        comp.testHeight(TableLayout.LayoutParams.WRAP_CONTENT);
        comp.testLayoutBelow(mainLayout.getChildAt(compIdx-1).getId());
        comp.testLinearHorizontal(true);
        //comp.testGravity(Gravity.CENTER);
        comp.testTopMargin(11);
        comp.testStrectchColumn(true);
    }

    @Test
    public void check_02_TableRow_Properties() { //Check Layout Specification
        //Component properties value
        TableRow row = (TableRow) layout.getChildAt(0);
        String[] itemId = "tv11,tv12,tv13,tv14".split("\\,");
        String[] itemVal = "Temperature,0°C,32°F,273.15 K".split("\\,");

        //Test first column
        ElementTest comp = new ElementTest(row.getChildAt(0));
        comp.testIdName(itemId[0]);
        comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
        comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
        int[] headColors = {-47872,-47872,-47872};
        comp.testBgGradientColor(headColors);
        comp.testPadding(5);
        comp.testTextString(itemVal[0]);
        comp.testTextColor(-1);
        comp.testTextStyle(Typeface.BOLD);

        int[] cellColors = {-6987,-6987,-6987};
        //Test each column
        for (int i=1; i<4; i++) {
            comp = new ElementTest(row.getChildAt(i));
            comp.testIdName(itemId[i]);
            comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testBgGradientColor(cellColors);
            comp.testPadding(5);
            comp.testTextString(itemVal[i]);
        }
    }

    @Test
    public void check_03_TableRow_Properties() { //Check Layout Specification
        //Component properties value
        TableRow row = (TableRow) layout.getChildAt(1);
        String[] itemId = "tv21,tv22,tv23,tv24".split("\\,");
        String[] itemVal = "Distance,1 Meter,39.3701 Inch,3.2808 feet".split("\\,");

        //Test first column
        ElementTest comp = new ElementTest(row.getChildAt(0));
        comp.testIdName(itemId[0]);
        comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
        comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
        int[] headColors = {-47872,-47872,-47872};
        comp.testBgGradientColor(headColors);
        comp.testPadding(5);
        comp.testTextString(itemVal[0]);
        comp.testTextColor(-1);
        comp.testTextStyle(Typeface.BOLD);

        int[] cellColors = {-6987,-6987,-6987};
        //Test each column
        for (int i=1; i<4; i++) {
            comp = new ElementTest(row.getChildAt(i));
            comp.testIdName(itemId[i]);
            comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testBgGradientColor(cellColors);
            comp.testPadding(5);
            comp.testTextString(itemVal[i]);
        }

    }

    @Test
    public void check_04_TableRow_Properties() { //Check Layout Specification
        //Component properties value
        TableRow row = (TableRow) layout.getChildAt(2);
        String[] itemId = "tv31,tv32,tv33,tv34".split("\\,");
        String[] itemVal = "Weight,1 Kg,35.2740 ounce,2.2046 pound".split("\\,");

        //Test first column
        ElementTest comp = new ElementTest(row.getChildAt(0));
        comp.testIdName(itemId[0]);
        comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
        comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
        int[] headColors = {-47872,-47872,-47872};
        comp.testBgGradientColor(headColors);
        comp.testPadding(5);
        comp.testTextString(itemVal[0]);
        comp.testTextColor(-1);
        comp.testTextStyle(Typeface.BOLD);

        int[] cellColors = {-6987,-6987,-6987};
        //Test each column
        for (int i=1; i<4; i++) {
            comp = new ElementTest(row.getChildAt(i));
            comp.testIdName(itemId[i]);
            comp.testWidth(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testHeight(TableRow.LayoutParams.WRAP_CONTENT);
            comp.testBgGradientColor(cellColors);
            comp.testPadding(5);
            comp.testTextString(itemVal[i]);
        }

    }
	
	@Test
    public void check_05_ImageFormula_Properties() { //Check Layout Specification
        //Component properties value
        int compIdx = 8;
        testItem(true, mainLayout.getChildCount()>compIdx,"ImageView 'imgFormula' is not found",3);
        View component = mainLayout.getChildAt(compIdx);
        testItem("AppCompatImageView",component.getClass().getSimpleName(),"ImageView 'imgFormula' is not in right position",1);
        ElementTest comp = new ElementTest(component);

        //Test each item
        comp.testIdName("imgFormula");
        comp.testWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        comp.testHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        comp.testImageSrc("formula");
        comp.testLayoutBelow(mainLayout.getChildAt(7).getId());
        comp.testLinearHorizontal(true);
        comp.testTopMargin(2);
        comp.testVisibility(View.INVISIBLE);
    }
}
