package org.aplas.colorgamex;

import android.os.Build;

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

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX011 extends ViewTest {
    private MyActivity activity;
    private final String layoutName = "activity_layout";
    private final String appName  = "ColorGameX";
    private final String compDomain = "org.aplas.colorgamex";
    private final String targetDevice = "9";
    private final String actName = "MyActivity";
    private final String backwardComp = "AppCompatActivity";
    private final int minSDK = 24;

    @Before
    public void initTest() {
        //Robolectric
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
    }

    @Test
    public void checkAppName() { //Check Project Name (Should be Basic101)
        assertEquals("Application Name is Wrong", appName.toLowerCase(), getAppName(activity.getPackageName()));
    }

    @Test
    public void checkPackageName() { //Check Company Domain (Should be org.jplas.android)
        String packName = compDomain;//+"."+appName.toLowerCase();
        assertEquals("Package Name is Wrong", packName, activity.getPackageName());
    }

    @Test
    public void checkTargetDevice() { //Check Target Device (Should be 6.0.1)
        assertEquals("Target Device is Wrong",targetDevice,Build.VERSION.RELEASE);
    }

    @Test
    public void checkMinimumSDK() { //Check Minimum SDK (Should be 28)
        assertEquals("Minimum SDK Version is Wrong",minSDK,BuildConfig.MIN_SDK_VERSION);
    }

    @Test
    public void checkActivityName() { //Check Activity Name (Should be MyActivity)
        assertEquals("Activity Name is Wrong", actName, activity.getClass().getSimpleName());
    }

    @Test
    public void checkLayoutName() { //Check Layout Name (Should be activity_layout)
        int resId = activity.getResources().getIdentifier(layoutName, "layout", activity.getPackageName());
        assertNotEquals("Layout Name is Wrong", 0, resId);
    }

    @Test
    public void checkMyActivityParentClass() { //Check Backward Compatibility (Should be AppCompatActivity)
        assertEquals("MyActivity Parent Class is Wrong", backwardComp, activity.getClass().getSuperclass().getSimpleName());
    }

    private String getAppName(String packName) {
        String[] list = packName.split("\\.");
        String res = list[list.length-1];
        return res;
    }
}
