package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Modelo do Documento Fiscal (cupom fiscal).
 *
 * @author gabrielMenegatto
 */
@XmlType
@XmlEnum(String.class)
public enum NFeIndicadorIntermediarioEnum {

    /**
     * 999999999 - Não aplicavel.
     */
    NAO_APLICAVEL("999999999", "Não aplicavel"),
    /**
     * 2B - Cupom Fiscal emitido por máquina registradora (não ECF).
     */
    OPERACAO_SEM_INTERMEDIADOR("0", "Operação sem intermediador (em site ou plataforma própria)"),
    /**
     * 2C - Cupom Fiscal PDV.
     */
    OPERACAO_EM_SITE_OU_PLATAFORMA_DE_TERCEIROS("1", "Operação em site ou plataforma de terceiros (intermediadores/marketplace)");

    private String code;

    private String description;

    private NFeIndicadorIntermediarioEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIndicadorIntermediarioEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIndicadorIntermediarioEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIndicadorIntermediarioEnum> getAll() {
        return Arrays.asList(NFeIndicadorIntermediarioEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
