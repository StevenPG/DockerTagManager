package com.stevengantz.docker.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stevengantz.docker.exception.RegistryNotFoundException;

public class ConfiguredRegistries {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private List<RegistryItem> items;

	public ConfiguredRegistries() {
		try {
			JSONParser parser = new JSONParser();
			items = new ArrayList<>();

			// TODO - Place into application.properties
			JSONObject obj = (JSONObject) parser.parse(new FileReader("./config/config.json"));

			// Pull keys, map into RegistryItems and add to List
			Iterator<?> keyIter = obj.keySet().iterator();
			while (keyIter.hasNext()) {
				String key = (String) keyIter.next();
				RegistryItem ritem = new RegistryItem();
				ritem.setRegistryLabel(key);
				ritem.setRegistryURL(obj.get(key).toString());

				items.add(ritem);
			}

		} catch (FileNotFoundException e) {
			// TODO - Update to spring boot path
			logger.error("FileNotFoundException thrown searching for ./config/config.json file");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException occurred while attempting to read from configuration file");
			e.printStackTrace();
		} catch (ParseException e) {
			logger.error("ParseException occurred while attempting to parse configuration file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the registry URL associated with a specific key
	 * @throws RegistryNotFoundException thrown if registry is not found in configuration
	 */
	public String getURLFromName(String name) throws RegistryNotFoundException {
		for(RegistryItem regi : items) {
			if(regi.getRegistryLabel().equals(name)) {
				return regi.getRegistryURL();
			}
		}
		// Label must not exist if exception is reached
		throw new RegistryNotFoundException();
	}

	public List<RegistryItem> getItems() {
		return items;
	}

	public void setItems(List<RegistryItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfiguredRegistries: ");
		for (RegistryItem item : this.items) {
			builder.append(item.getRegistryLabel() + ": " + item.getRegistryURL() + ", ");
		}
		return builder.toString();
	}

}
