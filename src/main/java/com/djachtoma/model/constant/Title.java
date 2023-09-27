package com.djachtoma.model.constant;

import lombok.Getter;

@Getter
public enum Title {

    GP("General Practitioner"),
    CON("Hospital Consultant"),
    REG("Registrar"),
    SAS("Specialist and Specialty"),
    SHO("Senior House Officer"),
    FO("Foundation Doctor"),
    MD("Medical Student"),
    ACF("Academic Clinical Fellow"),
    CL("Clinical Lecturer"),
    CRF("Clinical Research Fellow"),
    CLS("Clinical Senior Lecturer"),
    AP("Associate Professor"),
    P("Professor");


    public final String description;

    Title(String description) {
        this.description = description;
    }
}
