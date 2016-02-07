//11. Write a method which removes all the white spaces in a file and 
//writes the output to another file. Suppose white space characters are Space, Tab and Enter 



File f1=new File("/home/surbhi/Desktop/abcd")
File nwFile=new File("/home/surbhi/Desktop/abcd1")


if(f1.exists())
    {
    String fileContents = f1.text
    String contents = fileContents.replaceAll("\\s","")
    nwFile.append('contents')
    }