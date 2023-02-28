package com.fa.service.impl;

import java.util.ArrayList;


import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.fa.dto.AngularCrudDto;
import com.fa.dto.CommonDto;
import com.fa.dto.LoginDto;

import com.fa.entity.AngularCrudEntity;
import com.fa.entity.LoginEntity;
import com.fa.repository.AngularCrudRepository;
import com.fa.repository.LoginRepository;
import com.fa.service.AngularCrudService;

@Service
public class AngularCrudServiceImpl implements AngularCrudService {

	
	@Resource
	LoginRepository loginRepository;
	@Resource
	AngularCrudRepository angularCrudRepository;
	
	
	@Override
	public CommonDto loginUsingaAngular(LoginDto dto) {
		CommonDto commonDto=new CommonDto();
		   try {
		   if(dto.getEmail().equalsIgnoreCase(loginRepository.getEmail(dto.getEmail()))&&dto.getPassword().equalsIgnoreCase(loginRepository.getPasswordByEmail(dto.getEmail()))){
		    
			   LoginEntity entity = loginRepository.getDataByName(dto.getEmail());
			 
			   if(entity!=null) {
				   LoginDto loginDto = new LoginDto();
				   loginDto.setRole(entity.getRole());
				   loginDto.setUserImage(entity.getUserImage());
				   loginDto.setName(entity.getName());
				   loginDto.setEmail(entity.getEmail());
				   commonDto.setResponseObject(loginDto);
				   commonDto.setResult("success");
			   }else {
				   
				   commonDto.setResult("User not Exists!!");
				   
			   }
	
		    
		   }
		   
		   
		   else {
		   
		   commonDto.setResult("invalid crentils");
		   
		   }
		   }catch (Exception e) {
		    commonDto.setErrorMessage(e.getMessage());
		   
		  }
		   
		  
		  
		  return commonDto;
		}


	@Override
	public CommonDto signupUsingaAngular(LoginDto dto) {
		
		
		  
	      CommonDto commonDto=new CommonDto();
	     try {
	      
	      if (dto.getEmail().equalsIgnoreCase(loginRepository.getEmail(dto.getEmail()))){
	       
	      commonDto.setResult("user already exit");
	      }else {
	    	  LoginEntity entity=new LoginEntity();
	       
	       entity.setEmail(dto.getEmail());
	       entity.setPassword(dto.getPassword());
	       entity.setPhone(dto.getPhone());
	       entity.setName(dto.getName());
	       entity.setUserImage(dto.getUserImage());
	       loginRepository.save(entity);
	      commonDto.setResult("success");
	       
	      }
	      
	     
	     
	     }
	     catch (Exception e) {
	      commonDto.setResult("invalid crentils");
	     }
	       return commonDto;

	}


	@Override
	public CommonDto registerUsingaAngular(AngularCrudDto dto) {
		 CommonDto commonDto=new CommonDto();
		 try {
		      
		      if (dto.getName().equalsIgnoreCase(angularCrudRepository.getName(dto.getName()))){
		       
		      commonDto.setResult("user already exit");
		      }else {
		    	  AngularCrudEntity entity=new AngularCrudEntity();
		       
		       entity.setName(dto.getName());
		       entity.setPhone(dto.getPhone());
		       entity.setGender(dto.getGender());
		       entity.setEmail(dto.getEmail());
		       entity.setDate(dto.getDate());
		       entity.setModel(dto.getModel());
		       entity.setCity(dto.getCity());
		       entity.setArea(dto.getArea());
		       entity.setAddress(dto.getAddress());
		       angularCrudRepository.save(entity);
		       this.mailConfiguration(dto);
		      commonDto.setResult("success");
		       
		      }
		      
		     
		     
		     }
		     catch (Exception e) {
		      commonDto.setResult("invalid crentils");
		     }

	     
		return commonDto;
	}


	@Override
	public CommonDto getAllUserData() {
		CommonDto commonDto=new CommonDto();
		 try {
			 List<AngularCrudEntity>list = angularCrudRepository.findAll();
			 List<AngularCrudDto>dtoList = new ArrayList<AngularCrudDto>();
			 
			 
			 for(AngularCrudEntity entity :list) {
				
				 AngularCrudDto dto = new AngularCrudDto();
				 
				 dto.setName(entity.getName());
				 dto.setPhone(entity.getPhone());
				 dto.setGender(entity.getGender());
				 dto.setEmail(entity.getEmail());
				 dto.setDate(entity.getDate());
				 dto.setModel(entity.getModel());
				 dto.setCity(entity.getCity());
				 dto.setArea(entity.getArea());
				 dto.setAddress(entity.getAddress());
				 
				 dtoList.add(dto);
			 }
			 
			 commonDto.setResponseData(dtoList);
			 
		 }catch(Exception e) {
			 commonDto.setErrorMessage(e.getMessage());
			 
		 }
		 
		return commonDto;
	}


