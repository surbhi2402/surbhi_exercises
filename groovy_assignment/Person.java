//1. Create a class in Java along with follwing fields. 
//classname: Person fields: name, age, gender, address 
//Access the fields in all known ways: like through getter , by dot operator 




    public class Person{
        protected String name,gender,address;
        protected int age;

//getters
        String getName(){
            return name;
            }

        String getGender(){
            return gender;
            }    
        
        String getAddress(){
            return address;
            }
        
        int getAge(){
            return age;
            }

//setters
        void setName(String name){
            this.name=name;
            }

        void setGender(String gender){
                this.gender=gender;
            } 

        void setAddress(String address){
                    this.address=address;
            }

        void setAge(int age){this.age=age;
            }

    }


public static void main(String[] args) {
    

    //accessing fields using . operator 
Person person=new Person()
person.name="Dummy User"
person.gender="Male"
person.address="Delhi-110032"
person.age=24


println "Accessing using . operator"
println emp.name
println emp.gender
println emp.address
println emp.age



//accessing fields using getter setter 
Person person=new Person()
person.setName("Dummy User3")
person.setGender("Male")
person.setAddress("Delhi-110032")
person.setAge(23)


println "Accessing using getter and setter"
println person.getName()
println person.getGender()
println person.getAddress()
println person.getAge()
}

