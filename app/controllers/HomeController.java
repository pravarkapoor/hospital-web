package controllers;

import dao.PatientDao;
import forms.Patient;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import play.Logger;
import play.data.Form;
import play.mvc.*;
import play.data.FormFactory;
import views.html.*;
import dao.PatientDao;
import javax.inject.Inject;
import play.db.*;
import models.*;

import java.sql.Connection;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    @Inject
    FormFactory formFactory;
    private Database db;

    @Inject
    public HomeController(Database db) {
        this.db = db;
    }
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result index() {
        return ok(index.render("Your new application is ready."));

    }

    public Result patient() {
        return ok(patient_form.render());
    }
    public Result doctor() {
        return ok(doctor.render());
    }

    public Result bill() {
        return ok(bill_form.render());
    }

     public Result home() {
        return ok(home_form.render());
    }

    public Result login() {
        return ok(login_form.render());
    }

    public Result test() {
        return ok(test_form.render());
}


    public Result postPatient() {
        Connection connection = db.getConnection();
        DBI dbi = new DBI(db.getDataSource());
        PatientDao dao = dbi.open(PatientDao.class);
        Form<Patient> patientForm = formFactory.form(Patient.class);
        Patient patient = patientForm.bindFromRequest().get();
        dao.insert(patient.fullname, patient.pid, patient.address, patient.desc,
                patient.contact, patient.gender, patient.weight, patient.age, patient.room);

        Logger.info("Welcome" + patient.fullname);
        dao.close();

        return ok(patient_form.render());
    }

}
