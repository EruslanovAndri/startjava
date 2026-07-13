package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.MenuCommandException;

public class BookcaseTest {
    public static void main(String[] args) {
//        try {
//            MenuCommand menuCommand = MenuCommand.fromId(10);
//            switch (menuCommand) {
//                case ONE -> System.out.println("Processing ONE");
//                case TWO -> System.out.println("Processing TWO");
//            }
//        } catch (MenuCommandException e) {
//            System.out.println(e.getMessage());
//        }


        BookcaseHandler bookcaseHandler = new BookcaseHandler();
        while (true) {
            bookcaseHandler.run();
        }
    }
}
