package acs.tasklist;

import java.util.ArrayList;

public class ShoppingO extends OtherO{
    ArrayList<String> list;
    public void addItem(String input){
        list.add(input);
    }
    public String getList(){
        String temp="";
        for (int i=0; i<list.size(); i++){
            if (i==list.size()-1){
                temp += list.get(i);
            }
            else{
                temp += list.get(i)+" ";
            }
        }
        return temp;
    }
    @Override
    public String formatInfo(){
        return desc+"   "+getList()+"   "+duedate;
    }
}
