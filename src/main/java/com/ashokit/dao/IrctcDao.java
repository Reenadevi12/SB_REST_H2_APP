package com.ashokit.dao;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Repository;


import com.ashokit.response.TicketResponce;
@Repository
public class IrctcDao {
	
	private Map<String, TicketResponce> ticketsMap=new HashMap<>();
	
	public String seveTicket(TicketResponce responce) {

		
		
		ticketsMap.put(responce.getPnr(), responce);
		return  responce.getPnr();

	}
	public TicketResponce getTicketByPnr(String pnr) {
		if(ticketsMap.containsKey(pnr)) {
			return ticketsMap.get(pnr);
		}else {
			return null;
		}
	}

}
