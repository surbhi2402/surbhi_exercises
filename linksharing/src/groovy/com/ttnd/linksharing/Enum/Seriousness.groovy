package com.ttnd.linksharing.Enum

/**
 * Created by surbhi on 12/2/16.
 */
enum Seriousness {
    SERIOUS, VERY_SERIOUS, CASUAL


    static Seriousness convert(String s)
    {
        if(s=="SERIOUS")
            Seriousness.SERIOUS

        else if(s=="VERY_SERIOUS")
            Seriousness.VERY_SERIOUS

        else
            Seriousness.CASUAL
    }

}

