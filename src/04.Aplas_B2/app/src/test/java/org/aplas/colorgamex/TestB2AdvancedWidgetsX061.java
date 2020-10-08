package org.aplas.colorgamex;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashMap;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX061 extends ViewTest {
    private MyActivity activity;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
    }

    @Test
    public void check_01_Fields_Availability() { //Check Layout Specification
        MyActivity act = new MyActivity();
        testField(act,"clrList", -1, String[].class,true);
        testField(act,"charList", -1, HashMap.class,false);
        HashMap x = (HashMap) getFieldValue(act,"charList");
        testItem(0,x.size(),"charList length should be 0",1);

        testMethod(act,"initColorList", -1,new Class[0],void.class);
    }

    @Test
    public void check_02_ColorData() {
        String[] list = (String[])getFieldValue(activity,"clrList");

        int resId = activity.getResources().getIdentifier("colorList", "array", activity.getPackageName());
        String[] temp = activity.getResources().getStringArray(resId);
        testItem(temp.length,list.length,"Size of clrList is wrong",1);
        testItem(arrayToString(temp),arrayToString(list),"Content of clrList is wrong",1);

        HashMap map = (HashMap) getFieldValue(activity,"charList");
        testItem(temp.length,map.size(),"Size of charList is wrong",1);

        resId = activity.getResources().getIdentifier("charList", "array", activity.getPackageName());
        String[] temp2 = activity.getResources().getStringArray(resId);

        for (int i=0; i<temp.length; i++) {
            testItem(null,map.get(temp[i]),"charlist element with \""+temp[i]+"\" index is not available" ,6);
            testItem(temp[i]+"@;"+temp2[i], temp[i]+"@;"+map.get(temp[i]).toString(), "This element ("+i+") should be ("+temp[i]+"->"+temp2[i]+")", 1);
        }
    }
}
