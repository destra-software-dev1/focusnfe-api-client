package org.frekele.fiscal.focus.nfe.client.model.response.nfce;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeConsultarBodyResponse;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface NFCeConsultarResponse extends FocusNFeEntity {

    @HeaderParam("X-Rate-Limit-Limit")
    String getRateLimitLimit();

    @HeaderParam("X-Rate-Limit-Remaining")
    String getRateLimitRemaining();

    @HeaderParam("X-Rate-Limit-Reset")
    String getRateLimitReset();

    @Status
    Integer getStatus();

    @Body
    NFCeConsultarBodyResponse getBody();

    Response getResponse();
}
