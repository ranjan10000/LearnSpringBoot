package com.web.application.callexternalapi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;


@Component
public class ReadPropertyFile {

	public String loadWidgetScriptName(String webserviceName) {
		Properties a_prop = new Properties();
		FileInputStream fis = null;
		String procedureName = null;
		try {
			File a_config = ResourceUtils.getFile("classpath:procedure_config.properties");
			fis = new FileInputStream(a_config.toPath().toString());
			a_prop.load(fis);

			if (a_prop.get(webserviceName) != null) {
				procedureName = (String) a_prop.get(webserviceName);
				System.out.println(procedureName);
			}

		} catch (Exception e) {
			// LOGGER.error("Error Reading procedure_config.properties - "+e.toString());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return procedureName;

	}
}
