package com.linksharing



class UnreadItemEmailJob {
    def userService
    static triggers = {
        cron cronExpression: "0 0 1 ? * MON *"
    }

    def execute() {
        userService.sendUnreadItemsEmail()
    }
}
