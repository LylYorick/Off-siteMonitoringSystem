/**
 * 
 */
package org.work.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.work.web.po.Archives;
import org.work.web.po.Information;
import org.work.web.po.ArchivesHis;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class BeanCompare {

	/**
	 * 
	 * @param o1 原对象
	 * @param o2 比对对象
	 * @return 新对象
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object compareInformation(Object o1,Object o2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Class class1 = o1.getClass();
		//增加一个boolean型的数据，如果为true，则该方法返回空,因为只有不相等的时候才往历史记录表中插记录，add by yanghc 
		boolean isEquals = true;
		ArchivesHis o3 = new ArchivesHis();
		Field[] fields = class1.getDeclaredFields();
		Object vs="";
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			Class c = field.getType();
			//如下几个字段是不需要比对的
			if("oid".equals(field.getName()) || "boid".equals(field.getName()) || "bcatid".equals(field.getName()) ||"bupdatetime".equals(field.getName()) || "bmininame".equals(field.getName()) || "ishead".equals(field.getName())|| "isneed".equals(field.getName()))
					continue;
			if(!"java.lang.String".equals(c.getName()) && !"java.lang.Integer".equals(c.getName()) && !"java.lang.Double".equals(c.getName()))
				continue;
			Object v = PropertyUtils.getProperty(o1,field.getName())==null?"":PropertyUtils.getProperty(o1,field.getName());
			Object v1 = PropertyUtils.getProperty(o2,field.getName())==null?"":PropertyUtils.getProperty(o2,field.getName());
			if(v.equals(v1)){
				vs = v;
			}else{
				vs = "["+v+"]修改为:["+v1+"]";
				isEquals = false;
			}
			PropertyUtils.setProperty(o3, field.getName(), vs.toString());
		}
		if(isEquals){
			o3 = null;
		}
		return o3;
	}
	
	
	/**
	 * @param o1
	 * @param o2
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static ArchivesHis compareArchives(Archives o1,Archives o2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Class class1 = Archives.class;
		//增加一个boolean型的数据，如果为true，则该方法返回空,因为只有不相等的时候才往历史记录表中插记录，add by yanghc 
		boolean isEquals = true;
		//声明一个历史对象
		ArchivesHis his = new ArchivesHis();
		//通过反射获取Archives类的全部属性
		Field[] fields = class1.getDeclaredFields();
		//vs对象是干啥的？ 用于保存每个属性的修改值
		Object vs="";
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			Class c = field.getType();
			//如下几个字段是不需要比对的
			if(
				"oid".equals(field.getName())
				||"bupdatetime".equals(field.getName()) //更新时间
				||"bupdateuser".equals(field.getName())//更新人
				||"rateType".equals(field.getName())//评级表类型
				)
				continue;
			System.out.println("fieldName:" +field);
			if(!"java.lang.String".equals(c.getName()) 
					&& !"java.lang.Integer".equals(c.getName())
					&& !"java.lang.Double".equals(c.getName())
					&& !"java.math.BigDecimal".equals(c.getName())
					)
				continue;
			Object v = PropertyUtils.getProperty(o1,field.getName())==null?"":PropertyUtils.getProperty(o1,field.getName());
			Object v1 = PropertyUtils.getProperty(o2,field.getName())==null?"":PropertyUtils.getProperty(o2,field.getName());
			if(v.equals(v1)){
				vs = v;
			}else{
				vs = "["+v+"]修改为:["+v1+"]";
				isEquals = false;
			}
			PropertyUtils.setProperty(his, field.getName(), vs.toString());
		}
		if(isEquals){
			his = null;
		}
		return his;
	}
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Information information = new Information();
		Information information1 = new Information();
		information.setBbrchnum(123);
		information.setBaddr("test");
		information.setBbrchnum(123);
		information.setBdept("detp");
		information.setBdeptlead("lead");
		information.setBdeptleadphe("phe");
		information.setBdeptleadtel("tel");
		information.setBfax("fax");
		information.setBlastamt(2003.1);
		information.setBlastnet(2003.2);
		information.setBwork("work");
		
		information1.setBbrchnum(1234);
		information1.setBaddr("test1");
		information1.setBbrchnum(1234);
		information1.setBdept("detp1");
		information1.setBdeptlead("lead1");
		information1.setBdeptleadphe("phe1");
		information1.setBdeptleadtel("tel1");
		information1.setBfax("fax1");
		information1.setBlastamt(2004.1);
		information1.setBlastnet(2004.2);
		information1.setBwork("work1");
		BeanUtils.copyProperties(information1,information);
		try {
			ArchivesHis informationhis = (ArchivesHis) BeanCompare.compareInformation(information, information1);
			System.out.println("ok");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
