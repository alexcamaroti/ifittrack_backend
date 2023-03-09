package br.com.cammarota.alex.ifittrack.config.exception.handler.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageHandler {
    private String msg;
}
