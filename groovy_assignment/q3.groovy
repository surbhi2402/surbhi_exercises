//1.upto(10) {println it*3}


/*int temp=1;
println "*"
for(int i=1;i<4;i++)
{
    temp=1;
for(int j=1;j<=i;j++)
    temp=temp*2;

for(int k=1;k<=temp;k++)
    print "*";

print "\n"
}*/

0.upto(3){
    
   Integer stars=Math.pow(2,Integer.parseInt("${it}"))
   // println stars
    stars.times{
       print "* "}
        
    println ""
}