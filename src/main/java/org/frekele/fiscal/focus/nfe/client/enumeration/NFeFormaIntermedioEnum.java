package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Forma de importação quanto a intermediação.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeFormaIntermedioEnum {

    /**
     * 999999999 - Não aplicavel.
     */
    NAO_APLICAVEL("999999999", "Não aplicavel"),
    /**
     * 1 - Importação por conta própria, (Valor Padrão.
     */
    IMPORTACAO_POR_CONTA_PROPRIA("1", "Importação por conta própria"),
    /**
     * 2 - Importação por conta e ordem.
     */
    IMPORTACAO_POR_CONTA_E_ORDEM("2", "Importação por conta e ordem"),
    /**
     * 3 - Importação por encomenda.
     */
    IMPORTACAO_POR_ENCOMENDA("3", "Importação por encomenda");

    private String code;

    private String description;

    private NFeFormaIntermedioEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeFormaIntermedioEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeFormaIntermedioEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeFormaIntermedioEnum> getAll() {
        return Arrays.asList(NFeFormaIntermedioEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
