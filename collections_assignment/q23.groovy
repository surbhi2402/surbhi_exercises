/*23. Consider the following map: 
Map m = [‘Computing’ : [‘Computing’ : 600, ‘Information Systems’ : 300], 
‘Engineering’ : [‘Civil’ : 200, ‘Mechanical’ : 100], ‘Management’ : [‘Management’ : 800] ]

23 a) How many university departments are there?

23 b) How many programs are delivered by the Computing department? 

23 c) How many students are enrolled in the Civil Engineering program?*/


Map m = ["Computing":['Computing':600,'InformationSystems':300],'Engineering':['Civil':200,'Mechanical':100],'Management':['Management':800]]
        
        //a)
       println m.keySet()
       
       //b)
      // m.containsKey('Computing')
        println "How many programs are delivered by the Computing department?:"+m.get('Computing')?.keySet()?.size()

        println "How many programs are delivered by the Computing department?:"+m.get('Engineering')?.get('Civil')        
       
     
     