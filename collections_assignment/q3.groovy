//Q3. Create a set from a list containing duplicate elements. 
//What do you observe? How can you achieve the same result without converting a list to a set?

List l1=[1,2,3,3,3,2,2,1,2,1,1]

            println l1 as Set
                //does not alter the original list
                    println l1

    //Set has unique elements. no duplicates!

//without converting to set..
            

   println l1.unique()
   
   //it alters the original list
               println l1