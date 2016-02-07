/*16. Consider a class named "Stack" that holds a list of objects and has the following operations associated: 
1) POP - Pops the last element off the stack 
2) PUSH - Pushes an element on top of the stack 
3) TOP - Returns the element at the top of the list Implement the aforesaid class*/

        class stack{
                   // int a[]=new int[10]
                    List l1=[]
                    int tos  
                    
                    def push = { item -> if(tos==9)
                    println "stack full"
                    
                    else {
                    l1.add(item)
                    }
                    }
        }
        
        push(1)