package models;
import javax.persistence.*;
import com.avaje.ebean.Model;
@Entity
public class Person extends Model {
    @Id
    public Long id;

    public String name;
    public static Model.Finder<Long, Person> FIND = new Model.Finder<>(Person.class);
}