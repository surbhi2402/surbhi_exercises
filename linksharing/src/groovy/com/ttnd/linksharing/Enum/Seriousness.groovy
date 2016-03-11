package com.ttnd.linksharing.Enum

/**
 * Created by surbhi on 12/2/16.
 */
enum Seriousness {
    SERIOUS, VERY_SERIOUS, CASUAL


    static getSeriousness(String serious) {

        String seriousInUpperCase = serious.toUpperCase()
        return valueOf(seriousInUpperCase)

    }
}

