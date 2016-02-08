//8. Write a closure which checks if a value is contained within a list where the closure accepts two parameters 



def check={a,b -> a.contains(b)}
List l=[1,2,3,4]

println check(l,2);