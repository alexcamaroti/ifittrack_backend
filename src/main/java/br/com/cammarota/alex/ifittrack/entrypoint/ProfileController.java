package br.com.cammarota.alex.ifittrack.entrypoint;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController {


    @GetMapping
    public ResponseEntity<String> getProfile(){
        return ResponseEntity.ok("Perfil retornado");
    }
}
