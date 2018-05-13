package acs.tasklist;

public class EventO extends OtherO{
    String loc, time;
    public void setLoc(String input){
        this.loc = input;
    }
    public void setTime(String input){
        this.time = input;
    }
    @Override
    public String formatInfo(){
        return desc+" "+loc+" "+time+" "+duedate;
    }
    @Override
    public char getID(){
        return 'E';
    }
}
