package com.bolivar.comunes.calculadora.service;

import com.bolivar.comunes.calculadora.consumingwebservice.wsdl.*;
import com.bolivar.comunes.calculadora.models.ObtenercalculoResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Primary
public class CalcularOperacionService extends WebServiceGatewaySupport {

    private final String Endpoint = "http://www.dneonline.com/calculator.asmx";
    private final ObjectFactory of = new ObjectFactory();

    public ObtenercalculoResponse sumar (int numA, int numB) {
        ObtenercalculoResponse response = new ObtenercalculoResponse();
        Add suma = of.createAdd();
        suma.setIntA(numA);
        suma.setIntB(numB);

        AddResponse sumaResultado =(AddResponse) getWebServiceTemplate().marshalSendAndReceive(Endpoint, suma, new SoapActionCallback("http://tempuri.org/Add"));

        response.setResultado(sumaResultado.getAddResult());

        return response;
    }

    public ObtenercalculoResponse restar (int numA, int numB) {
        ObtenercalculoResponse response = new ObtenercalculoResponse();
        Subtract resta = of.createSubtract();
        resta.setIntA(numA);
        resta.setIntB(numB);

        SubtractResponse restaResultado =(SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(Endpoint, resta, new SoapActionCallback("http://tempuri.org/Subtract"));

        response.setResultado(restaResultado.getSubtractResult());

        return response;
    }

    public ObtenercalculoResponse multiplicar (int numA, int numB) {
        ObtenercalculoResponse response = new ObtenercalculoResponse();
        Multiply multiplicacion = of.createMultiply();
        multiplicacion.setIntA(numA);
        multiplicacion.setIntB(numB);

        MultiplyResponse multiplicacionResultado =(MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(Endpoint, multiplicacion, new SoapActionCallback("http://tempuri.org/Multiply"));

        response.setResultado(multiplicacionResultado.getMultiplyResult());

        return response;
    }

    public ObtenercalculoResponse dividir (int numA, int numB) {
        ObtenercalculoResponse response = new ObtenercalculoResponse();
        Divide division = of.createDivide();
        division.setIntA(numA);
        division.setIntB(numB);

        DivideResponse divisionResultado =(DivideResponse) getWebServiceTemplate().marshalSendAndReceive(Endpoint, division, new SoapActionCallback("http://tempuri.org/Divide"));

        response.setResultado(divisionResultado.getDivideResult());

        return response;
    }

}
