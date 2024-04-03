package com.example.schoolmanagementsoftware.Controller;


import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAllAddresses(){
        logger.info("inside get all addresses");
        return ResponseEntity.ok().body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside add addresses");
        addressService.addAddress(addressDTO);
        return ResponseEntity.ok().body("address was added successfully!");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside update addresses");
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok().body("address was updated successfully!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        logger.info("inside delete addresses");
        addressService.deleteAddress(id);
        return ResponseEntity.ok().body("address was deleted successfully!");
    }
}
