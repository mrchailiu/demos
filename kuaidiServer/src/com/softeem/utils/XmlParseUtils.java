package com.softeem.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.softeem.dto.ExpCode;

public class XmlParseUtils {

	private File file;
	
	public XmlParseUtils(File file) {
		this.file = file;
	}
	
	
	public List<ExpCode> getData(){
		List<ExpCode> codes = new ArrayList<ExpCode>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(file);
			List<Node> nodes = doc.selectNodes("Root/company");
			ExpCode code = null;
			for (Node node : nodes) {
				String key = node.selectSingleNode("key").getText();
				String com = node.selectSingleNode("com").getText();
				code = new ExpCode(key, com);
				codes.add(code);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return codes;
	}
	
}
