class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "login",action: "index")
      // "/topic"(controller: "topic",action: "index")
        "500"(view:'/error')


	}
}
