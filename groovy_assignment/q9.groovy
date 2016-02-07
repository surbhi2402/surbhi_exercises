//9. Combine content of all the files in a specific directory to another new file 



File f1=new File("/home/surbhi/folder1.txt")
File f2=new File("/home/surbhi/Desktop/sessions/GROOVY/assignment")

if(f2.exists())
{
    f2.eachFile{
       File f->f.eachLine{
       
       String line ->f1.append(line+"\n")
       } 
        }
}
