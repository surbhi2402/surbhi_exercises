/*9. Consider a class Employee with following details * Name * Age * Salary 
Create a list consisting of 10 Employee objects. 
6(a). Get a list of employees who earn less than 5000
6(b). Get the name of the youngest employee and oldest employee 
6(c). Get the employee with maximum salary 
6(d). Get the list of names of all the employees*/

        class Employee{
        String name
        Integer age
        Integer salary
                      }
           
           //6(a). Get a list of employees who earn less than 5000
           
              def list1=[new Employee([name:"surbhi",age:22,salary:15000]),new Employee([name:"shalika",age:23,salary:25000]),
              new Employee([name:"nitin",age:23,salary:10000]),
              new Employee([name:"somil",age:24,salary:5000]),
              new Employee([name:"saksham",age:22,salary:2500]),
              new Employee([name:"saloni",age:21,salary:40000]),
              new Employee([name:"sakshi",age:23,salary:30000]),
              new Employee([name:"sameer",age:50,salary:50000]),
              new Employee([name:"vikas",age:30,salary:4800]),
              new Employee([name:"swati",age:29,salary:22000])]
              
              println list1.findAll{it.salary < 5000}*.name
              
              //6(b). Get the name of the youngest employee and oldest employee 
              
              println list1.min{it.age}*.name
                println list1.max{it.age}*.name              
              
             // 6(c). Get the employee with maximum salary 
             
             println list1.max{it.salary}*.name
             
            // 6(d). Get the list of names of all the employees
            
            println list1*.name
             
              