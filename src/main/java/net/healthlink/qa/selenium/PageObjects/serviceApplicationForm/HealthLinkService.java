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
public enum HealthLinkService {


        HMS("HealthLink Secure Messaging"),
                GENSOLVE("HMS Gensolve Cloud Based Clinical Software"),
                ENDGAME("HMS EndGame Cloud Based Clinical Software");

        private String name;


    HealthLinkService(String name){
            this.name=name;
        }

public String getName(){
        return name;
}





}
