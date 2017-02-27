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
public enum Regions {
    AUCKLAND("Auckland"),
    BAYOFPLENTY("Bay of Plenty"),
    CANTERBURY("Canterbury"),
    CHATHAM("Chatham Islands"),
    COROMANDEL("Coromandel"),
    GISBORNE("Gisborne"),
    HAWKESBAY("Hawkes Bay"),
    KAPITI("Kapiti"),
    MANAWATU("Manawatu"),
    NELSON("Nelson-Marlborough"),
    NORTHLAND("Northland"),
    OTAGO("Otago"),
    SOUTHLAND("Southland"),
    TARANAKI("Taranaki"),
    TIMARU("Timaru-Oamaru"),
    WAIKATO("Waikato"),
    WAIRARAPA("Wairarapa"),
    WELLINGTON("Wellington"),
    WESTCOAST("West Coast");

    Regions(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;

    public String getFullName() {
        return fullName;
    }
}
