package myFirstWebService.first.controller;


import myFirstWebService.first.model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {




    @GetMapping(value = "/get")
    public String myMethod(){

        return "Hello World !!!";


    }

    @GetMapping(value = "/gets")
    public String myMethod2(){

        return "bye World !!!";

    }
    @PostMapping()
    public ResponseEntity<String> myMethod3(@RequestBody  Member member) {

        System.out.println(member.getId());
        System.out.println(member.getName());

        return new ResponseEntity<>("post done",HttpStatus.OK);
    }

}
