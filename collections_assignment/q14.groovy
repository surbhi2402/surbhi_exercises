//14. Find the number of occurences of a character in a string
import groovy.transform.Field

    @Field
    String s="This is a string"
        
         // int len=  s.count("i")
         
         
         def charSet = s.toCharArray().toSet()
         charSet.each{
         int count = getCountOfCharacter(it)
          println "Count of $it is:$count"
          }
          
          
       int getCountOfCharacter(char c){
          int count=1
          for (int y=0; y< s.length()-1;y++)
          {
              if(c.equals(s.charAt(y)))
                  count++
              }
           
          return count      
       }