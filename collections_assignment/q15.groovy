/*15. Write a program that prints the numbers from 1 to 100.
 But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
 For numbers which are multiples of both three and five print "FizzBuzz".*/
 
        for(x in (1..100)){
        
        if((x%3==0) & (x%5==0)){
        println x +"->"+ "FizzBuzz"
        }
        else if(x%5==0)
        println x +"->"+ "Buzz"
        
        else if(x%3==0)
        println x +"->"+"Fizz"
        
        else
        println x
        }