package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeEmailBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    public NFeEmailBodyResponse() {
        super();
    }

    private NFeEmailBodyResponse(Builder builder) {
        setErro(builder.erro);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NFeErro getErro() {
        return erro;
    }

    public void setErro(NFeErro erro) {
        this.erro = erro;
    }

    public static final class Builder {

        private NFeErro erro;

        private Builder() {
        }

        public Builder withErro(NFeErro val) {
            erro = val;
            return this;
        }

        public NFeEmailBodyResponse build() {
            return new NFeEmailBodyResponse(this);
        }
    }
}