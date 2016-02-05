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
