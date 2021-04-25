package edu.odu.cs.cs350;

import java.util.List;
import java.util.ArrayList;

/**
 * Nothing much to see here...
 * 
 * @author kchappel & hjenkins & lveri
 *
 */

public class Snapshot{
	
	private String dateTaken = "";
	private static List<SnapshotLine> courses=new ArrayList<SnapshotLine>();
	
	public Snapshot() {
		
	}
	
	public Snapshot(List<SnapshotLine> beans,String date) {
		courses=beans;
		dateTaken=date;
		setDate(date);
		setCourses(beans);
	}
	
	public String getDate() {return this.dateTaken;}
	public void setDate(String d) {
		this.dateTaken=d;
	}
	
	public List<SnapshotLine> getCourses(){return courses;}
	public void setCourses(List<SnapshotLine> beans) {
		for(SnapshotLine co:courses) { //co-course
			if(isAcceptedType(co.getLink())==true) {
				addCourse(co);
			}
		}
	}
	
	public static void addCourse(SnapshotLine bean) {
		int a=0;
		
			for(SnapshotLine ex:courses) { //goes through courses
				if(bean.getName()==ex.getName()) {
					if(bean.getCrosslistGroup()!=ex.getCrosslistGroup()) {//adds members to existing course
						int newCap,newEnroll;
						newCap=bean.getOverallCapacity()+ex.getOverallCapacity();
						newEnroll=bean.getOverallEnrollment()+ex.getOverallEnrollment();
						ex.setOverallCapacity(newCap);
						ex.setOverallEnrollment(newEnroll);
						a=1;
					}
				}
			}if(a!=1) {courses.add(bean);}
	}
	
	public static boolean isAcceptedType(String type) {
		if(type==null||type.contains("1")) {return true;}
		else {return false;}
	}
}
