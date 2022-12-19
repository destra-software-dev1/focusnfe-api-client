package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Tipo da nota fiscal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFSeNaturezaOperacaoEnum {

    /**
     * 0 - Nota Fiscal de Entrada.
     */
    TRIBUTACAO_NO_MUNICIPIO("1", "Tributação no município"),
    TRIBUTACAO_FORA_DO_MUNICIPIO("2", "Tributação fora do município"),
    ISENCAO("3", "Isenção"),
    IMUNE("4", "Imune"),
    EXIGILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("5", "Exigibilidade suspensa por decisão judicial"),
    EXIGILIDADE_SUSPENSA_POR_PROCEDIMENTO_ADMINISTRATIVA("6", "Exigibilidade suspensa por procedimento administrativo");

    private String code;

    private String description;

    private NFSeNaturezaOperacaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFSeNaturezaOperacaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFSeNaturezaOperacaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFSeNaturezaOperacaoEnum> getAll() {
        return Arrays.asList(NFSeNaturezaOperacaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
