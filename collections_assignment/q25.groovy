//25. Write a method which retruns the value of passed key 
//from a search string of the form "http://www.google.com?name=johny&age=20&hobby=cricket" 


       
    def findKeys={string ->
    string.tokenize('?')[1].tokenize('&').each{
    println it.tokenize('=')[0]
    }
}

findKeys("http://www.google.com?name=johny&age=20&hobby=cricket")
        
        
        
        
//      
//     String getParameter(String url, String key){
//        String[] parameters = url.substring(url.indexOf("?")+1).split("&");
//        Map<String,String> parametersMap = [:];
//        for(element in parameters) {
//        String[] pair = element.split("=")
//        parametersMap[pair[0]] = pair[1];
//        }
//
//    return parametersMap[key];
//    }
//    
//String url = "http://www.google.com?name=johny&age=20&hobby=cricket" 
//
//
//println getParameter(url,'name')
//        
//        
//
//        