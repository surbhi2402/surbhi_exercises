package com.ttnd.linksharing.Enum

/**
 * Created by surbhi on 23/2/16.
 */
enum Visibility {
    PUBLIC,PRIVATE

    static Visibility convert(String s)
    {
        if(s=="PUBLIC")
            Visibility.PUBLIC
        else
            Visibility.PRIVATE

    }

}
