package com.fa.controller;

import javax.annotation.Resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.fa.dto.AngularCrudDto;
import com.fa.dto.CommonDto;
import com.fa.dto.LoginDto;
import com.fa.service.AngularCrudService;

@CrossOrigin(origins = "*" , maxAge = 3600)
@Controller
public class AngularCrudController {

	@Resource
	AngularCrudService angularCrudService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> login(@RequestBody LoginDto dto) {
		
	CommonDto  commonDto = angularCrudService.loginUsingaAngular(dto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/signup",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> signup(@RequestBody LoginDto dto) {
		
	CommonDto  commonDto = angularCrudService.signupUsingaAngular(dto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		
	}
	
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> register(@RequestBody AngularCrudDto dto) {
		
	CommonDto  commonDto = angularCrudService.registerUsingaAngular(dto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/getAllData",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> getAllData() {
		
	CommonDto  commonDto = angularCrudService.getAllUserData();
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	
	@RequestMapping(value = "/getClientDataByName",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> getClientDataByName(@RequestParam("clientName")String clientName) {
		
		
	CommonDto  commonDto = angularCrudService.getClientDataByName(clientName);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> edit(@RequestBody AngularCrudDto dto) {
		
	CommonDto  commonDto = angularCrudService.editUsingaAngular(dto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
	}
	@RequestMapping(value = "/getUserGridData",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> getUserGridData() {
		
	CommonDto  commonDto = angularCrudService.getUserGridData();
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	
	@RequestMapping(value = "/getUserDataByName",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> getUserDataByName(@RequestParam("userId")String userId) {
		
	CommonDto  commonDto = angularCrudService.getUserDataByName(userId);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	
	@RequestMapping(value = "/editUser",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> editUser(@RequestBody LoginDto dto) {
		
	CommonDto  commonDto = angularCrudService.editUser(dto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
	}
	@RequestMapping(value = "/viewClientData",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> viewClientData(@RequestParam("userId")String userId) {
		
		
	CommonDto  commonDto = angularCrudService.viewClientData(userId);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	@RequestMapping(value = "/deleteUserData",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> deleteUserData(@RequestParam("userId")String userId) {
		
		
	CommonDto  commonDto = angularCrudService.deleteUserData(userId);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}
	@RequestMapping(value = "/deletecliendData",method = RequestMethod.POST)
	public ResponseEntity<CommonDto> deletecliendData(@RequestParam("clientName")String clientName) {
		
	CommonDto  commonDto = angularCrudService.deletecliendData(clientName);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
		}

}
