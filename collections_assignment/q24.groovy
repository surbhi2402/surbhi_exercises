/*24. Conside a class named "Employee" which has the following properties: 
1) Name 2) Age 3) DepartmentName 4) EmployeeNumber 5) Salary 
Let's say that there's a list of 50 employees available.
 Perform the following operations on the list of employees: 
 a) Group the employees on the basis of the bracket in which their salary falls. The ranges are 0-5000, 5001 and 10000, and so on. 
 b) Get a count of the number of employees in each department 
 c) Get the list of employees whose age is between 18 and 35 
 d) Group the employees according to the alphabet with which their first name starts 
 and display the number of employees in each group whose age is greater than 20 
 e) Group the employees according to their department.*/
 
 
             class Employee{
             String name
             int age
             String deptName
             int empNo
             int salary
             }
             List<Employee> l1=[]
             
             l1.add(new Employee(name:'surbhi',age:15,deptName:"grails",empNo:40,salary:15000))
             l1.add(new Employee(name:'alka',age:12,deptName:"grails",empNo:39,salary:25000))
             
             
             (1..50).each{
    l1.add(new Employee(age:(it+20),name:("surbhi"+it),deptName:("grails"+it),empNo:it,salary:(it*1000)));
             }
        println "*********part 1********"     
            Map m1= l1.groupBy{
             if(it.salary<=10000)
             "0 to 10000"
             
             else if(it.salary>10000 || it.salary<=20000)
             "10001 to 20000"
             
            else if (it.salary>20000 || it.salary<=30000)
            "20001 to 30000"
            
            else
            "Above 30001"  
           }
           
           m1.each{println it}
           
           
           println "******part 2*********"
           
      Map<String,Integer> departmentTotalEmployee =[:];
 l1.each{
     if(departmentTotalEmployee.containsKey(it.deptName)){
         departmentTotalEmployee[it.deptName]= departmentTotalEmployee.get(it.deptName)+1;
     }else{
         departmentTotalEmployee[it.deptName]=1;
     }
 }

 departmentTotalEmployee.each{
     println it
 }
        /*   println "*****part 3******"
           
           l1.each{
           if(it.age>=18 && it.age<=35)
           {
           println it.name
           }
           }
           
           println "*******part 4******"
           
           println l1.sort { 
            it.name.charAt(0)}*.name
            
            println "age>20" + l1.findAll{it.age >20}*.name
            
            println "******part 5*********"
            
            Map m2=l1.groupBy{
            it.deptName
            }
            
            println m2*/
            
            
            
            
            
            
            
            
           
           
           
           
 