package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public TextField firstNameInput;
    public TextField lastNameInput;
    public TextField ageInput;
    public TextField favoriteColorInput;
    public Button addBtn;
    public Button deleteBtn;
    public ListView<Friend> friendsList = new ListView<>();
    public Label firstNameLbl;
    public Label lastNameLbl;
    public Label ageLbl;
    public Label favoriteColorLbl;

    //add friends to list
    public void addFriend(ActionEvent actionEvent) {
        //get friend info
        Friend temp = new Friend();
        temp.setFirstName(firstNameInput.getText());
        temp.setLastName(lastNameInput.getText());
        temp.setAge(Integer.parseInt(ageInput.getText()));
        temp.setFavoriteColor(favoriteColorInput.getText());
        //add to list
        friendsList.getItems().add(temp);
        //clear text fields
        firstNameInput.clear();
        lastNameInput.clear();
        ageInput.clear();
        favoriteColorInput.clear();
    }

    //delete friend from list
    public void deleteFriend(ActionEvent actionEvent) {
        //get selected person
        Friend temp;
        temp = friendsList.getSelectionModel().getSelectedItem();
        //delete from list
        friendsList.getItems().remove(temp);
        //clear friend info display
        firstNameLbl.setText("");
        lastNameLbl.setText("");
        ageLbl.setText("");
        favoriteColorLbl.setText("");
        //disable delete button
        deleteBtn.setDisable(true);
    }

    //display friend info
    public void displayFriends(MouseEvent editEvent) {
        //get friend info of selected friend + print info
        Friend temp;
        temp = friendsList.getSelectionModel().getSelectedItem();
        firstNameLbl.setText(temp.getFirstName());
        lastNameLbl.setText(temp.getLastName());
        ageLbl.setText(String.valueOf(temp.getAge()));
        favoriteColorLbl.setText(temp.getFavoriteColor());
        //enable delete button
        deleteBtn.setDisable(false);
    }

    //update friends list
    public void updateFriendsList(ListView.EditEvent<Friend> friendEditEvent) {
        //clear list
        //reprint list with up to date info
        for(int i = 0; i < friendsList.getItems().size(); i++){
            System.out.println(friendsList.getItems().get(i));
        }
    }
}
