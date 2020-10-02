package dtos;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private String name;
    private int code;

    public CourseDTO(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public CourseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
