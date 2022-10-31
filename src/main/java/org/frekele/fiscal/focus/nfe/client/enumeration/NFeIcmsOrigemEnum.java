package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Origem da mercadoria.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeIcmsOrigemEnum {

    /**
     * 999999999 - Não aplicavel.
     */
    NAO_APLICAVEL("999999999", "Não aplicavel"),
    /**
     * 0 - Nacional.
     */
    NACIONAL("0", "Nacional"),
    /**
     * 0 - Estrangeira (importação direta).
     */
    ESTRANGEIRO_IMPORTACAO_DIRETA("1", "Estrangeira (importação direta)"),
    /**
     * 0 - Estrangeira (importação direta).
     */
    ESTRANGEIRO_ADQUIRIDO_NO_MERCADO_INTERIOR("2", "Estrangeira (adquirida no mercado interno)"),
    /**
     * 0 - Estrangeira (adquirida no mercado interno).
     */
    NACIONAL_COM_MAIS_DE_40_PORCENTO_CONTEUDO_ESTRANGEIRO("3", "Nacional com mais de 40% de conteúdo estrangeiro"),
    /**
     * 0 - Nacional com mais de 40% de conteúdo estrangeiro.
     */
    NACIONAL_PRODUZIDO_ATRAVEZ_PROCESSO_PRODUTIVO_BASICO("4", "Nacional produzida através de processos produtivos básicos"),
    /**
     * 0 - Nacional produzida através de processos produtivos básicos.
     */
    NACIONAL_COM_MENOS_DE_40_PORCENTO_CONTEUDO_ESTRANGEIRO("5", "Nacional com menos de 40% de conteúdo estrangeiro"),
    /**
     * 0 - Nacional com menos de 40% de conteúdo estrangeiro.
     */
    ESTRANGEIRO_IMPORTACAO_DIRETA_SEM_PRODUTO_NACIONAL_SIMILAR("6", "Estrangeira (importação direta) sem produto nacional similar"),
    /**
     * 0 - Estrangeira (importação direta) sem produto nacional similar.
     */
    ESTRANGEIRO_ADQUIRIDO_NO_MERCADO_INTERIOR_SEM_PRODUTO_NACIONAL_SIMILAR("7", "Estrangeira (adquirida no mercado interno) sem produto nacional similar"),
    /**
     * 0 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%.
     */
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_70_PORCENTO("8", "Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%");

    private String code;

    private String description;

    private NFeIcmsOrigemEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsOrigemEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsOrigemEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsOrigemEnum> getAll() {
        return Arrays.asList(NFeIcmsOrigemEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
