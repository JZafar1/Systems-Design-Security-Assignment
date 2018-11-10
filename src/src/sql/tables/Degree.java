package src.sql.tables;

public class Degree {
    
    String code;
    String name;
    String yearInIndustry;
    String levelOfStudy;

    public Degree(String code, String name, String yearInIndustry, String levelOfStudy) {
        this.code = code;
        this.name = name;
        this.yearInIndustry = yearInIndustry;
        this.levelOfStudy = levelOfStudy;
    }
}