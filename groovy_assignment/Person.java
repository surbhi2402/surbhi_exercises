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