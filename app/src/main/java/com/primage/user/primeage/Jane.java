package com.primage.user.primeage;

/**
 * Created by OrLak on 23/10/2015.
 */
public class Jane implements Character {
    String name = "Jane";
    String gender = "male";
    String image = "Jane.png";
    String startText = "hi, i am jane, its really nice to meet you!";

    public String getName() {

        return name;
    }
    public String getGender(){

        return gender;
    }
    public String getImage(){

        return image;
    }
    public String getStartText(){

        return startText;
    }
}