	@Override
	public CommonDto getClientDataByName(String clientName) {
		CommonDto commonDto=new CommonDto();
		try {
			AngularCrudEntity entity = angularCrudRepository.getClientDataByName(clientName);
			AngularCrudDto dto = new AngularCrudDto();
			
			
			 dto.setName(entity.getName());
			 dto.setPhone(entity.getPhone());
			 dto.setGender(entity.getGender());
			 dto.setEmail(entity.getEmail());
			 dto.setDate(entity.getDate());
			 dto.setModel(entity.getModel());
			 dto.setCity(entity.getCity());
			 dto.setArea(entity.getArea());
			 dto.setAddress(entity.getAddress());
			 
			 commonDto.setResponseObject(dto);
			
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setErrorMessage(e.getMessage());
			
		}
		
		
				return commonDto;
	}


	@Override
	public CommonDto editUsingaAngular(AngularCrudDto dto) {
		 CommonDto commonDto=new CommonDto();
		 try {
		      
			 AngularCrudEntity entity = angularCrudRepository.getClientDataByName(dto.getName());
		       entity.setName(dto.getName());
		       entity.setPhone(dto.getPhone());
		       entity.setGender(dto.getGender());
		       entity.setEmail(dto.getEmail());
		       entity.setDate(dto.getDate());
		       entity.setModel(dto.getModel());
		       entity.setCity(dto.getCity());
		       entity.setArea(dto.getArea());
		       entity.setAddress(dto.getAddress());
		       angularCrudRepository.save(entity);
		      commonDto.setResult("success");
		       
		      
		      
		     
		     
		     }
		     catch (Exception e) {
		      commonDto.setResult("invalid crentils");
		     }

	     
		return commonDto;
		
	}


	@Override
	public CommonDto getUserGridData() {
		CommonDto commonDto=new CommonDto();
		 try {
			 List<LoginEntity>list = loginRepository.findAll();
			 List<LoginDto>dtoList = new ArrayList<LoginDto>();
			 
			 
			 for(LoginEntity entity :list) {
				
				 LoginDto dto = new LoginDto();
				 
				 dto.setName(entity.getName());
				 dto.setPhone(entity.getPhone());
				 dto.setEmail(entity.getEmail());
				 dto.setPassword(entity.getPassword());
				 dto.setRole(entity.getRole());
				 dtoList.add(dto);
			 }
			 
			 commonDto.setResponseData(dtoList);
			 
		 }catch(Exception e) {
			 commonDto.setErrorMessage(e.getMessage());
			 
		 }
		 
		return commonDto;

		
	}


	

	
	
	
	@Override
public CommonDto getUserDataByName(String userId) {
		
		CommonDto commonDto=new CommonDto();
		try {
			LoginEntity entity = loginRepository.getAllDataByName(userId);
			LoginDto dto = new LoginDto();
			
			
			 dto.setName(entity.getName());
			 dto.setPhone(entity.getPhone());
			 dto.setEmail(entity.getEmail());
			 dto.setPassword(entity.getPassword());
			 dto.setRole(entity.getRole());
			 dto.setUserImage(entity.getUserImage());
			 
			 commonDto.setResponseObject(dto);
			
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setErrorMessage(e.getMessage());
			
		}
		
		
				return commonDto;

	}


	@Override
	public CommonDto editUser(LoginDto dto) {
		 CommonDto commonDto=new CommonDto();
		 try {
		      
			 if(dto.getName()!=null && !dto.getName().equalsIgnoreCase("")) {
				 LoginEntity entity = loginRepository.getAllDataByName(dto.getName());
				 if(entity != null) {
					 entity.setPhone(dto.getPhone());
					 entity.setEmail(dto.getEmail());
					 entity.setPassword(dto.getPassword());
					 entity.setRole(dto.getRole());
					 if(dto.getUserImage() != null && !dto.getUserImage().equalsIgnoreCase("")) {
						 entity.setUserImage(dto.getUserImage());
					 }
					 loginRepository.save(entity);
					 commonDto.setResult("Saved successfully");
				 }else {
					 commonDto.setResult("UserName not exists!!!");
				 }
			 }
		  	    
		   
		     
		     }
		     catch (Exception e) {
		      commonDto.setErrorMessage(e.getMessage());
		     }

	     
		return commonDto;
		
	}


