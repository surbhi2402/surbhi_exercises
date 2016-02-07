/*5. Groovy Truth: if('test')
 { printlnn "test evaluated to true inside if" }
  try replacing test with various objects and observe its behaviour. 
  a) "Test" b)'null' c) null d) 100 e) 0 f) empty list g) list with all vaues as null List list = new ArrayList()
*/




if("Test")
{
println "test evaluated to be true!!!!"
}

if("null")
{
println "test evaluated to be true!!!!"
}

if(null)
{
println "test evaluated to be true!!!!"
}
else {println "false"}

if(100)
{
println "test evaluated to be true!!!!"
}
else {println "false"}

if(0)
{
println "test evaluated to be true!!!!"
}
else {println "false"}

 List<String> nullList = null;

if(nullList)
    {
println "test evaluated to be true!!!!"
}
else {println "false"}

List list = new ArrayList()
if(list)
    {
println "test evaluated to be true!!!!"
}
else {println "false"}

