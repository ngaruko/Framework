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
public enum OrganizationTypes {
    AGED("Aged Care"),
    ALLIED("Allied Health"),
    COMMUNITY("Community Health"),

    DIAGNOSTICS("Diagnostic Services"),

    EHS("Environmental Health &amp; Safety"),

    GP("General Practice"),

    GOV("Government Department"),

    HEALTH("Health Association"),

    HEALTHLINK("HealthLink"),

    HOSPITAL("Hospital and/or DHB"),

    IT("IT Company"),

    KNOWLEDGE("Knowledge Companies"),

    MEDICARE("Medicare Local"),

    OTHER("Other"),

    PHO("PHO"),
    PATHOLOGY("Pathology Laboratory"),

    PHARMACEUTICAL("Pharmaceutical"),

    RADIOLOGY("Radiology Laboratory"),

    VENDOR("Software Vendor"),

    SPECIALIST("Specialist");


    OrganizationTypes(String fullName) {
        this.fullName = fullName;
    }

    public String fullName;

    public String getFullName() {
        return fullName;
    }


}
