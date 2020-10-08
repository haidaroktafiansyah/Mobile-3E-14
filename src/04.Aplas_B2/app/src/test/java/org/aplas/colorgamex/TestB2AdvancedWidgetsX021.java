package org.aplas.colorgamex;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX021 extends ViewTest {
    private MyActivity activity;
    private ResourceTest rsc;

    @Before
    public void initTest() {
        //Robolectric
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
        //activity = Robolectric.setupActivity(MyActivity.class);
        rsc = new ResourceTest(activity.getResources());
        String appName = activity.getApplicationInfo().loadLabel(activity.getPackageManager()).toString();
        assertEquals("Applicaton name is wrong", "APLAS COLOR GAME", appName);
    }

    @Test
    public void checkResIconDrawable() {
        String resName = "ic_resicon";
        int resId = activity.getResources().getIdentifier(resName, "drawable", getClass().getPackage().getName());
        assertNotEquals("Drawable " + resName + " is not defined", 0,resId);
    }

    @Test
    public void checkRoundBtnDrawable() {
        String resName = "round_btn";
        int resId = activity.getResources().getIdentifier(resName, "drawable", getClass().getPackage().getName());
        assertNotEquals("Drawable " + resName + " is not defined", 0,resId);
        GradientDrawable draw = (GradientDrawable) activity.getDrawable(resId);

        assertEquals("Drawable shape is wrong", GradientDrawable.RECTANGLE,draw.getShape());
        assertEquals("Corner Radius value is wrong", 20,draw.getCornerRadius(),0.01);
        assertEquals("Gradient Radius value is wrong", 100,draw.getGradientRadius(),0.01);
        assertEquals("Gradient Center X value is wrong", 0.5,draw.getGradientCenterX(),0.01);
        assertEquals("Gradient Center Y value is wrong", 0.8,draw.getGradientCenterY(),0.01);
        assertEquals("Gradient Start Color value is wrong", -5654574,draw.getColors()[0]);
        assertEquals("Gradient Center Color value is wrong", -6871130,draw.getColors()[1]);
        assertEquals("Gradient End Color value is wrong", -9436250,draw.getColors()[2]);
        assertEquals("Gradient End Color value is wrong", GradientDrawable.RADIAL_GRADIENT,draw.getGradientType());
        assertEquals("Gradient Height value is wrong", 50,draw.getIntrinsicHeight());
        assertEquals("Gradient Weight value is wrong", 100,draw.getIntrinsicWidth());
        Rect rect = new Rect();
        draw.getPadding(rect);
        assertEquals("Gradient Padding Bottom value is wrong", 7,rect.bottom);
        assertEquals("Gradient Padding Top value is wrong", 7,rect.top);
        assertEquals("Gradient Padding Left value is wrong", 7,rect.left);
        assertEquals("Gradient Padding Right value is wrong", 7,rect.right);
    }



    @Test
    public void checkColoredButton() {
        int resId = activity.getResources().getIdentifier("ColoredButton", "style", getClass().getPackage().getName());
        assertNotEquals("ColoredButton style is not defined",0,resId);

        int[] attrs ={android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.textSize};
        TypedArray arrStyle = activity.obtainStyledAttributes(resId, attrs);

        assertEquals("android:layout_width value is wrong", 111,arrStyle.getDimensionPixelSize(0,0));
        assertEquals("android:layout_height value is wrong", 44,arrStyle.getDimensionPixelSize(1,0));
        assertEquals("android:textSize value is wrong", 18,arrStyle.getDimensionPixelSize(2,0));

    }

    @Test
    public void checkProgressBar() { //Check Project Name (Should be Basic101)
        int resId = activity.getResources().getIdentifier("ProgressBar", "style", getClass().getPackage().getName());
        assertNotEquals("ProgressBar style is not defined",0,resId);

        int[] attrs ={android.R.attr.indeterminateOnly, android.R.attr.progressTint, android.R.attr.minHeight,android.R.attr.maxHeight};
        TypedArray arrStyle = activity.obtainStyledAttributes(resId, attrs);

        assertFalse("android:indeterminateOnly value is wrong",arrStyle.getBoolean(0,false));
        assertEquals("android:progressTint value is wrong", -6882038,arrStyle.getColor(1,0));
        assertEquals("android:minHeight value is wrong", 18,arrStyle.getDimensionPixelSize(2,0));
        assertEquals("android:maxHeight value is wrong", 25,arrStyle.getDimensionPixelSize(3,0));
    }
}
