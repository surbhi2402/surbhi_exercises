//2. Extend the Person class in Groovy Add following fields to it:
// empId, company, salary Access the fields in all known ways: like through getter , by dot operator, by @ operator. 


class Employee extends Person
{
        String empId,company 
        int salary

        String getEmpId(){
        empId
        }

        String getCompany(){
        company
        }

        int getSalary(){
            salary
        }

        void setEmpId(String empId){
            this.empId=empId
        }
        
        void setCompany(String company){
        this.company=company
        }
        
        void setSalary(int salary){
            this.salary=salary
        }
}

//accessing fields using . operator 
Employee emp=new Employee()
emp.name="Dummy User"
emp.gender="Male"
emp.address="Delhi-110032"
emp.age=24
emp.empId="ABCDE12345"
emp.company="TECHNOSOFT"
emp.salary=10000

println "Accessing using . operator"
println emp.name
println emp.gender
println emp.address
println emp.age
println emp.empId
println emp.company
println emp.salary



//accessing fields using @ operator 
Employee emp2=new Employee()
emp2.@name="Dummy User2"
emp2.@gender="Female"
emp2.@address="Delhi-110032"
emp2.@age=23
emp2.@empId="ABCDE12346"
emp2.@company="TECHNOSOFT"
emp2.@salary=10000

println "Accessing using .@ operator"
println emp2.@name
println emp2.@gender
println emp2.@address
println emp2.@age
println emp2.@empId
println emp2.@company
println emp2.@salary



//accessing fields using getter setter 
Employee emp3=new Employee()
emp.setName("Dummy User3")
emp.setGender("Male")
emp.setAddress("Delhi-110032")
emp.setAge(23)
emp.setEmpId("ABCDE12347")
emp.setCompany("TECHNOSOFT")
emp.setSalary(10000)

println "Accessing using getter and setter"
println emp.getName()
println emp.getGender()
println emp.getAddress()
println emp.getAge()
println emp.getEmpId()
println emp.getCompany()
println emp.getSalary()

