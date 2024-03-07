import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

//Write/fix the code as needed to remove warnings/errors and complete the lab 
public class Courses {
	ArrayList<Course> courses = new ArrayList<>();
	
	void loadCourses(){
		courses.add(new Course("COSC","111","Computer Programming I","Introduction to the design, implementation, and understanding of computer programs. Topics include problem solving, algorithm design, and data and procedural abstraction, with emphasis on the development of working programs. This course should be followed by COSC 121.\\n\"+\r\n"
				+ "								\"Pre-reqs: A score of 70% or higher in one of PREC 12, MATH 12, MATH 125, MATH 126","PREC 12, MATH 12, MATH 125, MATH 126"));
		courses.add(new Course("COSC","121","Computer Programming II","Advanced programming in the application of software engineering techniques to the design and implementation of programs manipulating complex data structures.","111"));
		courses.add(new Course("COSC","222","Data Structures","Introduction to the design, implementation and analysis of data structures. Topics will include lists, stacks, queues, trees, and graphs. [3-2-0]\r\n"
				+ "Prerequisite: A score of 60% or higher in COSC 121.","121"));
		courses.add(new Course("COSC","122","Computer Fluency","Introduction to computer skills (electronic communication, websites, Internet, document editing, programming, data analysis using spreadsheets/databases) and concepts (information representation, abstraction, algorithmic thinking). Course objectives are lifelong productivity and understanding of technology in society.","Pre-reqs: None"));
		courses.add(new Course("COSC","211","Machine Architecture","Organization and design of computer systems and their impact on the practice of software development. Instruction set architecture and assembly programming languages, design of central processing units (CPU), memory hierarchy and cache organization, input and output programming.","Pre-reqs: COSC 121"));
		courses.add(new Course("COSC","301","Introduction to Data Analytics","Software development and techniques for computation, analysis, and visualization of data. Manipulation of small and large data sets. Automation using scripting. Credit will be granted for only one of COSC 301, DATA 301 or DATA 501.","Pe-reqs: Third year standing"));
		courses.add(new Course("COSC","303","Numerical Analysis","Numerical techniques for basic mathematical processes and their analysis. Taylor polynomials, root-finding, linear systems, eigenvalues, approximating derivatives, locating minimizers, approximating integrals, solving differential equations. Credit will be granted for only one of COSC 303 or MATH 303.","Pre-reqs: All of MATH 200, MATH 221 and either (a) COSC 111 or (b) DATA 301."));
	
	}
	
	public ArrayList<String> listAll(){
		Course c;
		ArrayList<String> output = new ArrayList<>();
		for (int i=0; i < courses.size(); i++){
			c = (Course) courses.get(i);
			System.out.println(c.accr + " " + c.number + " " + c.title );
			output.add(c.accr + " " + c.number + " " + c.title+"\n");
		}
		return output;
	}
	
	public ArrayList<String> displayCourse(String number){
		Course c;
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0; i<courses.size();i++) {
			c = (Course) courses.get(i);
			if(number.equals(c.number)) {
				System.out.println(c.accr + " " + c.number+" " + c.title+" \n" + c.desc+" "+c.prereq );
				output.add(c.accr + " " + c.number+" " + c.title+" \n" + c.desc+" "+c.prereq);
			}
		}
		return output;
	}
	
	public ArrayList<String> ListAllIter() {
		
		Iterator<Course> i = courses.iterator();
		ArrayList<String> output = new ArrayList<>();
		int p = 0;
		while(i.hasNext()) {
			Course c = i.next();
			System.out.println(c.accr + " " + c.number + " " + c.title);
			output.add(c.accr + " " + c.number + " " + c.title+"\n");
			p++;
		}
		return output;
	}
	public ArrayList<String> listAllStream() {
		ArrayList<String> output = new ArrayList<>();
		courses.stream()
        .forEach(c -> {System.out.println(c.accr + " " + c.number + " " + c.title);
        			output.add(c.accr + " " + c.number + " " + c.title+"\n");
        });
		return output;
	}
	public long countCourses() {
		long numCourses = courses.stream()
					.count();
		System.out.println(numCourses);
		return numCourses;
				
	}
	public ArrayList<String> databaseContainers(){
		ArrayList<String> database = new ArrayList<String>();
		int count = 0;
		for(Course c:courses) {
			if(c.desc.contains("database")) {
				database.add(c.accr);
				count++;
			}
		}
		return database;
	}
	public ArrayList<Integer> sortedByNumber(){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(Course c:courses)
				output.add(Integer.parseInt(c.number));
				Collections.sort(output);
		return output;
	}
	
	public static void main(String[] args) {
		Courses L = new Courses();
		L.loadCourses();
		L.listAll();
		L.displayCourse("303");
		//L.ListAllIter();
		
		//L.listAllStream();
		//L.countCourses();
	
	}

}
