package com.quatriemetry.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.quatriemetry.demo.form.AnimalsForm;
import com.quatriemetry.demo.model.Animals;
import com.quatriemetry.demo.model.Appointment;
import com.quatriemetry.demo.form.PersonForm;
import com.quatriemetry.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Person> persons = new ArrayList<Person>();
    private static Appointment appointment = new Appointment();
    private static List<Animals> animals = new ArrayList<Animals>();

    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
        animals.add(new Animals("0", "Chat"));
        animals.add(new Animals("1", "Chien"));
        animals.add(new Animals("2", "Vache"));
        animals.add(new Animals("3", "Canard"));
        animals.add(new Animals("4", "Pingouin"));
        animals.add(new Animals("5", "Loutre"));
        appointment.setLocation("42669 TarlouzeCity");
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @Value("${titre_header.message}")
    private String headertitle;


    @Value("${titre_intro.message}")
    private String titre_introMessage;


    @Value("${intro.message}")
    private String introMessage;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("headertitle", headertitle);
        model.addAttribute("titreintro", titre_introMessage);
        model.addAttribute("intromessage", introMessage);
        model.addAttribute("appointment", appointment);
        model.addAttribute("animaux", animals);

        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("persons", persons);

        return "person";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("personForm") PersonForm personForm) {

        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();

        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);

            return "redirect:/personList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }

}