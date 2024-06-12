package com.training.pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;

import com.training.base.BasePage;

public class PageFactory {

	private static final HashMap<String, String> packageClassMap = new HashMap<>();

	static {
		try {
			getClassInPackage(new com.training.utilities.CommonUtilities().getApplicationProperty("page.packages"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BasePage initialize(String pageName) {
		BasePage page = null;
		String formattedPageName = getRemovedSpaceName(pageName);

		try {
			String packageName = packageClassMap.get(formattedPageName);
			if (packageName != null) {
				String pageClassFullName = packageName + "." + formattedPageName;
				page = (BasePage) Class.forName(pageClassFullName).getDeclaredConstructor().newInstance();
			} else {
				System.out.println(
						"Page Class with " + formattedPageName + " doesn't exist. Please provide a valid page name.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	private String getRemovedSpaceName(String pageName) {
		return pageName.trim().replaceAll("\\s+", "");
	}

	private static void getClassInPackage(String packageName) {
		packageName = packageName.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
		String[] classPathDirs = System.getProperty("java.class.path").split(System.getProperty("path.separator"));

		for (String classDir : classPathDirs) {
			try {
				File base = new File(classDir + File.separatorChar + packageName);
				for (File file : base.listFiles()) {
					if (!(file.getName().equalsIgnoreCase(".svn"))) {
						if (file.isDirectory() && !(file.getName().equalsIgnoreCase("factory"))) {
							getClassInPackage(packageName + "." + file.getName());
						} else if (file.getName().endsWith(".java")) {
							String name = file.getName().substring(0, file.getName().lastIndexOf("."));
							packageClassMap.put(name, packageName);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
