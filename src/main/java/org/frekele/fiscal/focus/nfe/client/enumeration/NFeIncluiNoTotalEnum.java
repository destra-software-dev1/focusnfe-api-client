package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

@XmlType
@XmlEnum(String.class)
public enum NFeIncluiNoTotalEnum {

    NAO("0", "Não"),
    SIM("1", "Sim");

    private String code;

    private String description;

    private NFeIncluiNoTotalEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIncluiNoTotalEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIncluiNoTotalEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIncluiNoTotalEnum> getAll() {
        return Arrays.asList(NFeIncluiNoTotalEnum.values());
    }

    public String getDescription() {
        return description;
    }
}