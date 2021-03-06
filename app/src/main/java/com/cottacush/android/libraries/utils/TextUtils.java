package com.cottacush.android.libraries.utils;

import android.widget.EditText;

/**
 * @author Adegoke Obasa <goke@cottacush.com>
 */

public class TextUtils {
    /**
     * @param phoneNumber
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String asteriskPhoneNumber(String phoneNumber, int startIndex, int endIndex) {
        String firstPart = phoneNumber.substring(0, startIndex);
        String endPart = phoneNumber.substring(endIndex);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstPart);
        for (int i = 0; i < (endIndex - startIndex); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(endPart);
        return stringBuilder.toString();
    }

    /**
     * @param text
     * @return
     */
    public static String addNairaToText(String text) {
        return ("₦" + text);
    }

    /**
     * @param text
     * @return
     */
    public static String formatTextToNaira(String text) {
        double amount = Double.valueOf(text);
        return addNairaToText(String.format("%,.2f", amount));
    }

    /**
     * @param text
     * @return
     */
    public static String formatTextToMoney(String text) {
        int MILLION = 1000000;
        boolean THOUSAND = true;
        double amount = Double.valueOf(text).doubleValue();
        return amount >= 1000000.0D ? String.format("₦%dM",
                new Object[]{Integer.valueOf((int) amount / 1000000)})
                : (amount >= 1000.0D ? String.format("₦%dK", new Object[]{Integer.valueOf((int) amount / 1000)})
                : String.format("₦%d", new Object[]{Integer.valueOf((int) amount)}));
    }

    /**
     * @param s1
     * @param s2
     * @return
     */
    public static double subtract(String s1, String s2) {
        double d1 = Double.valueOf(s1);
        double d2 = Double.valueOf(s2);
        return d1 - d2;
    }

    public static boolean isEmailValid(CharSequence email) {
        return !android.text.TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean checkFields(EditText... editTexts) {
        for (EditText i : editTexts) {
            if (android.text.TextUtils.isEmpty(i.getText())) {
                i.setError("This field is required");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phonenumber) {
        return phonenumber.length() == 11;
    }
}