package de.softan.mycontacts.db.entity;

public class User {

    private int Id;

    private String lastName;

    private String firstName;

    private String photoProfile;

    public String getPhotoProfile() {
        return "hello";
//        if(TextUtils.isEmpty(photoProfile)) {
//            //return "default";
//        }
       // return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
            this.photoProfile = photoProfile;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String mLastName) {
        this.lastName = mLastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String mFirstName) {
        this.firstName = mFirstName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int mId) {
        this.Id = mId;
    }

    @Override
    public String toString() {
        return getFirstName() + getLastName();
    }
}
