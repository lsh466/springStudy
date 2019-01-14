package ems.member.configration2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;
@Configuration
public class MemberConfig3 {
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoDev;
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoReal;
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService informationService = new EMSInformationService();
		informationService.setInfo("Education Management System program was developed in 2015.");
		informationService.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		informationService.setVer("The version is 1.0");
		informationService.setsYear(2015);
		informationService.setsMonth(1);
		informationService.setsDay(1);
		informationService.seteYear(2015);
		informationService.seteMonth(2);
		informationService.seteDay(28);
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		informationService.setDevelopers(developers);
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		informationService.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev",dataBaseConnectionInfoDev);
		dbInfos.put("real",dataBaseConnectionInfoReal);
		informationService.setDbInfos(dbInfos);
		
		return informationService;
	}
}
