//14. Find the number of occurences of a character in a string

    String s="This is a string"
        
            int len=s.length()
          
          for(x in (0..len-1))
          {
          int count=0
          for (y in (1..len-2))
          {
          if(s.charAt(x).equals(s.charAt(y)))
          count++
          }
          print s.charAt(x)
          print "  "
          println count
          }