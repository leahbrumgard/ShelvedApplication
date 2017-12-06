package edu.swarthmore.cs.cs71.shelved.shelved.shelvedModel;

import edu.swarthmore.cs.cs71.shelved.model.simple.SimpleBook;

import java.util.*;

public class ShelvedModel {
    List<SimpleBook> bookList = new ArrayList<SimpleBook>();
    Integer userID = null;

    // listener fields
    Set<ShelfUpdatedListener> shelfUpdatedListeners = new HashSet<ShelfUpdatedListener>();
    Set<BookAddedListener> bookAddedListeners = new HashSet<BookAddedListener>();
    Set<ScanAddedListener> scanAddedListeners = new HashSet<ScanAddedListener>();

    // TODO: Need to make a method to login

    public void addBook(SimpleBook book) {
        bookList.add(book);
        notifyShelfUpdatedListeners();
        notifyBookAddedListeners(book);
    }

    public void removeBook(SimpleBook book) {
        bookList.remove(book);
        notifyShelfUpdatedListeners();
    }

    public void setShelf(List<SimpleBook> newBookList) {
        this.bookList.clear();
        this.bookList.addAll(newBookList);
        notifyShelfUpdatedListeners();
    }

    public void addScan() {
        notifyScanAddedListeners();
    }


    ///////////////// Shelf Listeners/ updaters /////////////////

    public void addShelfUpdatedListener(ShelfUpdatedListener newShelfUpdatedListener) {
        shelfUpdatedListeners.add(newShelfUpdatedListener);
    }

    private void notifyShelfUpdatedListeners() {
        for (ShelfUpdatedListener listener:this.shelfUpdatedListeners) {
            listener.shelfUpdated();
        }
    }


    ///////////////// Add book Listeners/ updaters /////////////////

    public void addBookAddedListener(BookAddedListener newBookAddedListener) {
        bookAddedListeners.add(newBookAddedListener);
    }

    private void notifyBookAddedListeners(SimpleBook book) {
        for (BookAddedListener listener:this.bookAddedListeners) {
            listener.bookAdded(book);
        }
    }


    ///////////////// Scan Listeners/ updaters /////////////////

    public void addScanListener(ScanAddedListener newScanAddedListener) {
        scanAddedListeners.add(newScanAddedListener);
    }

    public void notifyScanAddedListeners() {
        for (ScanAddedListener listener:this.scanAddedListeners) {
            listener.scanAdded();
        }
    }


    // getters

    public List<SimpleBook> getBookList() {
        return Collections.unmodifiableList(bookList);
    }

    public Integer getUserID() {
        return userID;
    }
}