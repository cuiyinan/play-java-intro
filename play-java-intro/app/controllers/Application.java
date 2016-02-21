package controllers;
import play.*;
import play.db.ebean.Transactional;
import play.mvc.*;
import views.html.*;
import models.Person;
import play.data.Form;
import java.util.List;
import static play.libs.Json.*;


public class Application extends Controller {

    @Transactional
    public Result index() {
        String title="Play Sample Page";
        String msg="フォームのサンプルです";
        List<Person> persons  = Person.FIND.findList();
        return ok(index.render(title,msg, persons));
    }
    @Transactional
    public Result addPerson() {
        // Person person = Form.form(Person.class).bindFromRequest().get();
        // JPA.em().persist(person);
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }
}