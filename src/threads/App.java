package threads;

import backend.Session;
import backend.Uuid;

public class App{
    public static void main(String[] args){
        Session.SessionStart();
        Threads.view("Login");
//        Threads.view("TambahUsers");
    }
}
