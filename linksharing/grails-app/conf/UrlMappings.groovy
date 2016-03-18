class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "login",action: "index")
      // "/topic"(controller: "topic",action: "index")
        "500"(view:'/my500')
        "404"(view:'/my404')
        "/public/topic/show"(controller: 'topic' ,action: 'show')
//    "/"(view: "/index")

	}
}
