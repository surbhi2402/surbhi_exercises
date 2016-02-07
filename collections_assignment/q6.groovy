//6. Remove all records from a list whose index is odd

        List list1 = [1,2,3,4,5,6,7,8,9]
        List list2=[]
        int length = list1.size()
      
       // println list1
            list1.eachWithIndex{v, index -> if(index%2 !=0)
                                            {
                                            list2.add(v)
                                            }
                                            }
                              print "Odd Elemets->" println list2
                                    list1 = list1-list2
                                    print "Even Elements->"
                                   println list1
                                            
                                           
                            
                                
                               