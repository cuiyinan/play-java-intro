package controllers;
import play.db.ebean.Transactional;
import play.mvc.*;
import views.html.*;
import models.Person;
import play.data.Form;
import java.util.List;


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
        Form<Person> form = Form.form(Person.class).bindFromRequest();
        Person person = form.get();
        person.save();
        return redirect(routes.Application.index());
    }
}