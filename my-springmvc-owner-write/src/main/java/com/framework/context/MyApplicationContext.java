/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ApplicationContext.java
 * @Package com.framework.context
 * @Copyright: 2018 All rights reserved.
 */
package com.framework.context;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.framework.annotation.MyAutowired;
import com.framework.annotation.MyController;
import com.framework.annotation.MyService;
import com.util.StringUtil;

/**
 * @ClassName: ApplicationContext
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月15日 下午11:37:01
 */
public class MyApplicationContext {

	private Properties prop = new Properties();
	
	private List<String> classCache = new ArrayList<String>();

	private Map<String, Object> INSTANCE = new ConcurrentHashMap<String, Object>();

	/**
	 * @Title: MyApplicationContext @Description:
	 *         TODO(这里用一句话描述这个方法的作用) @param: @throws
	 */
	public MyApplicationContext(String location) {
		InputStream in = null;
		try {
			// 定位
			in = this.getClass().getClassLoader().getResourceAsStream(location);
			// 加载
			prop.load(in);
			// 注册
			String packageName = prop.getProperty("scanPackageName");
			registerBean(packageName);
			// 实例化(初始化)
			doCreateBean();
			// 注入
			populateBean();
			System.out.println("************************************");
			System.out.println(" ********************************** ");
			System.out.println("  ********************************");
			System.out.println("   ******************************");
			System.out.println("IOC 容器已经完成初始化!!!");
		} catch (Exception e) {

		}
	}

	/**
	 * @throws IllegalAccessException
	 * @throws Exception
	 * @Title: populateBean @Description: TODO(这里用一句话描述这个方法的作用) @param: @return:
	 *         void @throws
	 */
	private void populateBean() throws Exception {
		// 首先要判断IOC容器中有没有东西
		if (INSTANCE.isEmpty()) {
			return;
		}
		for (Entry<String, Object> entry : INSTANCE.entrySet()) {
			Field[] fields = entry.getValue().getClass().getDeclaredFields();
			for (Field field : fields) {
				if (!field.isAnnotationPresent(MyAutowired.class)) {
					return;
				}
				MyAutowired myAutowired = field.getAnnotation(MyAutowired.class);
				String id = myAutowired.value().trim();
				// 如果id为空，就说明自己没有设置，默认根据类型注入
				if ("".equals(id)) {
					id = field.getType().getName();
				}
				// 设置私有变量的访问权限
				field.setAccessible(true);
				field.set(entry.getValue(), INSTANCE.get(id));
			}
		}
	}

	/**
	 * @Title: doCreateBean @Description: TODO(这里用一句话描述这个方法的作用) @param: @return:
	 *         void @throws
	 */
	private void doCreateBean() throws Exception {
		if (classCache.size() == 0) {
			return;
		}
		for (String className : classCache) {
			// spring中在这里判断了是否是JDK还是CGLib
			Class<?> clazz = Class.forName(className);
			// spring在这里要判断一下哪个类需要初始化，哪个类不需要初始化
			// 这里需要把那些注解的类初始化，例如：@Action @Service @Autowired @Controller等等常用的注解
			if (clazz.isAnnotationPresent(MyController.class)) {
				String id = StringUtil.toLowerCaseFirstOne(clazz.getSimpleName());
				INSTANCE.put(id, clazz.newInstance());
			} else if (clazz.isAnnotationPresent(MyService.class)) {
				MyService myService = clazz.getAnnotation(MyService.class);
				// 如果定义了名字，就先用它自己定义的名字
				String id = myService.value();
				if (!"".equals(id.trim())) {
					INSTANCE.put(id, clazz.newInstance());
					continue;
				}
				// 如果没有名字,就用默认规则
				// 1.类名首字母小写
				// 如果这个类是接口
				// 2.可以用类型匹配
				Class<?>[] interfaces = clazz.getInterfaces();
				for (Class<?> cls : interfaces) {
					INSTANCE.put(cls.getName(), clazz.newInstance());
				}
			} else {
				continue;
			}
		}
	}

	/**
	 * 就是把所有的class放入到一个集合里边
	 * 
	 * @Title: registerBean @Description: TODO(这里用一句话描述这个方法的作用) @param: @return:
	 *         void @throws
	 */
	private void registerBean(String packageName) {
		URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
		File fileDir = new File(url.getFile());
		for (File file : fileDir.listFiles()) {
			// 如果是一个文件夹，就继续递归
			if (file.isDirectory()) {
				registerBean(packageName + "." + file.getName());
			} else {
				// 如果是文件就把class文件放到一个内存中
				classCache.add(packageName + "." + file.getName().replace(".class", "").trim());
			}
		}
	}

	public Map<String, Object> getInstanceAll() {
		return INSTANCE;
	}

}