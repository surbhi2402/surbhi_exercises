//10. Create a file which contains all the odd numbered lines of a given file. 
//Each line should be numbered at the beginning of line viz : 1, 3, 5..... 



File f1=new File("/home/surbhi/Desktop/abcd1")
File existing=new File("/home/surbhi/Desktop/abcd")

if(existing.exists())
{
   existing.eachWithIndex{String line, Integer index ->
                                       if(index%2!=0)
                                       {
                                        f1.append(index+":"+line);
                                       }                                    
   }
}

else{
println "hello"

}
