package strategy;

import lombok.Getter;

@Getter
public class Client {
    public static int count = 0;
    //private final int id;
    private String name;
    private String email;
    private int age;
    public  Client(String name, String email) {
        ++count;
        this.name = name;
        this.email = email;

    }
}
