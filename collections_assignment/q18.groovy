//18. Iterate over the previous map in as many ways as possible

        
        def map=[:]
        map.put('surbhi',22)
        map.put('shalika',23)
        map.put('saloni',23)
        map.put('vidhi',50)
        map.put('sameer',29)
        map.put('rahul',20)
        map.put('pawan',27)
        map.put('sakshi',21)
        map.put('nitin',26)
        map.put('saksham',24)
        println map
        
        //iterating over map with map[key]
        
       println map['surbhi']
       println map.get('shalika')
       println map.'surbhi'
        
        //map.contains(key)
       println map.containsKey('saksham')
         println  map.keySet()
           
//       println map.containsValue(22)
//       println map.values()
//       
//       //find
//       
//      println map.find{'surbhi'}
//    map.each{println it}
//    
//    map.eachWithIndex{key,value -> println key 
//                                    println value}
//                                    
//                                    println map.toMapString()
//        