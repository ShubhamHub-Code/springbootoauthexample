package com.fullstack.controller;

import com.fullstack.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class CustomerController {

    List<Customer> customerList = Stream.of(new Customer(121,"Shubham","Pune",97000),
            new Customer(122,"Shweta","PCMC",98000),
            new Customer(123,"Ram","Mumbai",87000),
            new Customer(124,"Shyam","Nagpur",77000),
            new Customer(125,"Govind","Pune",99000),
            new Customer(126,"Aparna","NCR",47000)).toList();


    @GetMapping
    public ResponseEntity<List<Customer>>findAll(){
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/sortbyidreverse")
    public ResponseEntity<List<Customer>> sortbyIDReversed(){
        return new ResponseEntity<>(customerList.stream().sorted(Comparator.comparing(Customer::getCustID)).toList(),HttpStatus.OK);
    }


    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>>sortByName(){
        return new ResponseEntity<>(customerList.stream().sorted(Comparator.comparing(Customer::getCustName)).toList(),HttpStatus.OK);
    }

    @GetMapping("/sortbybalance")
    public ResponseEntity<List<Customer>>sortByAccountBalance(){
        return new ResponseEntity<>(customerList.stream().sorted(Comparator.comparing(Customer::getCustAccountBalance)).toList(),HttpStatus.OK);
    }
}
