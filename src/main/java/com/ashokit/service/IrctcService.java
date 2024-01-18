package com.ashokit.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dao.IrctcDao;
import com.ashokit.request.PassingerRequest;
import com.ashokit.response.TicketResponce;

@Service
public class IrctcService {
	
	@Autowired
	private IrctcDao dao;
	
	
	public String bookTicket(PassingerRequest request) {

		TicketResponce responce = new TicketResponce();
		responce.setName(request.getName());
		responce.setStatus("confirmed");
		responce.setCost(545.60);
		responce.setFrom(request.getFrom());
		responce.setTo(request.getTo());
		responce.setJdata(request.getJdate());
		UUID randomUUID = UUID.randomUUID();

		// Convert UUID to string
		String pnr = randomUUID.toString();
		responce.setPnr(pnr);
		
		return dao.seveTicket(responce);

	}
	public TicketResponce getTicketByPnr(String pnr) {
		return dao.getTicketByPnr(pnr);
	}
}
