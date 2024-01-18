package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.request.PassingerRequest;
import com.ashokit.response.TicketResponce;
import com.ashokit.service.IrctcService;



@RestController
public class IrctcRestController {
	@Autowired
	private IrctcService service;
	@PostMapping(
			value="/bookTicket",
			consumes = {"application/xml","application/json"}
			)
	public ResponseEntity<String> bookTicket(@RequestBody PassingerRequest request){
		String pnr=service.bookTicket(request);
		String msg="Ticket booking completed :: "+pnr;
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping(
			value="/ticket/{pnr}",
			produces = {"application/xml","application/json"}
			)
	public ResponseEntity<TicketResponce> getTicket(@PathVariable String pnr){
		TicketResponce ticket=service.getTicketByPnr(pnr);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}
	

}
