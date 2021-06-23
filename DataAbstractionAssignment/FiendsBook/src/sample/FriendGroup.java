package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

public class FriendGroup {
    private String name;
    private ListView<Friend> friendsList = new ListView<>();

    //constructor
    FriendGroup(String name){
        this.name = name;
    }


    //add friends to list
    public void addFriend(Friend selectedFriend) {
        friendsList.getItems().add(selectedFriend);
    }

    //delete friend from list
    public void deleteFriend(Friend selectedFriend) {
        friendsList.getItems().remove(selectedFriend);
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListView<Friend> getFriendList() {
        return friendsList;
    }

    public void setFriendList(ListView<Friend> friendList) {
        this.friendsList = friendList;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
