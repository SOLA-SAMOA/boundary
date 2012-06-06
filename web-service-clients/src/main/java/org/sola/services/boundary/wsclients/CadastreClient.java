/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations (FAO). All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,this list of conditions
 * and the following disclaimer. 2. Redistributions in binary form must reproduce the above
 * copyright notice,this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution. 3. Neither the name of FAO nor the names of its
 * contributors may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.services.boundary.wsclients;

import java.util.List;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.transferobjects.ValidationResult;
import org.sola.webservices.transferobjects.cadastre.CadastreObjectNodeTO;
import org.sola.webservices.transferobjects.cadastre.CadastreObjectTO;
import org.sola.webservices.transferobjects.transaction.TransactionCadastreChangeTO;
import org.sola.webservices.transferobjects.transaction.TransactionCadastreRedefinitionTO;

/**
 * Interface for the Cadastre Service. Implemented by {@linkplain CadastreClientImpl}. To obtain a
 * reference to the Cadastre Service, use {@linkplain WSManager#getCadastreService()}
 *
 * @see CadastreClientImpl
 * @see WSManager#getCadastreService()
 */
public interface CadastreClient extends AbstractWSClient {

    /**
     * Cadastre. - Service name prefix for the Cadastre Web Service
     */
    public static final String SERVICE_NAME = "Cadastre.";
    /**
     * Cadastre.checkConnection - Identifier for the checkConnection method
     */
    public static final String CHECK_CONNECTION = SERVICE_NAME + "checkConnection";
    /**
     * Cadastre.getCadastreObjectByParts - Identifier for the getCadastreObjectByParts method
     */
    public static final String GET_CADASTRE_OBJECT_BY_PARTS = SERVICE_NAME + "getCadastreObjectByParts";
    /**
     * Cadastre.getCadastreObjectByPoint - Identifier for the getCadastreObjectByPoint method
     */
    public static final String GET_CADASTRE_OBJECT_BY_POINT = SERVICE_NAME + "getCadastreObjectByPoint";
    /**
     * Cadastre.getCadastreObjectsByBaUnit - Identifier for the getCadastreObjectsByBaUnit method
     */
    public static final String GET_CADASTRE_OBJECTS_BY_BA_UNIT = SERVICE_NAME + "getCadastreObjectsByBaUnit";
    /**
     * Cadastre.getCadastreObjectsByService - Identifier for the getCadastreObjectsByService method
     */
    public static final String GET_CADASTRE_OBJECTS_BY_SERVICE = SERVICE_NAME + "getCadastreObjectsByService";
    /**
     * Cadastre.saveTransactionCadastreChange - Identifier for the saveTransactionCadastreChange
     * method
     */
    public static final String SAVE_TRANSACTION_CADASTRE_CHANGE = SERVICE_NAME + "saveTransactionCadastreChange";
    /**
     * Cadastre.getTransactionCadastreChange - Identifier for the getTransactionCadastreChange
     * method
     */
    public static final String GET_TRANSACTION_CADASTRE_CHANGE = SERVICE_NAME + "getTransactionCadastreChange";
    /**
     * Cadastre.getCadastreObjects - Identifier for the getCadastreObjects method
     */
    public static final String GET_CADASTRE_OBJECTS = SERVICE_NAME + "getCadastreObjects";
    /**
     * Cadastre.getCadastreObjectNode - Identifier for the getCadastreObjectNode method
     */
    public static final String GET_CADASTRE_OBJECT_NODE = SERVICE_NAME + "getCadastreObjectNode";
    /**
     * Cadastre.getCadastreObjectNodePotential - Identifier for the getCadastreObjectNodePotential
     * method
     */
    public static final String GET_CADASTRE_OBJECT_NODE_POTENTIAL = SERVICE_NAME + "getCadastreObjectNodePotential";
    /**
     * Cadastre.saveTransactionCadastreRedefinition - Identifier for the
     * saveTransactionCadastreRedefinition method
     */
    public static final String SAVE_TRANSACTION_CADASTRE_REDFN = SERVICE_NAME + "saveTransactionCadastreRedefinition";
    /**
     * Cadastre.getTransactionCadastreRedefinition - Identifier for the
     * getTransactionCadastreRedefinition method
     */
    public static final String GET_TRANSACTION_CADASTRE_REDFN = SERVICE_NAME + "getTransactionCadastreRedefinition";

    List<CadastreObjectTO> getCadastreObjectByParts(String searchString)
            throws WebServiceClientException;

    CadastreObjectTO getCadastreObjectByPoint(double x, double y, int srid)
            throws WebServiceClientException;

    List<CadastreObjectTO> getCadastreObjectsByBaUnit(String baUnitId);

    List<CadastreObjectTO> getCadastreObjectsByService(String serviceId);

    List<ValidationResult> saveTransactionCadastreChange(TransactionCadastreChangeTO cadastreChangeTO);

    TransactionCadastreChangeTO getTransactionCadastreChange(String serviceId);

    List<CadastreObjectTO> getCadastreObjects(List<String> Ids);

    CadastreObjectNodeTO getCadastreObjectNode(
            double xMin, double yMin, double xMax, double yMax, int srid);

    CadastreObjectNodeTO getCadastreObjectNodePotential(
            double xMin, double yMin, double xMax, double yMax, int srid);

    List<ValidationResult> saveTransactionCadastreRedefinition(
            TransactionCadastreRedefinitionTO transactionTO);

    TransactionCadastreRedefinitionTO getTransactionCadastreRedefinition(String serviceId);
}