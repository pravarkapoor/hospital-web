package forms;

import play.data.validation.Constraints;

public class Patient {
    public String fullname;
    @Constraints.Required
    public String pid;
    public String age;
    public Integer weight;
    public Integer contact;
    public String desc;
    public String address;
    public String gender;
    public String room;
}
