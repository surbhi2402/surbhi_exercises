//12. Make copy of an image type file byte by byte


File abc=new File("/home/surbhi/Desktop/image1.jpg")
File f1=new File("/home/surbhi/Desktop/copy1")


if(abc.exists())
{
byte[] bytes=abc.getBytes()
f1.append(bytes)

}


