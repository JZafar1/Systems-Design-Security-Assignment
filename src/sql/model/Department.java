package src.sql.model;

public class Department {
    String code;
    String name;

    public Department (String code, String name){
        this.code = code;
        this.name = name;
    }
    public String getCode() { return code; }
    public String getName() { return name; }
}