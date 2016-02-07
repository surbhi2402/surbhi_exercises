/* 6. Write a class HourMinute where the class stores hours and minutes
 as separate fields. Overload + and - operator operator for this class 
*/


class HourMinute{
    int hours;
    int minutes;
    
    HourMinute plus (HourMinute obj){
        println "plus called"
        println "this -> " + this
        println "obj ->" + obj
        println ">>>>>>>>.."
        HourMinute temp=new HourMinute()
        temp.hours=this.hours+obj.hours
        temp.minutes=this.minutes+obj.minutes
        temp
    }
    
    HourMinute minus (HourMinute obj){
        println "minus called"
        println "this -> " + this
        println "obj ->" + obj
        println ">>>>>>>>.."
        HourMinute temp=new HourMinute()
        temp.hours=this.hours-obj.hours
        temp.minutes=this.minutes-obj.minutes
        temp
    }
    
    String toString(){
        "$hours is hours and $minutes is minutes"
    }
}

HourMinute hr1=new HourMinute(hours:5,minutes:60)
HourMinute hr2=new HourMinute(hours:6,minutes:40)
HourMinute hr3=hr1+hr2
HourMinute hr4=hr1-hr2

println "h3 -> ${hr3}"
println "h4 -> ${hr4}"