package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.WebAttributes

import javax.servlet.http.HttpServletResponse

@Secured(['permitAll'])
class LoginController {

    static defaultAction = "index"

    /**
     * Dependency injection for the authenticationTrustResolver.
     */
    def authenticationTrustResolver

    /**
     * Dependency injection for the springSecurityService.
     */
    def springSecurityService

    /**
     * Default action; redirects to 'defaultTargetUrl' if logged in, /login/auth otherwise.
     */
    def index() {
        println "Inside login Index."
        if (springSecurityService.isLoggedIn()) {
            println SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
            redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
        }
        else {
            println "---------Inside login index else-------"
            redirect action: 'auth', params: params
        }
    }

    /**
     * Show the login page.
     */
    def auth() {
        println "Inside auth Index."

        def config = SpringSecurityUtils.securityConfig

        if (springSecurityService.isLoggedIn()) {
            println "---------Inside auth if-------"
            println config.successHandler.defaultTargetUrl

            redirect uri: config.successHandler.defaultTargetUrl
        }

        String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
        List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])

        render view: 'home', model: [postUrl: postUrl,
                                   rememberMeParameter: config.rememberMe.parameter,recentShares:recentShares]
    }

    /**
     * The redirect action for Ajax requests.
     */
    def authAjax() {
        response.setHeader 'Location', SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
        response.sendError HttpServletResponse.SC_UNAUTHORIZED
    }

    /**
     * Show denied page.
     */
    def denied() {
        if (springSecurityService.isLoggedIn() &&
                authenticationTrustResolver.isRememberMe(SecurityContextHolder.context?.authentication)) {
            // have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
            redirect action: 'full', params: params
        }
    }

    /**
     * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
     */
    def full() {
        def config = SpringSecurityUtils.securityConfig
        render view: 'auth', params: params,
                model: [hasCookie: authenticationTrustResolver.isRememberMe(SecurityContextHolder.context?.authentication),
                        postUrl: "${request.contextPath}${config.apf.filterProcessesUrl}"]
    }

    /**
     * Callback after a failed login. Redirects to the auth page with a warning message.
     */
    def authfail() {

        String msg = ''
        def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
        if (exception) {
            if (exception instanceof AccountExpiredException) {
                msg = g.message(code: "springSecurity.errors.login.expired")
            }
            else if (exception instanceof CredentialsExpiredException) {
                msg = g.message(code: "springSecurity.errors.login.passwordExpired")
            }
            else if (exception instanceof DisabledException) {
                msg = g.message(code: "springSecurity.errors.login.disabled")
            }
            else if (exception instanceof LockedException) {
                msg = g.message(code: "springSecurity.errors.login.locked")
            }
            else {
                msg = g.message(code: "springSecurity.errors.login.fail")
            }
        }

        if (springSecurityService.isAjax(request)) {
            render([error: msg] as JSON)
        }
        else {
            flash.message = msg
            redirect action: 'auth', params: params
        }
    }

    /**
     * The Ajax success redirect url.
     */
    def ajaxSuccess() {
        render([success: true, username: springSecurityService.authentication.name] as JSON)
    }

    /**
     * The Ajax denied redirect url.
     */
    def ajaxDenied() {
        render([error: 'access denied'] as JSON)
    }












    /* def index() {
         if (session.user) {
             forward(controller: "user", action: "index")
         } else {
             List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
             render(view: 'home', model: [recentShares: recentShares])
         }
     }

     def login(String username, String password) {
         User user = User.findByUsernameAndPassword(username, password)
         if (user) {
             if (user.active) {
                 session.user = user
                 redirect(controller: 'user', action: 'index')
             } else {
                 flash.error = 'Your account is not active'
             }
         } else {
             flash.error = 'User not found'
             render flash.error
         }
     }

     def logout() {
         session.invalidate()
         forward(action: "index")
     }


     def validateUserName(){
         Integer numUser = User.countByUsername(params.username)
         log.info params.username
         Boolean result = numUser ? false : true

         render result

     }

     def validateEmail(){
         Integer numEmail = User.countByEmail(params.email)
         log.info params.email
         Boolean result1 = numEmail ? false : true

         render result1
     }
 */
}
