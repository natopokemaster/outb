package br.com.clarobr.contractprospectservice.enums;

import lombok.Getter;

/**
 * @author Alan Ricardo
 */
@Getter
public enum TipoPessoa {
    JURIDICA(2,"JURIDICA"),
    FISICA(1, "FISICA");

    Integer id;
    String description;

    TipoPessoa(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static TipoPessoa returnPersonTypeDescription(Integer id){
        if(id == 1){
            return FISICA;
        }
        return JURIDICA;
    }


}
