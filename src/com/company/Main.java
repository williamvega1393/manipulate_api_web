package com.company;

import com.company.controllers.PersonController;

public class Main {

    public static void main(String[] args) {
        PersonController personController = new PersonController();
        personController.deletePerson();
    }
}
