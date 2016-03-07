package com.link.sharing.core

class DocumentResource extends Resource {

    String filePath

    static constraints = {

        filePath(nullable: false)
    }

    String toString() {
        filePath
    }
}
