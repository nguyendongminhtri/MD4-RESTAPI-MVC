package chinh.anh.controller;

import chinh.anh.dto.ResponseMessage;
import chinh.anh.model.SmartPhone;
import chinh.anh.service.ISmartPhoneService;
import chinh.anh.service.SmartPhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("phone")
@CrossOrigin(origins = "*")
public class SmartPhoneController {
    @Autowired
    SmartPhoneServiceImpl smartPhoneService;
    @PostMapping
    public ResponseEntity<?> createSmartPhone(@RequestBody SmartPhone smartPhone){
        if(smartPhone.getProducer().trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("no"),HttpStatus.OK);
        }
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(new ResponseMessage("create success!"), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getListSmartPhone(){
     return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/search/{producer}")
    public ResponseEntity<?> findAllByProducer(@PathVariable String producer){
        return new ResponseEntity<>(smartPhoneService.findAllByProducerContaining(producer),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detailSmartPhone(@PathVariable Long id){
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSmartPhone(@PathVariable Long id){
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.deleteById(smartPhone.get().getId());
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSmartPhone(@PathVariable Long id, @RequestBody SmartPhone smartPhone){
        Optional<SmartPhone> smartPhone1 = smartPhoneService.findById(id);
        if(!smartPhone1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        System.out.println("id --->"+id);
//        System.out.println("getId() ==>"+smartPhone1.get().getId());
        smartPhone.setId(id);
//        smartPhone1.get().setProducer(smartPhone.getProducer());
//        smartPhone1.get().setModel(smartPhone.getModel());
//        smartPhone1.get().setPrice(smartPhone.getPrice());
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(new ResponseMessage("Update Success!"), HttpStatus.OK);
    }

}
