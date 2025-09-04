package br.com.clarobr.serviceusagesbroadbands.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
public class Link implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String rel;
    private String href;
}

