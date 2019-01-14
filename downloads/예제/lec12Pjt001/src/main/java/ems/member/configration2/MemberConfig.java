package ems.member.configration2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration
public class MemberConfig {
	//<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
//	<bean id="registerService" class="ems.member.service.StudentRegisterService">
//	<constructor-arg ref="studentDao" ></constructor-arg>
//	</bean>
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("shyie");
		infoDev.setUserPw("shyie111111");
		return infoDev;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("masterid");
		infoReal.setUserPw("masterpw");
		return infoReal;
	}
	
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
		dbInfos.put("dev",dataBaseConnectionInfoDev());
		dbInfos.put("real",dataBaseConnectionInfoReal());
		informationService.setDbInfos(dbInfos);
		
		return informationService;
	}
}
