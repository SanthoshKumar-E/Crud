package com.fa.service;

import com.fa.dto.AngularCrudDto;
import com.fa.dto.CommonDto;
import com.fa.dto.LoginDto;

public interface AngularCrudService {

	CommonDto loginUsingaAngular(LoginDto dto);

	CommonDto signupUsingaAngular(LoginDto dto);

	CommonDto registerUsingaAngular(AngularCrudDto dto);

	CommonDto getAllUserData();

	CommonDto getClientDataByName(String clientName);

	CommonDto editUsingaAngular(AngularCrudDto dto);

	CommonDto getUserGridData();

	CommonDto getUserDataByName(String userId);

	CommonDto editUser(LoginDto dto);

	CommonDto viewClientData(String userId);

	CommonDto deleteUserData(String userId);

	CommonDto deletecliendData(String clientName);

	

	

	


	

	

}
