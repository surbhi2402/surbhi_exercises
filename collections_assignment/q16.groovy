/*16. Consider a class named "Stack" that holds a list of objects and has the following operations associated: 
1) POP - Pops the last element off the stack 
2) PUSH - Pushes an element on top of the stack 
3) TOP - Returns the element at the top of the list Implement the aforesaid class*/

        class Stack{
                   // int a[]=new int[10]
                    List l1=[]
                    int top=0  
                    
                    
                    boolean push( def item){ 
                    if(top==9){
                       println "stack full"
                    return false
                    }
                    else {
                      l1.add(item)
                      top++
                      return true
                    }
                    }
                    
                    def pop = {
                        def object = l1.getAt(top-1)
                        l1.remove(top-1)
                        top--
                        return object
                    }
        
            String toString(){
                return l1.toString()
            }
        }
        
       Stack stack = new Stack()
       stack.push(20)
       stack.push(40)
        stack.push(80)
       println stack
       def element = stack.pop()
       println "=====$element"
       println "=====$stack"