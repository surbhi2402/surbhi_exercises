/*10. Consider the following piece of code: String s = "this string needs to be split" 
println s.tokenize(" ") println s.tokenize() 
Compare this with the following code: String s = "this string needs to be split" 
println s.split(" ") println s.split(/\s/) (Try Same Parameter with tokenize)
 Also try the following exercise: String s = "are.you.trying.to.split.me.mister?" s.tokenize(".") s.split(".")*/
 
 String s = "this string needs to be split"
         println "Tokenize"+"->"+s.tokenize(" ") 
         println "Tokenize"+" "+ s.tokenize()
         println s.tokenize().getClass()
         
      //split
       println "Split"+":"+ s.split(" ") 
       println "Split"+" "+s.split(/\s/)
      println s.split().getClass()
      
      println "tokenize with regex"+s.tokenize(/\s/)
       
        String s1 = "are.you.trying.to.split.me.mister?"
            println s1.tokenize(".")
             println s1.split(".")