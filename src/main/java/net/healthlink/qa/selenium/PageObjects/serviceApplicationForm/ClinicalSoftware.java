/*
 * Copyright (c) 2017 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package net.healthlink.qa.selenium.PageObjects.serviceApplicationForm;

/**
 * The purpose of this...
 *
 * @author beden
 */
public enum ClinicalSoftware {

    BESTPRACTICE("Best Practice"),
    GENIEFORMAC ("Genie For Mac"),
    AJEXUS("Ajexus"),
    AUDIT4 ("Audit 4"),
    COMRAD1("COMRAD1"),
    COMRAD2("COMRAD2"),
    CARESTREAM("Carestream"),
    CLINICAIDE("ClinicAide"),
    CLINIKO("Cliniko"),
    CLOUDAPPOINTMENTS("Cloud Appointments"),
    CONCERTO("Concerto"),
    CUSTOMMADE ("Custom Made"),
    DENTAL4WINDOWS("Dental 4 Windows"),
    EXACT("Exact"),
    FRONTDESK("Front Desk"),
    GALEN("Galen"),
    GENSOLVE("Gensolve"),
    HEALTHSCOPE("HelathScope"),
    HELP4U("Help4U"),
    INTOUCHCMS("InTouch CMS"),
    INDICI("Indici"),
    KARISMA("Karisma"),
    KONNECT("Konnect"),
    LABSOLUTIONS("Lab Solutions"),
    MACPRACTICE("MacPractice"),
    MATERNITYPLUS("Maternity Plus"),
    MEDTECH32("MedTech 32"),
    MEDWARE("MedWare"),
    MEDCENMEDCEN("Medcen - Medcen"),
    MEDCENTAILAORMADE("Medcen - Tailormade"),
    MEDTECHEVOLUTION("Medtech Evolution"),
    MERCURY("Mercury"),
    MILLENIUM("Millenium"),
    MOSAIQ("Mosaiq"),
    MYPRACTICE("MyPractice"),
    OPTOMATE("Optimate"),
    ORTHOTRAC("Orthotrac"),
    PALCARE("PalCare"),
    PATTRAK("Pat Trak"),
    PRACTICEWORKS("Practiceworks"),
    PROFILEFORWINDOWS("Profile For Windows"),
    PROFILEFORMAC("Profile for Mac"),
    RECORDBASE("Recordbase"),
    RHAPSODY("Rhapsody"),
    STARLIMS("STARLIMS"),
    SPECIALISTPRACTICEMANAGER("Specialist Practice Manager"),
    SPECTRUM("Spectrum"),
    SURGERYPLUS("Surgery Plus"),
    TIMSAUDIOLOGY("TIMS Audiology"),
    TITANIUM("Titanium"),
    TONIQ("Toniq"),
    ULTRA("Ultra"),
    VIPGOLD("VIP GOLD"),
    VIPNET("VIP.net"),
    VISION("Vision"),
    VOYAGERRIS("Voyager RIS"),
    EALTH("eALTH"),
    OTHER("Other"),
    NZPHYSIOPRO ("NZPhysio Pro"),
    PHYSIOOFFICE("Physio Office"),
    ENDGAME("EndGame");


    private String name;


    ClinicalSoftware(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
