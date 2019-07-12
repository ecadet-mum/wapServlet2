import java.util.*;

public class UserData {
    HashMap<Integer,User> listUser=new HashMap<Integer, User>();

    public UserData(){
        User e1=new User("ecadet","mum123");
        User e2=new User("cpaul","mum123");
        listUser.put(1001,e1);
        listUser.put(1002,e2);
    }
    public void addUser(User usr){
        Integer num=new Random().nextInt();
        listUser.put(num,usr);
    }

    public boolean searchUser(User e){

        for(Integer key: listUser.keySet()){
            User ur=listUser.get(key);
            if(ur.equals(e)){
                return true;
            }
        }

        return false;
    }


}
