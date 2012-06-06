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
package org.sola.services.boundary.ws;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.administrative.BaUnitTO;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.*;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.administrative.businesslogic.AdministrativeEJB;
import org.sola.services.ejb.administrative.businesslogic.AdministrativeEJBLocal;
import org.sola.services.ejb.administrative.repository.entities.BaUnit;
import org.sola.services.ejb.transaction.businesslogic.TransactionEJBLocal;
import org.sola.services.ejb.transaction.repository.entities.TransactionBasic;

/**
 * Web Service Boundary class to expose {@linkplain AdministrativeEJB} methods.
 */
@WebService(serviceName = "administrative-service", targetNamespace = ServiceConstants.ADMINISTRATIVE_WS_NAMESPACE)
public class Administrative extends AbstractWebService {

    @EJB
    private AdministrativeEJBLocal administrativeEJB;
    @EJB
    private TransactionEJBLocal transactionEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Web method that can be used to validate if the web service is available.
     *
     * @return Always true
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    /**
     * See {@linkplain AdministrativeEJB#createBaUnit(java.lang.String,
     * org.sola.services.ejb.administrative.repository.entities.BaUnit)
     * AdministrativeEJB.createBaUnit}
     *
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws SOLAAccessFault
     * @throws OptimisticLockingFault
     */
    @WebMethod(operationName = "CreateBaUnit")
    public BaUnitTO CreateBaUnit(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "baUnitTO") BaUnitTO baUnitTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault {

        final String serviceIdTmp = serviceId;
        final BaUnitTO baUnitTOTmp = baUnitTO;
        final Object[] result = {null};

        runUpdate(wsContext, new Runnable() {

            @Override
            public void run() {
                BaUnit newBaUnit = administrativeEJB.createBaUnit(
                        serviceIdTmp,
                        GenericTranslator.fromTO(baUnitTOTmp, BaUnit.class,
                        administrativeEJB.getBaUnitById(baUnitTOTmp.getId())));
                result[0] = GenericTranslator.toTO(newBaUnit, BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }

    /**
     * See {@linkplain AdministrativeEJB#saveBaUnit(java.lang.String,
     * org.sola.services.ejb.administrative.repository.entities.BaUnit)
     * AdministrativeEJB.saveBaUnit}
     *
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws SOLAAccessFault
     * @throws OptimisticLockingFault
     */
    @WebMethod(operationName = "SaveBaUnit")
    public BaUnitTO SaveBaUnit(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "baUnitTO") BaUnitTO baUnitTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault {

        final String serviceIdTmp = serviceId;
        final BaUnitTO baUnitTOTmp = baUnitTO;
        final Object[] result = {null};

        runUpdate(wsContext, new Runnable() {

            @Override
            public void run() {
                if (baUnitTOTmp != null) {
                    BaUnit newBaUnit = administrativeEJB.saveBaUnit(
                            serviceIdTmp,
                            GenericTranslator.fromTO(baUnitTOTmp, BaUnit.class,
                            administrativeEJB.getBaUnitById(baUnitTOTmp.getId())));
                    result[0] = GenericTranslator.toTO(newBaUnit, BaUnitTO.class);
                }
            }
        });

        return (BaUnitTO) result[0];
    }

    /**
     * See {@linkplain AdministrativeEJB#terminateBaUnit(java.lang.String, java.lang.String)
     * AdministrativeEJB.terminateBaUnit}
     *
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws SOLAAccessFault
     * @throws OptimisticLockingFault
     * @throws SOLAValidationFault
     */
    @WebMethod(operationName = "TerminateBaUnit")
    public BaUnitTO TerminateBaUnit(@WebParam(name = "baUnitId") String baUnitId,
            @WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault,
            SOLAValidationFault {

        final Object[] params = {baUnitId, serviceId};
        final Object[] result = {null};

        runUpdateValidation(wsContext, new Runnable() {

            @Override
            public void run() {
                String baUnitId = (String) params[0];
                String serviceId = (String) params[1];
                BaUnit baUnit = administrativeEJB.terminateBaUnit(baUnitId, serviceId);
                result[0] = GenericTranslator.toTO(baUnit, BaUnitTO.class);
            }
        });
        return (BaUnitTO) result[0];
    }

    /**
     * See {{@linkplain AdministrativeEJB#cancelBaUnitTermination(java.lang.String)
     * AdministrativeEJB.cancelBaUnitTermination}
     *
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws SOLAAccessFault
     * @throws OptimisticLockingFault
     * @throws SOLAValidationFault
     */
    @WebMethod(operationName = "CancelBaUnitTermination")
    public BaUnitTO CancelBaUnitTermination(@WebParam(name = "baUnitId") String baUnitId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault,
            SOLAValidationFault {

        final Object[] params = {baUnitId};
        final Object[] result = {null};

        runUpdateValidation(wsContext, new Runnable() {

            @Override
            public void run() {
                String baUnitId = (String) params[0];
                BaUnit baUnit = administrativeEJB.cancelBaUnitTermination(baUnitId);
                result[0] = GenericTranslator.toTO(baUnit, BaUnitTO.class);
            }
        });
        return (BaUnitTO) result[0];
    }

    /**
     * See {{@linkplain AdministrativeEJB#getBaUnitById(java.lang.String)
     * AdministrativeEJB.getBaUnitById}
     *
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "GetBaUnitById")
    public BaUnitTO GetBaUnitById(@WebParam(name = "id") String id)
            throws SOLAFault, UnhandledFault {

        final String idTmp = id;
        final Object[] result = {null};

        runOpenQuery(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        administrativeEJB.getBaUnitById(idTmp), BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }

    /**
     * Retrieves the list of BA Unit associated with the specified Service.
     *
     * @param serviceId The Service identifier
     * @return The list of BA Unit associated with the service or an empty list if the service does
     * not have any BA Units associated with it.
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws SOLAAccessFault
     * @see
     * org.sola.services.ejb.transaction.businesslogic.TransactionEJB#getTransactionByServiceId(java.lang.String,
     * boolean, java.lang.Class) TransactionEJB.getTransactionByServiceId
     * @see AdministrativeEJB#getBaUnitsByTransactionId(java.lang.String)
     * AdministrativeEJB.getBaUnitsByTransactionId
     */
    @WebMethod(operationName = "GetBaUnitsByServiceId")
    public List<BaUnitTO> GetBaUnitsByServiceId(@WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {serviceId};
        final Object[] result = {new ArrayList<BaUnitTO>()};

        runOpenQuery(wsContext, new Runnable() {

            @Override
            public void run() {
                String serviceId = (String) params[0];
                if (serviceId != null) {
                    TransactionBasic transaction = transactionEJB.getTransactionByServiceId(serviceId, false, TransactionBasic.class);
                    if (transaction != null) {
                        List<BaUnit> baUnits = administrativeEJB.getBaUnitsByTransactionId(transaction.getId());
                        result[0] = GenericTranslator.toTOList(baUnits, BaUnitTO.class);
                    }
                }
            }
        });
        return (List<BaUnitTO>) result[0];
    }

    /**
     * See {@linkplain AdministrativeEJB#getBaUnitByCode(java.lang.String, java.lang.String) 
     * AdministrativeEJB.getBaUnitByCode}

     * @throws SOLAFault
     * @throws UnhandledFault 
     */
    @WebMethod(operationName = "GetBaUnitByCode")
    public BaUnitTO GetBaUnitByCode(
            @WebParam(name = "nameFirstpart") String nameFirstpart,
            @WebParam(name = "nameLastpart") String nameLastpart)
            throws SOLAFault, UnhandledFault {

        final String nameFirstpartTmp = nameFirstpart;
        final String nameLastpartTmp = nameLastpart;
        final Object[] result = {null};

        runOpenQuery(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        administrativeEJB.getBaUnitByCode(nameFirstpartTmp,
                        nameLastpartTmp), BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }
}
