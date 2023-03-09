package br.com.cammarota.alex.ifittrack.config.exception.handler;

import br.com.cammarota.alex.ifittrack.config.exception.*;
import br.com.cammarota.alex.ifittrack.config.exception.handler.model.MessageHandler;
import br.com.cammarota.alex.ifittrack.config.utils.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AvaliacaoNotFoundException.class })
    public ResponseEntity<MessageHandler> avaliacaoNotFoundException(
            Exception ex, WebRequest request) {
        MessageHandler msg = MessageHandler.builder().msg(Constants.MSG_AVALIACOES_NOT_FOUND).build();
        return new ResponseEntity<MessageHandler>(
                msg, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ PerfilNotFoundException.class })
    public ResponseEntity<MessageHandler> perfilNotFoundException(
            Exception ex, WebRequest request) {
        MessageHandler msg = MessageHandler.builder().msg(Constants.MSG_PERFIS_NOT_FOUND).build();
        return new ResponseEntity<MessageHandler>(
                msg, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ CadastroPerfilException.class })
    public ResponseEntity<MessageHandler> cadastroPerfilGeneralException(
            Exception ex, WebRequest request) {
        MessageHandler msg = MessageHandler.builder().msg(Constants.MSG_PERFIL_UNPROC_ENTITY).build();
        return new ResponseEntity<MessageHandler>(
                msg, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ CadastroAvaliacaoSaudeException.class })
    public ResponseEntity<MessageHandler> cadastroAvaliacaoGeneralException(
            Exception ex, WebRequest request) {
        MessageHandler msg = MessageHandler.builder().msg(Constants.MSG_AVALIACAO_UNPROC_ENTITY).build();
        return new ResponseEntity<MessageHandler>(
                msg, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ InvalidPerfilException.class })
    public ResponseEntity<MessageHandler> perfilInvalidoException(
            Exception ex, WebRequest request) {
        MessageHandler msg = MessageHandler.builder().msg(Constants.MSG_AVALIACAO_PERFIL_INVALIDO_UNPROC_ENTITY).build();
        return new ResponseEntity<MessageHandler>(
                msg, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
