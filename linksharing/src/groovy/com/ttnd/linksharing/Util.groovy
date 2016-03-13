package com.ttnd.linksharing

import org.apache.commons.lang.RandomStringUtils

/**
 * Created by surbhi on 13/3/16.
 */
class Util {
    static String getRandomPassword() {
        RandomStringUtils randomPassword = new RandomStringUtils();
        return randomPassword.randomAlphanumeric(6)
    }
}
