package acs.tasklist;

import java.util.ArrayList;

public class ShoppingO extends OtherO{
    ArrayList<String> list = new ArrayList<String>();
    public void addItem(String input){
        list.add(input);
    }
    private String getList(){
        String temp="";
        for (int i=0; i<list.size(); i++){
            if (i==list.size()-1){
                temp += list.get(i);
            }
            else{
                temp += list.get(i)+", ";
            }
        }
        return temp;
    }
    @Override
    public String formatInfo(){
        return "Due: "+duedate+"\n"+"Description: "+desc+"\n"+"List: "+getList()+"\n";
    }
}
