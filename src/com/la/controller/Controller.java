package com.la.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.la.model.Subject;
import com.la.model.Teacher;
import com.la.model.City;
import com.la.model.Class;
import com.la.model.ClassSubject;
import com.la.model.ClassSubjectTeacher;
import com.la.model.Country;
import com.la.model.State;
import com.la.model.Student;
import com.la.util.HibernateUtil;


/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/showSubjects", "/addSubject", "/logout", "/showClasses", 
							"/addClass","/showAddStudents", "/addStudent", "/showAddTeacher",
							"/showStudents", "/showTeachers", "/addTeacher", "/assignSubjectToClass",
							"/showAssignClassSubjects", "/assignClassToTeacher", "/showAssignClassToTeacher",
							"/showAssignSubjectToTeacher", "/assignSubjectToTeacher",
							"/showClassReportRequestPage", "/generateClassReport"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();

		if(url.contains("showAddStudents")) {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();

			List<Class> classesList = session.createQuery("from Class").list();			
			request.setAttribute("classesList", classesList);			

			List<Country> countryList = session.createQuery("from Country").list();			
			request.setAttribute("countryList", countryList);
						
			List<State> stateList = session.createQuery("from State").list();			
			request.setAttribute("stateList", stateList);
			
			List<City> cityList = session.createQuery("from City").list();			
			request.setAttribute("cityList", cityList);
			
			RequestDispatcher rd=request.getRequestDispatcher("addStudent.jsp");  
            rd.forward(request, response);
			
			session.close();			


		}else if(url.contains("showAddTeacher")) {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			List<City> cityList = session.createQuery("from City").list();			
			request.setAttribute("cityList", cityList);
			
			List<State> stateList = session.createQuery("from State").list();			
			request.setAttribute("stateList", stateList);
			
			List<Country> countryList = session.createQuery("from Country").list();			
			request.setAttribute("countryList", countryList);
			
			RequestDispatcher rd=request.getRequestDispatcher("addTeacher.jsp");  
            rd.forward(request, response);
			
			session.close();			


		}else if(url.contains("showStudents")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			List<Student> studentList = session.createQuery("from Student").list();

			request.setAttribute("studentList", studentList);
			RequestDispatcher rd=request.getRequestDispatcher("showStudents.jsp");  
            rd.forward(request, response);
			
			session.close();
			
		}else if(url.contains("addStudent")) {
			String studentName = request.getParameter("studentName");
			String birthDate = request.getParameter("birthDate");
			String addressLine1 = request.getParameter("addressLine1");
			String addressLine2 = request.getParameter("addressLine2");
			Integer cityId = Integer.parseInt(request.getParameter("selectCity"));
			Integer stateId = Integer.parseInt(request.getParameter("selectState"));
			Integer countryId = Integer.parseInt(request.getParameter("selectCountry"));
			String classId = request.getParameter("selectClass");
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			City city = new City();
			city.setCityId(cityId);
			
			State state = new State();
			state.setStateId(stateId);
			
			Country country = new Country();
			country.setCountryId(countryId);
			
			Class aClass = new Class();
			if(classId!=null) {
				aClass.setClassId(Integer.parseInt(classId));	
			}			
			
			Student student = new Student(studentName, addressLine1, addressLine2, birthDate, city, state, country, aClass);
			
			session.save(student);	
			
			session.close();
			
			if(student!=null) {
				request.getSession().setAttribute("message", "Entry for Student '" + student.getStudentName() + "' was added succesfully!!");
			}

			RequestDispatcher rd=request.getRequestDispatcher("showAddStudents");  
            rd.forward(request, response);
		
		}else if(url.contains("showTeachers")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			List<Teacher> teacherList = session.createQuery("from Teacher").list();

			request.setAttribute("teacherList", teacherList);
			RequestDispatcher rd=request.getRequestDispatcher("showTeachers.jsp");  
            rd.forward(request, response);
			
			session.close();
		}else if(url.contains("addTeacher")) {
			String teacherName = request.getParameter("teacherName");
			String birthDate = request.getParameter("birthDate");
			String addressLine1 = request.getParameter("addressLine1");
			String addressLine2 = request.getParameter("addressLine2");
			Integer cityId = Integer.parseInt(request.getParameter("selectCity"));
			Integer stateId = Integer.parseInt(request.getParameter("selectState"));
			Integer countryId = Integer.parseInt(request.getParameter("selectCountry"));
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			City city = new City();
			city.setCityId(cityId);
			
			State state = new State();
			state.setStateId(stateId);
			
			Country country = new Country();
			country.setCountryId(countryId);
			
			Teacher teacher = new Teacher(teacherName, addressLine1, addressLine2, birthDate, city, state, country, null);
			
			session.save(teacher);	
			
			session.close();
			
			if(teacher!=null) {
				request.getSession().setAttribute("message", "Entry for Teacher '" + teacher.getTeacherName() + "' was added succesfully!!");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("showAddTeacher");  
            rd.forward(request, response);
		}else if(url.contains("showClasses")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			List<Class> classesList = session.createQuery("from Class").list();

			request.setAttribute("classesList", classesList);
			RequestDispatcher rd=request.getRequestDispatcher("showClasses.jsp");  
            rd.forward(request, response);
			
			session.close();			
		}else if(url.contains("addClass")) {
			String className = request.getParameter("className");
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			if(className!=null && className.isEmpty()) {
				request.getSession().setAttribute("message", "Class '" + className + "' was added succesfully!!");
			}

			Class aclass = new Class(className);
			
			session.save(aclass);	
			
			session.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("addClass.jsp");  
            rd.forward(request, response);
            
		}else if(url.endsWith("showSubjects")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			List<Subject> subjectList = session.createQuery("from Subject").list();

			request.setAttribute("subjectList", subjectList);
			RequestDispatcher rd=request.getRequestDispatcher("showSubjects.jsp");
            rd.forward(request, response);
			
			session.close();
		}else if(url.contains("addSubject")) {
			String subjectName = request.getParameter("subjectName");
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			if(subjectName!=null && !subjectName.isEmpty()) {
				request.getSession().setAttribute("message", "Subject '" + subjectName + "' was added succesfully!!");
			}
			
			Subject subject = new Subject(subjectName);
			
			session.save(subject);	
			
			session.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("addSubject.jsp");  
            rd.forward(request, response);
            
		}else if(url.contains("showAssignClassSubjects")){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			String classId = request.getParameter("selectClass");

			List<Class> classList = session.createQuery("from Class").list();			
			request.setAttribute("classList", classList);
			
			List<Subject> allSubjectsList = session.createQuery("from Subject").list();			
			request.setAttribute("allSubjectsList", allSubjectsList);
			
			List<ClassSubject> classSubjectsList = new ArrayList<ClassSubject>();
			if(classId!=null && !classId.isEmpty()) {
				classSubjectsList = session.createQuery("from ClassSubject cs where cs.aClass.classId="+ classId).list();			
				
				List<Class> displayingSubjectsForClass  = session.createQuery("from Class c where c.classId="+ classId).list();	
				if(displayingSubjectsForClass!=null && !displayingSubjectsForClass.isEmpty()) {
					request.setAttribute("displayingSubjectsForClass", displayingSubjectsForClass.get(0).getClassName());
				}else {
					request.setAttribute("displayingSubjectsForClass", "");
				}
			}
			
			request.setAttribute("classSubjectsList", classSubjectsList);

			
			RequestDispatcher rd=request.getRequestDispatcher("assignSubjectToClass.jsp");  
            rd.forward(request, response);
			
			session.close();
			
		}else if(url.contains("assignSubjectToClass")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			String classId = request.getParameter("selectClass");
            String subjectId = request.getParameter("selectSubject");
            
            Class aClass = new Class();
            aClass.setClassId(Integer.parseInt(classId));

            Subject subject = new Subject();
            subject.setSubjectId(Integer.parseInt(subjectId));
            
            ClassSubject cs = new ClassSubject();
            cs.setaClass(aClass);
            cs.setSubject(subject);
            try {
            	session.saveOrUpdate(cs);	
            }catch(Exception e) {
            	
            }
			
			session.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("showAssignClassSubjects");  
            rd.forward(request, response);
            
		}else if(url.contains("showAssignClassToTeacher")){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			String teacherId = request.getParameter("selectTeacher");

			List<Teacher> teacherList = session.createQuery("from Teacher").list();			
			request.setAttribute("teacherList", teacherList);
			
			List<Class> allClassList = session.createQuery("from Class").list();			
			request.setAttribute("allClassList", allClassList);
			
			List<ClassSubjectTeacher> cstList = new ArrayList<ClassSubjectTeacher>();
			if(teacherId!=null && !teacherId.isEmpty()) {
				cstList = session.createQuery("from ClassSubjectTeacher cst where cst.teacher.teacherId="+ teacherId).list();			
				
				List<Teacher> displayingClassSubjrectsForTeacher  = session.createQuery("from Teacher t where t.teacherId="+ teacherId).list();	
				if(displayingClassSubjrectsForTeacher!=null && !displayingClassSubjrectsForTeacher.isEmpty()) {
					request.setAttribute("displayingClassSubjrectsForTeacher", displayingClassSubjrectsForTeacher.get(0).getTeacherName());
				}else {
					request.setAttribute("displayingClassSubjrectsForTeacher", "");
				}
			}
			
			request.setAttribute("teacherClassList", cstList);

			
			RequestDispatcher rd=request.getRequestDispatcher("assignClassToTeacher.jsp");  
            rd.forward(request, response);
			
			session.close();
			
		}else if(url.contains("assignClassToTeacher")) {
					
			RequestDispatcher rd=request.getRequestDispatcher("showAssignSubjectToTeacher");  
            rd.forward(request, response);
            
		}else if(url.contains("showAssignSubjectToTeacher")){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			String teacherId = request.getParameter("selectTeacher");
			String classId = request.getParameter("selectClass");
			
			Teacher teacher = (Teacher) session.createQuery("from Teacher t where t.teacherId="+teacherId).list().get(0);
			request.setAttribute("teacher", teacher);
			
			Class aClass = (Class) session.createQuery("from Class c where c.classId="+classId).list().get(0);
			request.setAttribute("aClass", aClass);

			List<ClassSubject> classSubjectList = session.createQuery("from ClassSubject cs where cs.aClass.classId="+classId).list();			
			request.setAttribute("classSubjectList", classSubjectList);
			
			System.out.println("))))))))))))))))))))" + classSubjectList.size());
						
			List<ClassSubjectTeacher> cstList = new ArrayList<ClassSubjectTeacher>();
			if(teacherId!=null && !teacherId.isEmpty()) {
				cstList = session.createQuery("from ClassSubjectTeacher cst where cst.teacher.teacherId="+ teacherId).list();			
				
				List<Teacher> displayingClassSubjrectsForTeacher  = session.createQuery("from Teacher t where t.teacherId="+ teacherId).list();	
				if(displayingClassSubjrectsForTeacher!=null && !displayingClassSubjrectsForTeacher.isEmpty()) {
					request.setAttribute("displayingClassSubjrectsForTeacher", displayingClassSubjrectsForTeacher.get(0).getTeacherName());
				}else {
					request.setAttribute("displayingClassSubjrectsForTeacher", "");
				}
			}
			
			request.setAttribute("classSubjectTeacherList", cstList);

			
			RequestDispatcher rd=request.getRequestDispatcher("assignSubjectToTeacher.jsp");  
            rd.forward(request, response);
			
			session.close();

		}else if(url.contains("assignSubjectToTeacher")){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
		
			String teacherId = request.getParameter("selectTeacher");
			String classId = request.getParameter("selectClass");
			String subjectId = request.getParameter("selectSubject");
			
			List<Teacher> teacherList = session.createQuery("from Teacher t where t.teacherId ="+teacherId).list();
			Teacher teacher = null;
			if(teacherList!=null && !teacherList.isEmpty()) {
				teacher = teacherList.get(0);
			}
			
			List<ClassSubject> csl = session.createQuery("from ClassSubject cs where cs.aClass.classId="+classId+ " and cs.subject.subjectId=" + subjectId).list();
			ClassSubject cs = null;
			if(csl!=null && !csl.isEmpty()) {
				cs = csl.get(0);
						
				if(cs!=null && teacher!=null) {
					List<ClassSubjectTeacher> cstl = session.createQuery("from ClassSubjectTeacher cst where cst.teacher.teacherId ="+teacherId).list();
					ClassSubjectTeacher cst = null;
					if(cstl!=null && !cstl.isEmpty()) {
						cst = cstl.get(0);
						if(cst.getClassSubjectList().isEmpty() || !cst.getClassSubjectList().contains(cs)) {
							cst.getClassSubjectList().add(cs);							
						}					
					}else {
						List<ClassSubject> cslNew = new ArrayList<ClassSubject>();
						cslNew.add(cs);						
						cst = new ClassSubjectTeacher(csl, teacher);
					}

					try{
			           Transaction txn = session.beginTransaction();

						session.save(cst);
						txn.commit();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
						
			}
			
			session.close();

			RequestDispatcher rd=request.getRequestDispatcher("showAssignClassToTeacher");  
            rd.forward(request, response);
			
			
		}else if(url.contains("showClassReportRequestPage")) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
			
			List<Class> allClassList = session.createQuery("from Class").list();			
			request.setAttribute("allClassList", allClassList);
						
			RequestDispatcher rd=request.getRequestDispatcher("classReportRequest.jsp");  
            rd.forward(request, response);
			
			session.close();

		}else if(url.contains("generateClassReport")) {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
			Session session = sessionFactory.openSession();
		
			String classId = request.getParameter("selectClass");
			
			//all class list
			List<Class> allClassList = session.createQuery("from Class").list();			
			request.setAttribute("allClassList", allClassList);
			
			
			//selected class
			List<Class> aClassList =  session.createQuery("from Class c where c.classId ="+ classId).list();
			Class aClass = null;
			if(aClassList!=null && !aClassList.isEmpty()) {
				aClass = aClassList.get(0);
			}
			
			//list of subjects
			List<Subject> subjectList =  session.createQuery("from ClassSubject cs where cs.aClass.classId ="+ classId).list();
			
			//list of student
			List<Student> studentList =  session.createQuery("from Student s  where s.aclass.classId ="+ classId).list();
			
			//list of teachers
			List<Teacher> teacherList = new ArrayList<Teacher>();
			List<ClassSubjectTeacher> cstList =  session.createQuery("from ClassSubjectTeacher").list();
			for(ClassSubjectTeacher cst: cstList ) {
				for(ClassSubject cs: cst.getClassSubjectList()) {
				    if(cs.getaClass().getClassId() == Integer.parseInt(classId)) {
				    	teacherList.add(cst.getTeacher());
				    	break;
				    }
				}
				
			}
			
			request.setAttribute("classReportSubjectList", subjectList);
			request.setAttribute("classReportStudentList", studentList);
			request.setAttribute("classReportTracherList", teacherList);
			request.setAttribute("selectedClass", aClass);
			request.setAttribute("allClassList", allClassList);

			
			RequestDispatcher rd=request.getRequestDispatcher("classReportResponse.jsp");  
            rd.forward(request, response);
			
			session.close();

			
		}if(url.contains("logout")) {
			request.getSession().setAttribute("userId", 0);
		    response.sendRedirect("home.jsp");
		}
	}
	

}


