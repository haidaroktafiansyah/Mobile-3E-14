package org.aplas.colorgamex;

import android.content.res.TypedArray;
import android.graphics.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX012 extends ViewTest {
    private MyActivity activity;
    private ResourceTest rsc;

    @Before
    public void initTest() {
        //Robolectric
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
        //activity = Robolectric.setupActivity(MyActivity.class);
        rsc = new ResourceTest(activity.getResources());

    }

    @Test
    public void checkAppTheme() {
        String resName = "AppTheme";

        int resId = activity.getResources().getIdentifier(resName, "style", getClass().getPackage().getName());
        assertNotEquals(resName+" style is not defined",0,resId);

        int[] attrs ={android.R.attr.background, android.R.attr.paddingLeft, android.R.attr.paddingRight, android.R.attr.paddingTop, android.R.attr.paddingBottom,android.R.attr.windowActionBar, android.R.attr.windowNoTitle, android.R.attr.textColor};
        TypedArray arrStyle = activity.obtainStyledAttributes(resId, attrs);

        assertTrue("style parent should be Theme.AppCompat.Light.NoActionBar",!arrStyle.getBoolean(5,false) && arrStyle.getBoolean(6,false));
        assertEquals("android:background value is wrong", -6174514,arrStyle.getColor(0, Color.BLACK));
        assertEquals("android:paddingLeft value is wrong", 2,arrStyle.getLayoutDimension(1,0));
        assertEquals("android:paddingRight value is wrong", 2,arrStyle.getLayoutDimension(2,0));
        assertEquals("android:paddingTop value is wrong", 2,arrStyle.getLayoutDimension(3,0));
        assertEquals("android:paddingBottom value is wrong", 2,arrStyle.getLayoutDimension(4,0));
        assertEquals("android:textSize value is wrong", -15000805,arrStyle.getColor(7, Color.BLACK));

        int currThemeId;
        try {
            currThemeId = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).getThemeResource();
            assertEquals("Application theme should be " + resName, currThemeId,resId);
        } catch (Exception e) {
            Assert.fail(resName + " is not defined");
        }
    }

    @Test
    public void checkColorResources() {
        rsc.testColorResource("greenLight", -6882038);
        rsc.testColorResource("textColor", -15000805);
        rsc.testColorResource("titleBackground", -65625);
        rsc.testColorResource("textBackground", -1907998);
        rsc.testColorResource("clrRed", -65536);
        rsc.testColorResource("clrYellow", -2304);
        rsc.testColorResource("clrBlue", -16769281);
        rsc.testColorResource("clrGreen", -16711915);
        rsc.testColorResource("clrOrange", -37120);
        rsc.testColorResource("clrPurple", -7012097);

    }

    @Test
    public void checkStringResources() {
        rsc.testStringResource("app_name", "APLAS COLOR GAME");
        rsc.testStringResource("keyword", "quiz@123");
    }

    @Test
    public void checkStringArrayResources() {
        String[] expected = "Red,Yellow,Blue,Green,Orange,Purple".split("\\,");
        rsc.testStringArrayResource("colorList",expected);
        expected = "A,B,C,D,E,F".split("\\,");
        rsc.testStringArrayResource("charList",expected);
    }


}
