package dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by Pravar on 6/21/2016.
 */
public interface PatientDao {

//    @SqlUpdate("create table patient valu (id int primary key, name varchar(100))")
//    void createSomethingTable();
//    h.execute("insert into patient values('" + patient.fullname + "', '" + patient.pid + "', '" +
//    patient.address + "', '" +patient.desc + "'," + patient.contact + ", '" +patient.gender + "'," +patient.weight +
//            ", '" +patient.age + "', '" + patient.room + "')");
    @SqlUpdate("insert into patient values (:fullname, :pid, :address, :desc, :phno, :gender, :weight, :age, :room)")
    void insert(@Bind("fullname") String fullname,
                @Bind("pid") String pid,
                @Bind("address") String address,
                @Bind("desc") String desc,
                @Bind("phno") Integer phno,
                @Bind("gender") String gender,
                @Bind("weight") Integer weight,
                @Bind("age") String age,
                @Bind("room") String room
                );

//    @SqlQuery("select name from something where id = :id")
//    String findNameById(@Bind("id") int id);

    /**
     * close with no args is used to close the connection
     */
    void close();
}
