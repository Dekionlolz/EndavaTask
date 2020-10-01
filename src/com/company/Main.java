//1) Create class User that will contain the following info:
//
//        firstname
//        lastname
//        age
//        email
//        status (ACTIVE, INACTIVE, BLOCKED, NEW)
//        timestamp (when user was registered in the system)
//
//        Add contructor with all parameters, getters, setters, custom toString method.
//
//        2) create class Application with main method.
//
//        In this main method you should do the following:
//        - create list of users. To create users - use constructor with all parameters.
//        You can use array or ArrayList(prefferably).
//        Some of the created users should have status as NEW.
//
//        - iterate through the list of users and change status to ACTIVE for NEW users
//        whose timestamp when they were registered in the system is older than yesterday.
//        You can extract this functionality into a separate method
//
//        - BONUS TASK: write a method that will pick up INACTIVE users that where registered more than 1 month ago and set their status to BLOCKED
//
//        All resulting lists you should display in console!

package com.company;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Mihai","Nistor","mihai.nistor@mail.ru",30,
                Timestamp.valueOf(LocalDateTime.now().minusDays(1)), Status.NEW ));//set as new - turned to active
        userList.add(new User("Ion","Atamanenco","ion.atamanenco@mail.ru",21,
                Timestamp.valueOf(LocalDateTime.now().minusMonths(2)), Status.ACTIVE ));
        userList.add(new User("Grigore","Crudu","grigore.crudu@mail.ru",63,
                Timestamp.valueOf(LocalDateTime.now()), Status.NEW ));
        userList.add(new User("Artur","Cazac","artur.cazac@mail.ru",77,
                Timestamp.valueOf(LocalDateTime.now().minusMonths(2)), Status.INACTIVE ));//set as inactive - turned to blocked
        userList.add(new User("Daniela","Munteanu","daniela.munteanu@mail.ru",21,
                Timestamp.valueOf(LocalDateTime.now()), Status.NEW ));
        userList.forEach((user ->{

            if (user.getStatus().equals(Status.NEW) && user.getTimestamp().before(User.yesterday())){
                user.setStatus(Status.ACTIVE);
            }
            if (user.getStatus().equals(Status.INACTIVE) && user.getTimestamp().before(User.month())){
                user.setStatus(Status.BLOCKED);
            }

        }));
        userList.forEach(user -> {
            System.out.println(user.toString());
        });

    }

}
