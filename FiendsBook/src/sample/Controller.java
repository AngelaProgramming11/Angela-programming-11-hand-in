package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.*;

public class Controller {
    public TextField firstNameInput;
    public TextField lastNameInput;
    public TextField ageInput;
    public TextField favoriteColorInput;
    public Button addFriendBtn;
    public Button removeBtn;
    public Label firstNameLbl;
    public Label lastNameLbl;
    public Label ageLbl;
    public Label favoriteColorLbl;
    public TextField groupNameInput;
    public Button addGroupBtn;
    public ListView<FriendGroup> groupList = new ListView<>();
    public ListView<FriendGroup> groupList2 = new ListView<>();
    public ListView<Friend> selectedFriendsList = new ListView<>();
    public FriendGroup selectedGroup;
    public VBox friendInfoDisplay;
    public Button deleteBtn;
    public Label selectGroupLbl;
    public Button backBtn;
    public Label selectedGroupLbl;
    public Label groupLbl;

    //extract file info
    public void initialize() throws IOException{
        //open file containing all friends
        //in case file doesn't exist
        FileWriter fw = new FileWriter("All.txt", true);
        fw.close();
        FileReader fr = new FileReader("All.txt");
        BufferedReader br = new BufferedReader(fr);
        FriendGroup tempFriendGroup = new FriendGroup("All");
        String line;
        //store friends info
        while((line = br.readLine()) != null){
            String array[] = line.split(",");
            Friend temp = new Friend(array[0], array[1], Integer.parseInt(array[2]), array[3]);
            tempFriendGroup.addFriend(temp);
        }
        groupList.getItems().add(tempFriendGroup);
        groupList2.getItems().add(tempFriendGroup);
        br.close();
        //get group files
        fw = new FileWriter("AllFriendGroups.txt", true);
        fw.close();
        fr = new FileReader("AllFriendGroups.txt");
        br = new BufferedReader(fr);
        String groupName;
        while((groupName = br.readLine()) != null){
            FileReader fr2 = new FileReader(groupName + ".txt");
            BufferedReader br2 = new BufferedReader(fr2);
            tempFriendGroup = new FriendGroup(groupName);
            String line2;
            while((line2 = br2.readLine()) != null){
                //get friend info
                String tempArray[] = line2.split(",");
                Friend tempFriend = new Friend(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), tempArray[3]);
                tempFriendGroup.getFriendList().getItems().add(tempFriend);
            }
            tempFriendGroup.setName(groupName);
            groupList.getItems().add(tempFriendGroup);
            groupList2.getItems().add(tempFriendGroup);
            br2.close();
        }
        br.close();
    }

    //add friend
    public void addFriend(ActionEvent actionEvent) throws IOException {
        if(firstNameInput.getLength() != 0 && lastNameInput.getLength() != 0 && ageInput.getLength() != 0 && favoriteColorInput.getLength() != 0) {
            //get friend info
            Friend temp = new Friend();
            temp.setFirstName(firstNameInput.getText());
            temp.setLastName(lastNameInput.getText());
            temp.setAge(Integer.parseInt(ageInput.getText()));
            temp.setFavoriteColor(favoriteColorInput.getText());
            //add to list + file
            if (groupList.getSelectionModel().getSelectedItem() != null && groupList.getSelectionModel().getSelectedItem() != groupList.getItems().get(0)) {
                int groupIndex;
                groupIndex = groupList.getItems().indexOf(selectedGroup);
                groupList2.getItems().get(groupIndex).addFriend(temp);
                addToFile(temp);
            }
            //if no group is selected, add to 'all' list
            selectedGroup = groupList2.getItems().get(0);
            groupList2.getItems().get(0).addFriend(temp);
            addToFile(temp);
            //clear text fields
            firstNameInput.clear();
            lastNameInput.clear();
            ageInput.clear();
            favoriteColorInput.clear();
            groupList.getSelectionModel().clearSelection();
        }
    }

    //remove from group
    public void removeFromGroup(ActionEvent actionEvent) throws IOException{
        //get selected person
        Friend temp;
        temp = selectedFriendsList.getSelectionModel().getSelectedItem();
        //delete from list
        int groupIndex = groupList.getItems().indexOf(selectedGroup);
        groupList2.getItems().get(groupIndex).deleteFriend(temp);
        selectedGroup.deleteFriend(temp);
        selectedFriendsList.getItems().remove(temp);
        //clear friend info display
        firstNameLbl.setText("");
        lastNameLbl.setText("");
        ageLbl.setText("");
        favoriteColorLbl.setText("");
        //remove friend from group file
        removeFromFile(selectedGroup, (selectedGroup.getName() + ".txt"));
        //disable delete button
        removeBtn.setDisable(true);
        deleteBtn.setDisable(true);
        clearDisplay();
        selectedFriendsList.getSelectionModel().clearSelection();
    }

    //delete friend
    public void delete(ActionEvent actionEvent) throws IOException{
        //get selected person
        Friend temp;
        temp = selectedFriendsList.getSelectionModel().getSelectedItem();
        //delete from list
        groupList2.getItems().get(0).deleteFriend(temp);
        selectedGroup.deleteFriend(temp);
        selectedFriendsList.getItems().remove(temp);
        //clear friend info display
        firstNameLbl.setText("");
        lastNameLbl.setText("");
        ageLbl.setText("");
        favoriteColorLbl.setText("");
        //delete from file
        removeFromFile(selectedGroup, (selectedGroup.getName() + ".txt"));
        //disable delete button
        removeBtn.setDisable(true);
        deleteBtn.setDisable(true);
        clearDisplay();
        selectedFriendsList.getSelectionModel().clearSelection();
    }

    //display friend info (name, age, favorite color)
    public void displayFriends(MouseEvent editEvent) {
        //get friend info of selected friend + print info
        if(selectedFriendsList.getSelectionModel().getSelectedItem() != null) {
            Friend temp;
            temp = selectedFriendsList.getSelectionModel().getSelectedItem();
            firstNameLbl.setText(temp.getFirstName());
            lastNameLbl.setText(temp.getLastName());
            ageLbl.setText(String.valueOf(temp.getAge()));
            favoriteColorLbl.setText(temp.getFavoriteColor());
            //enable delete buttons
            if(!selectedGroup.getName().equals("All")){
                removeBtn.setDisable(false);
            }
            deleteBtn.setDisable(false);
        }
    }
    //clear friend info display
    public void clearDisplay(){
        //clear display
        firstNameLbl.setText("");
        lastNameLbl.setText("");
        ageLbl.setText("");
        favoriteColorLbl.setText("");
    }

    //remove from file
    public void removeFromFile(FriendGroup group, String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        //clear file
        fw.write("");
        //rewrite entire file
        for(int i = 0; i < group.getFriendList().getItems().size(); i++){
            addToFile(group.getFriendList().getItems().get(i));
        }
        fw.close();
    }

    //add group
    public void addGroup(ActionEvent actionEvent) throws IOException{
        //add to group list
        if(groupNameInput.getText().length() != 0) {
            FriendGroup temp = new FriendGroup(groupNameInput.getText());
            groupList.getItems().add(temp);
            groupList2.getItems().add(temp);
            //add to file containing all groups
            FileWriter fw = new FileWriter("AllFriendGroups.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(groupNameInput.getText());
            bw.newLine();
            bw.close();
            //create group file
            fw = new FileWriter(groupNameInput.getText() + ".txt");
            fw.close();
            //clear text field
            groupNameInput.clear();
        }
    }

    //record selected group for other methods
    public void selectGroup(MouseEvent mouseEvent) {
        //record selected group
        if(groupList.getSelectionModel().getSelectedItem() != null) {
            selectedGroup = groupList.getSelectionModel().getSelectedItem();
        }
    }

    //add friend to file
    public void addToFile(Friend friend) throws IOException{
        FileWriter fw = new FileWriter(selectedGroup.getName() + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(friend.getFirstName() + "," + friend.getLastName() + "," + friend.getAge() + "," + friend.getFavoriteColor());
        bw.newLine();
        bw.close();
    }

    //list out friends in a group
    public void displayFriendGroup(MouseEvent mouseEvent){
        //make sure a friend group is selected
        if(groupList2.getSelectionModel().getSelectedItem() != null) {
            //make invisible group list display, make visible friend list
            selectedGroup = groupList2.getSelectionModel().getSelectedItem();
            //make sure remove button is disabled when viewing all friends otherwise the friend in "All" will be removed but not other groups
            if(selectedGroup.getName().equals("All")){
                selectedGroupLbl.setVisible(false);
                groupLbl.setVisible(false);
            }
            selectedGroupLbl.setText(selectedGroup.getName());
            groupList2.setVisible(false);
            selectGroupLbl.setVisible(false);
            selectedFriendsList.setVisible(true);
            friendInfoDisplay.setVisible(true);
            removeBtn.setDisable(true);
            deleteBtn.setDisable(true);
            selectedFriendsList.getItems().clear();
            //load friends list into friends listview
            for(int i = 0; i < selectedGroup.getFriendList().getItems().size(); i++){
                selectedFriendsList.getItems().add(selectedGroup.getFriendList().getItems().get(i));
            }
            groupList2.getSelectionModel().clearSelection();
        }
    }

    //exit friends list, go to groups display
    public void backToGroups(MouseEvent mouseEvent) {
        //make visible group list display, make invisible friend list
        groupList2.setVisible(true);
        selectGroupLbl.setVisible(true);
        selectedFriendsList.setVisible(false);
        friendInfoDisplay.setVisible(false);
        removeBtn.setDisable(false);
        selectedGroupLbl.setVisible(true);
        groupLbl.setVisible(true);
        clearDisplay();
    }
}
