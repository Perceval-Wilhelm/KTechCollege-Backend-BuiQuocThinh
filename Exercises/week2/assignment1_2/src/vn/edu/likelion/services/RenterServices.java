package vn.edu.likelion.services;

import vn.edu.likelion.model.Book;
import vn.edu.likelion.model.Renter;

public interface RenterServices {
    void addRenter(Renter renter);
    void editRenter(Renter renter, String edit, String choiceEditRenter);
    void removeRenter(Renter renter);
    Renter findRenterById(int id);
    void showAllRenter();
}
