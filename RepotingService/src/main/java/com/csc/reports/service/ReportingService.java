package com.csc.reports.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc.reports.model.Adress;
import com.csc.reports.model.UserInfo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@RestController
public class ReportingService {
	private static final String TEMPLATE = "/reports/Blank_Letter.jrxml";

	@RequestMapping("/report/{userId}")
	public String generateReport(@PathVariable String userId) {
		try {
			// 1. Add report parameters
			HashMap<String, Object> params = new HashMap<>();
			params.put("Title", "User Report");

			// 2. Retrieve template
			InputStream reportStream = this.getClass().getResourceAsStream(TEMPLATE);

			// 3. Convert template to JasperDesign
			JasperDesign jd = JRXmlLoader.load(reportStream);

			// 4. Compile design to JasperReport
			JasperReport jr = JasperCompileManager.compileReport(jd);

			// 5. Create the JasperPrint object
			// Make sure to pass the JasperReport, report parameters, and data
			// source
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(constructMockList());
			JasperPrint jp = JasperFillManager.fillReport(jr, params, dataSource);

			// 6. Create an output byte stream where data will be written
			JasperExportManager.exportReportToPdfFile(jp, Calendar.getInstance().getTimeInMillis() + ".pdf");
			return "Successfully GENERATED";
		} catch (JRException jre) {
			throw new RuntimeException(jre);
		}
	}

	private List<UserInfo> constructMockList() {
		List<UserInfo> items = new ArrayList<>();
		items.add(new UserInfo("1", "Mantas", "Developer", new Adress("gerulaicio", "1", "Vilnius")));
		items.add(new UserInfo("2", "Christian", "Testing engineer", new Adress("gerulaicio", "2", "Vilnius")));
		items.add(new UserInfo("3", "Nizar", "Dev lead", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("4", "Nizar", "Developer", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("5", "Dmitrij", "Developer", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("6", "Nikita", "Developer", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("7", "Aleksandr", "Developer", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("8", "Paulita", "Developer", new Adress("gerulaicio", "3", "Vilnius")));
		items.add(new UserInfo("9", "Nizar", "Developer", new Adress("gerulaicio", "98", "Vilnius")));
		items.add(new UserInfo("10", "Nerij", "Developer", new Adress("gerulaicio", "98", "Vilnius")));	
		items.add(new UserInfo("11", "Anraom", "Developer", new Adress("gerulaicio", "222", "Vilnius")));	
		items.add(new UserInfo("12", "Neill", "Developer", new Adress("gerulaicio", "98", "Vilnius")));	
		items.add(new UserInfo("13", "Arturas", "Developer", new Adress("gerulaicio", "98", "Vilnius")));
		items.add(new UserInfo("14", "Jonas", "Jr. Developer", new Adress("gerulaicio", "98", "Vilnius")));
		items.add(new UserInfo("15", "Arturas", "Jr. Developer", new Adress("gerulaicio", "103", "Vilnius")));
		return items;
	}

}