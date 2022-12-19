package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Motivo da desoneração do ICMS.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeIcmsMotivoDesoneracaoIcmsStEnum {

    /**
     * 999999999 - Não aplicavel.
     */
    NAO_APLICAVEL("999999999", "Não aplicavel"),
    USO_NA_AGROPECUARIA("3", "Uso na agropecuária"),
    OUTROS("9", "Outros"),
    ORGAO_DE_FORMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", "Órgão de fomento e desenvolvimento agropecuário");

    private String code;

    private String description;

    private NFeIcmsMotivoDesoneracaoIcmsStEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsMotivoDesoneracaoIcmsStEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsMotivoDesoneracaoIcmsStEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsMotivoDesoneracaoIcmsStEnum> getAll() {
        return Arrays.asList(NFeIcmsMotivoDesoneracaoIcmsStEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
