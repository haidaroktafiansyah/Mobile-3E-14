package org.aplas.basicappx;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)

public class TestA1BasicUIX011 extends ViewTest {
    private MainActivity activity;
    private String packageName = "org.aplas";
    private String targetDevice = "9";
    private int minSDK = 21;
    private String actName = "MainActivity";
    private String layoutName = "activity_main";
    private String backwardComp = "AppCompatActivity";

    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }


    @Test
    public void checkAppName() { //Check Project Name (Should be BasicApp)
        assertEquals("Application Name is Wrong", appName.toLowerCase(), getAppName(activity.getPackageName()));
    }

    @Test
    public void checkPackageName() { //Check Company Domain (Should be org.jplas.android)
        String packName = packageName+"."+appName.toLowerCase();
        assertEquals("Package Name is Wrong", packName, activity.getPackageName());
    }

    @Test
    public void checkTargetDevice() { //Check Target Device (Should be 6.0.1)
        assertEquals("Target Device is Wrong",targetDevice,Build.VERSION.RELEASE);
    }


    @Test
    public void checkMinimumSDK() { //Check Minimum SDK (Should be 28)
        assertEquals("Minimum SDK Version is Wrong",minSDK,activity.getApplicationInfo().minSdkVersion);
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
    public void checkActivityParent() { //Check Backward Compatibility (Should be AppCompatActivity)
        assertEquals("Activity Parent is Wrong", backwardComp, activity.getClass().getSuperclass().getSimpleName());
    }

    private String getAppName(String packName) {
        String[] list = packName.split("\\.");
        String res = list[list.length-1];
        return res;
    }


}
