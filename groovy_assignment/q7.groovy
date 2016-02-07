//7. Print multiple of 3 upto 10 terms in at least three different ways using groovy special methods 




for(int i=1;i<=10;i++)
{
int k=3*i
println "3 * $i = $k"
}

1.upto(10) {println it*3}


10.times{ println it*3 }
  
1.step 11,1,{println it*3} 