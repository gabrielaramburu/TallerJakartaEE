package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClienteTelepeaje{
    private PrePaga ctaPrepaga;
    private PostPaga ctaPostPaga;
}
