package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Identificador de local de destino da operação.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeLocalDestinoEnum {

    /**
     * 999999999 - Não aplicavel.
     */
    NAO_APLICAVEL("999999999", "Não aplicavel"),
    /**
     * 1 - Operação interna.
     */
    OPERACAO_INTERNA("1", "Operação interna"),
    /**
     * 2 - Operação interestadual.
     */
    OPERACAO_INTERESTADUAL("2", "Operação interestadual"),
    /**
     * 3 - Operação com exterior.
     */
    OPERACAO_EXTERIOR("3", "Operação com exterior");

    private String code;

    private String description;

    private NFeLocalDestinoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeLocalDestinoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeLocalDestinoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeLocalDestinoEnum> getAll() {
        return Arrays.asList(NFeLocalDestinoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
