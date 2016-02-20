//13. We have a sorted list of alphabets a-z, print all alphabets appearing after j

 Range r = 'a'..'z'
r.each{it->
    if(it > 'j')
        print "${it} \t"
}