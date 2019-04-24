package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.model.Member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class RestApiController {

    List <Member> memberlist = new ArrayList<>();

    //this api used to create new member
    @PostMapping(value = "/member" )
    public ResponseEntity<String> createMember (@RequestBody Member member){

        System.out.println("id:"+member.getId());
        System.out.println("message:"+member.getName());
        memberlist.add(member);

    return new ResponseEntity<>("member is created successfully", HttpStatus.CREATED);
    }

    //this api used to fetch or get all members
    @GetMapping(value = "/members" )
    public ResponseEntity<List<Member>> getMember(){
        System.out.println("list size:" + memberlist.size());
    return new ResponseEntity<>(memberlist , HttpStatus.OK);
    }

    //this api used to fetch or get member bye id
    @GetMapping(value = "/member/{id}" )
    public ResponseEntity<Object> getMemberById(@PathVariable("id") int id ){

        for (Member member : memberlist ) {
            if (member.getId() == id)
                return new ResponseEntity<>(member,HttpStatus.OK);
        }
    return new ResponseEntity<>("member not found" , HttpStatus.NOT_FOUND);
    }

    //this api used to remove or delete member by id
    @DeleteMapping(value = "/member/{id}" )
    public ResponseEntity<Object> deleteMemberById(@PathVariable("id") int id ){
    for (Iterator<Member> iterator = memberlist.iterator() ;  iterator.hasNext() ;){
        Member member = iterator.next();
    if (member.getId() == id){
        iterator.remove();
        return new ResponseEntity<>("member deleted successfully" , HttpStatus.OK);

    }
    }
        return new ResponseEntity<>("member not found" , HttpStatus.NOT_FOUND);
    }

    //this api used to edit or update existing member
    @PutMapping(value = "/member/{id}" )
    public ResponseEntity<Object> editMemberById(@RequestBody Member member , @PathVariable("id") int id ){
        for (Member m : memberlist ){
            if (m.getId() == id){
                m.setName(member.getName());
                return new ResponseEntity<>("member updated successfully" , HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("member not found" , HttpStatus.NOT_FOUND);

    }
}
