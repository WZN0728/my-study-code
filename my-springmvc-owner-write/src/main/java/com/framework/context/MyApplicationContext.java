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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��15�� ����11:37:01
 */
public class MyApplicationContext {

	private Properties prop = new Properties();
	
	private List<String> classCache = new ArrayList<String>();

	private Map<String, Object> INSTANCE = new ConcurrentHashMap<String, Object>();

	/**
	 * @Title: MyApplicationContext @Description:
	 *         TODO(������һ�仰�����������������) @param: @throws
	 */
	public MyApplicationContext(String location) {
		InputStream in = null;
		try {
			// ��λ
			in = this.getClass().getClassLoader().getResourceAsStream(location);
			// ����
			prop.load(in);
			// ע��
			String packageName = prop.getProperty("scanPackageName");
			registerBean(packageName);
			// ʵ����(��ʼ��)
			doCreateBean();
			// ע��
			populateBean();
			System.out.println("************************************");
			System.out.println(" ********************************** ");
			System.out.println("  ********************************");
			System.out.println("   ******************************");
			System.out.println("IOC �����Ѿ���ɳ�ʼ��!!!");
		} catch (Exception e) {

		}
	}

	/**
	 * @throws IllegalAccessException
	 * @throws Exception
	 * @Title: populateBean @Description: TODO(������һ�仰�����������������) @param: @return:
	 *         void @throws
	 */
	private void populateBean() throws Exception {
		// ����Ҫ�ж�IOC��������û�ж���
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
				// ���idΪ�գ���˵���Լ�û�����ã�Ĭ�ϸ�������ע��
				if ("".equals(id)) {
					id = field.getType().getName();
				}
				// ����˽�б����ķ���Ȩ��
				field.setAccessible(true);
				field.set(entry.getValue(), INSTANCE.get(id));
			}
		}
	}

	/**
	 * @Title: doCreateBean @Description: TODO(������һ�仰�����������������) @param: @return:
	 *         void @throws
	 */
	private void doCreateBean() throws Exception {
		if (classCache.size() == 0) {
			return;
		}
		for (String className : classCache) {
			// spring���������ж����Ƿ���JDK����CGLib
			Class<?> clazz = Class.forName(className);
			// spring������Ҫ�ж�һ���ĸ�����Ҫ��ʼ�����ĸ��಻��Ҫ��ʼ��
			// ������Ҫ����Щע������ʼ�������磺@Action @Service @Autowired @Controller�ȵȳ��õ�ע��
			if (clazz.isAnnotationPresent(MyController.class)) {
				String id = StringUtil.toLowerCaseFirstOne(clazz.getSimpleName());
				INSTANCE.put(id, clazz.newInstance());
			} else if (clazz.isAnnotationPresent(MyService.class)) {
				MyService myService = clazz.getAnnotation(MyService.class);
				// ������������֣����������Լ����������
				String id = myService.value();
				if (!"".equals(id.trim())) {
					INSTANCE.put(id, clazz.newInstance());
					continue;
				}
				// ���û������,����Ĭ�Ϲ���
				// 1.��������ĸСд
				// ���������ǽӿ�
				// 2.����������ƥ��
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
	 * ���ǰ����е�class���뵽һ���������
	 * 
	 * @Title: registerBean @Description: TODO(������һ�仰�����������������) @param: @return:
	 *         void @throws
	 */
	private void registerBean(String packageName) {
		URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
		File fileDir = new File(url.getFile());
		for (File file : fileDir.listFiles()) {
			// �����һ���ļ��У��ͼ����ݹ�
			if (file.isDirectory()) {
				registerBean(packageName + "." + file.getName());
			} else {
				// ������ļ��Ͱ�class�ļ��ŵ�һ���ڴ���
				classCache.add(packageName + "." + file.getName().replace(".class", "").trim());
			}
		}
	}

	public Map<String, Object> getInstanceAll() {
		return INSTANCE;
	}

}