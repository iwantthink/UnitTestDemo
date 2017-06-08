package com.hmt.analytics.unittestdemo;

/**
 * Created by renbo on 2017/6/8.
 */

public class LoginPresent {

    VerifyPsw verifyPsw = new VerifyPsw();

    public void setVerifyPsw(VerifyPsw verifyPsw) {
        this.verifyPsw = verifyPsw;
    }

    public void login(String account, String password) {
//        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
//            return;
//        }
        boolean result = verifyPsw.verifyValid(account, password);
        if (!result)
            return;

        System.out.print("login success");
        //TODO
    }

}

class VerifyPsw {

    public boolean verifyValid(final String account, final String psw) {
        boolean result = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (account.equals("1") && psw.equals("1")) {
            result = true;
        }
        return result;
    }
}