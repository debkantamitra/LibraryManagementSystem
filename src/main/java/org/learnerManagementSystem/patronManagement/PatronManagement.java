package org.learnerManagementSystem.patronManagement;

import org.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PatronManagement {
    Logger logger = LoggerFactory.getLogger(PatronManagement.class);
    private List<Patron> patronList;

    public PatronManagement() {
        this.patronList = new ArrayList<>();
    }

    public PatronManagement(List<Patron> patronList) {
        this.patronList = patronList;
    }

    public void addPatron(Patron patron) {
        this.patronList.add(patron);
        logger.info("Added patron!");
    }

    public void removePatron(Patron patron) {
        this.patronList.remove(patron);
        logger.info("Removed patron!");
    }

    public List<Patron> getPatronList() {
        return this.patronList;
    }

    public Patron searchByPatronId(long patronId) {
        return this.patronList
                .stream()
                .filter(item -> item.getPatronId() == patronId)
                .collect(Collectors.toList()).get(0);
    }
}
