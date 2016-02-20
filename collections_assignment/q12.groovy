//12. Print the table of a given number : 2 and 12

    /*int num1=2,num2=12
   
     println "****Table of 2*****"
    10.times{
        println num1+"*"+it+"="+it*num1
    }
    
    println "****Table of 12*****"
     10.times{
        println num2+"*"+it+"="+it*num2
    }*/
    
    
    Range r = 1..10
r.each{it->
    print "${it*2}\t"
}
print "\n"
r.each{it->
    print "${it*12}\t"
}