	@Override
	public CommonDto viewClientData(String userId) {
		CommonDto commonDto=new CommonDto();
		try {
			LoginEntity entity = loginRepository.getAllDataByName(userId);
			LoginDto dto = new LoginDto();
			
			
			 dto.setName(entity.getName());
			 dto.setPhone(entity.getPhone());
			dto.setEmail(entity.getEmail());
			dto.setPassword(entity.getPassword());
			dto.setRole(entity.getRole());
			dto.setUserImage(entity.getUserImage());
			 commonDto.setResponseObject(dto);
			
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setErrorMessage(e.getMessage());
			
		}
		
		
				return commonDto;
	}


	@Override
	public CommonDto deleteUserData(String userId) {
			CommonDto commonDto = new CommonDto();
			
			
			
			try {
				
				if(userId!=null) {
					
					Long id = loginRepository.getIdByName(userId);
					loginRepository.deleteById(id);
					
					commonDto.setResult("Your file has been deleted");
				}else {
					commonDto.setResult("Your file were not deleted");
				}

			} catch (Exception e) {
				e.printStackTrace();
				commonDto.setErrorMessage(e.getMessage());
			}
			
			return commonDto;
		}


	@Override
	public CommonDto deletecliendData(String clientName) {
		CommonDto commonDto = new CommonDto();
		
		
		
		try {
			
			if(clientName!=null) {
				
				Long id = angularCrudRepository.getIdByName(clientName);
				angularCrudRepository.deleteById(id);
				
				commonDto.setResult("Your file has been deleted");
			}else {
				commonDto.setResult("Your file were not deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setErrorMessage(e.getMessage());
		}
		
		return commonDto;
	}
	
	private void mailConfiguration(AngularCrudDto dto) {
		try {
			Session session = null;
			Properties props = new Properties();
//			final String user = "rajasundar.sm@fasoftwares.com";
//			final String password = "ptVRFjt8KhPV";
			props.put("mail.smtp.auth",true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", "smtp.gmail.com");
//			props.put("mail.smtp.host", "smtp.zoho.in");
			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.ssl.enable", false);
//			props.put("mail.store.protocol", "pop3");
//			props.put("mail.transport.protocol", "smtp");
//			props.put("mail.debug.auth", true);
//			props.put("mail.smtp.ssl.trust", "smtp.zoho.in"); 

			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(user, password);
					return new PasswordAuthentication("premshrinivas1999@gmail.com","nwlwrpqkcjxwacgs");
				}
			});
			StringBuilder htmlBuilder = new StringBuilder();
			MimeMessage message = new MimeMessage(session);

				message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(dto.getEmail()));
//				message.addRecipients(Message.RecipientType.CC,
//						InternetAddress.parse(StockRequestEmailConfiguration.getOutletCc()));
					message.setFrom(new InternetAddress("premshrinivas1999@gmail.com"));
			message.setSubject("MYRIDE -Electric Bike Enquiry  "); 
			message.setContent(""
					+ "<html> <head> <style>table, td, th {border: 1px solid #ddd;text-align: left;} table { border-collapse: collapse; width: 100%;} "
					+"th, td {padding: 15px;}</style></head> <body> "
					+"<p>Thanks, "+dto.getName()+"! <br>"
					+ "Your Booking is confirmed.<br>"
					+ "Your vehicle Model is " + dto.getModel()+"<br>"
					+ "Mybike showroom  is expecting you  delivery on" + dto.getDate()+"</p><br>"
//					+"<table><tr><th>Type</th><th>Date</th><th>Time</th></tr><tr><td>CheckIn</td><td>"+dto.getDate()+"</td><td>"+dto.getTime()+"</td></tr><tr><td>CheckOut</td>"
//					+"<td>"+ dto.getDate()+"</td><td>"+dto.getTime()+"</td></tr></table><br><br>"
					+"<p>You'll pay the payment directly- Mybike showroom handles all payments - check below for more info</p><br>"
					+ "</body></html>",
					"text/html");

			Transport.send(message);
			System.err.println("Sent Pending Mail Successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}






	
	



