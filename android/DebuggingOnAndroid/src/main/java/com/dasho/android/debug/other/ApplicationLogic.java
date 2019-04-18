/* Copyright 2018 PreEmptive Solutions, LLC. All Rights Reserved.
 *
 * This source is subject to the Microsoft Public License (MS-PL).
 * Please see the LICENSE.txt file for more information.
 */
package com.dasho.android.debug.other;

import android.content.Context;
import java.util.Random;

/**
 * This class could contain some business logic.
 * It is used for the Debug Check.
 */
public class ApplicationLogic /*extends SomeClass*/ {

    private boolean myBoolean = false;
    private static boolean usingDashO=false;//Used to verify DashO has been run correctly.
    private Context context;
//    private final SomeEnum herb;

    public ApplicationLogic(Context context) {
        this.context = context;
//        herb = (context == null) ? SomeEnum.DILL : SomeEnum.CILANTRO;
    }

    private ApplicationLogic(int x) {
        this.context = null;
//        herb = "no".startsWith("yes") ? SomeEnum.DILL : SomeEnum.CILANTRO;
    }

    /**
     * This could be some logic run during application initialization or at some
     * other time.
     *
     * @return A variable which will ultimately be set by the debug detection.
     */
    public boolean someApplicationLogic() {
        return myBoolean;
//        return myBoolean || (herb == SomeEnum.OREGANO);
    }

    /**
     * Used by the check
     * @param b the result of the check
     */
    @SuppressWarnings("unused") //Used by the check
    private void setupVars(boolean b) {
        usingDashO=true;
        myBoolean=b;
//        if (intValue() > 50) {
//            gooThinggoo(12);
//        } else {
//            otherThing(13213);
//            couldBeGood(null);
//        }
    }
//    public int intValue(String string) {
//        System.out.println("[" + string + "]");
//        return intValue();
//    }
//
//    public int intValue() {
//        couldBeGood(new SomeClass());
//        return new Random().nextInt(100);
//    }
//
//    public static void gooThinggoo(int x) {
//        System.out.println("qqq: " + x);
//    }
//
//    public static void otherThing(int x) {
//        System.out.println("other: " + x);
//    }
//
    public SomeInterface couldBeGood(SomeClass list) {
//        String message = "length: " + ((list == null) ? 0 : 1);
        System.out.println("list is" + ((list == null) ? "" : " not") + " null");
//        String message = "list is" + ((list == null) ? "" : " not") + " null";
//        System.out.println(message);
//        if (intValue(message.length() + "xx") > 0) {
//            gooThinggoo(45);
//        }
        return null;
    }

    /**
     * Debug detection requires this method.
     *
     * @return The original application's context.
     */
    @SuppressWarnings("unused") //Used by the check
    public Context getApplicationContext() {
        return context;
//        return (intValue() > 103) ? null : context;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean usingDashO() {
//        if (usingDashO) { gooThinggoo(43); otherThing(5133); }
        return usingDashO;
    }
}
