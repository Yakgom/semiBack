package com.kh.employee.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.employee.controller.EmployeeController;
import com.kh.employee.model.vo.Employee;

public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public void mainMenu() {

		while (true) {

			System.out.println("==========사원 관리 프로그램==========");

			System.out.println("1.회원 전체 조회");
			System.out.println("2.부서 동일 사원조회");
			System.out.println("3.직급 동일 사원조회");
			System.out.println("4.사원 상세조회");
			System.out.println("5.급여 높은 5명 조회");
			System.out.println("6.급여 낮은 5명 조회");
			System.out.println("7.사원 추가");
			System.out.println("8.사원 정보 수정");
			System.out.println("9.사원 퇴사");
			System.out.println("10.프로그램 종료");
			System.out.print("메뉴 번호를 입력해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1: {
				findAll();
				break;
			}
			case 2: {
				findByDept();
				break;
			}
			case 3: {
				findByJob();
				break;

			}
			case 4: {
				findById();
				break;
			}
			case 5: {
				findByHighSalary();
				break;
			}
			case 6: {
				findByLowSalary();
				break;
			}
			case 7: {
				save();
				break;

			}
			case 8: 
				update();
			{
				break;
			}
			case 9: {
				delete();
				break;
			}
			case 10: {
				System.out.println("프로그램을 종료합니다");
				return;
			}
			default: {
				System.out.println("잘못된 번호 입니다.");
			}

			}

		}

	}

	public void findAll() {
		List<Employee> employees = new ArrayList<Employee>();

		employees = ec.findAll();

		if (!employees.isEmpty()) {

			employees.stream().forEach(e -> {

				System.out.println("==============================");
				System.out.println("사원 번호 : " + e.getEmpId());
				System.out.println("사원 이름 : " + e.getEmpName());
				System.out.println("사원 급여 : " + e.getSalary());
				System.out.println("사원 부서 : " + e.getDetpCode());
				System.out.println("사원 직급 : " + e.getJobCode());

			});

		} else {
			System.out.println("조회에 실패하였습니다.");
		}

	}

	public void findByDept() {
		List<Employee> employees = new ArrayList<Employee>();

		System.out.println("\n부서별 조회 서비스입니다");

		System.out.print("조회할 부서를 입력해주세요 > ");
		String deptTitle = sc.nextLine();

		employees = ec.findByDept(deptTitle);

		if (employees.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		} else {

			for (Employee e : employees) {

				System.out.println("==============================");
				System.out.println("사원 번호 : " + e.getEmpId());
				System.out.println("사원 이름 : " + e.getEmpName());
				System.out.println("사원 급여 : " + e.getSalary());
				System.out.println("사원 부서 : " + e.getDetpCode());
				System.out.println("사원 직급 : " + e.getJobCode());

			}

		}

	}

	public void findByJob() {
		List<Employee> employees = new ArrayList<Employee>();

		System.out.println("\n직급별 조회 서비스입니다");

		System.out.print("조회할 직급를 입력해주세요 > ");
		String jobName = sc.nextLine();

		employees = ec.findByJob(jobName);

		if (employees.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		} else {

			for (Employee e : employees) {

				System.out.println("==============================");
				System.out.println("사원 번호 : " + e.getEmpId());
				System.out.println("사원 이름 : " + e.getEmpName());
				System.out.println("사원 급여 : " + e.getSalary());
				System.out.println("사원 부서 : " + e.getDetpCode());
				System.out.println("사원 직급 : " + e.getJobCode());

			}

		}
	}

	public void findById() {

		System.out.println("\n사원 상세조회 서비스입니다.");
		System.out.print("조회하실 사원의 사번을 입력하세요 > ");
		String empId = sc.nextLine();

		Employee employee = ec.findById(empId);

		if (employee == null) {
			System.out.println("조회할 사원이 없습니다.");
		} else {
			System.out.println("==============================");
			System.out.println("사원 번호 : " + employee.getEmpId());
			System.out.println("사원 이름 : " + employee.getEmpName());
			System.out.println("사원 주민번호 : " + employee.getEmpNo());
			System.out.println("사원 이메일 : " + employee.getEmail());
			System.out.println("사원 휴대전화번호 : " + employee.getPhone());
			System.out.println("사원 부서코드 : " + employee.getDetpCode());
			System.out.println("사원 직급코드 : " + employee.getJobCode());
			System.out.println("사원 급여등급 : " + employee.getSalLevel());
			System.out.println("사원 급여 : " + employee.getSalary());
			System.out.println("사원 보너스 여부 : " + employee.getBonus());
			System.out.println("사원 관리자 사번 : " + employee.getManagerId());
			System.out.println("사원 입사일 : " + employee.getHireDate());
			System.out.println("사원 퇴사일 : " + employee.getEntDate());
			System.out.println("사원 퇴사여부 : " + employee.getEntyn());

		}

	}

	public void findByHighSalary() {

		List<Employee> employees = new ArrayList<Employee>();

		employees = ec.findByHighSalary();

		if (!employees.isEmpty()) {

			employees.stream().forEach(e -> {
				System.out.println("==============================");
				System.out.println("사원 번호 : " + e.getEmpId());
				System.out.println("사원 이름 : " + e.getEmpName());
				System.out.println("사원 주민번호 : " + e.getEmpNo());
				System.out.println("사원 이메일 : " + e.getEmail());
				System.out.println("사원 휴대전화번호 : " + e.getPhone());
				System.out.println("사원 부서코드 : " + e.getDetpCode());
				System.out.println("사원 직급코드 : " + e.getJobCode());
				System.out.println("사원 급여등급 : " + e.getSalLevel());
				System.out.println("사원 급여 : " + e.getSalary());
				System.out.println("사원 보너스 여부 : " + e.getBonus());
				System.out.println("사원 관리자 사번 : " + e.getManagerId());
				System.out.println("사원 입사일 : " + e.getHireDate());
				System.out.println("사원 퇴사일 : " + e.getEntDate());
				System.out.println("사원 퇴사여부 : " + e.getEntyn());
			});

		} else {
			System.out.println("조회결과가 없습니다.");
		}

	}

	public void findByLowSalary() {

		List<Employee> employees = new ArrayList<Employee>();

		employees = ec.findByLowSalary();

		if (!employees.isEmpty()) {

			employees.stream().forEach(e -> {
				System.out.println("==============================");
				System.out.println("사원 번호 : " + e.getEmpId());
				System.out.println("사원 이름 : " + e.getEmpName());
				System.out.println("사원 주민번호 : " + e.getEmpNo());
				System.out.println("사원 이메일 : " + e.getEmail());
				System.out.println("사원 휴대전화번호 : " + e.getPhone());
				System.out.println("사원 부서코드 : " + e.getDetpCode());
				System.out.println("사원 직급코드 : " + e.getJobCode());
				System.out.println("사원 급여등급 : " + e.getSalLevel());
				System.out.println("사원 급여 : " + e.getSalary());
				System.out.println("사원 보너스 여부 : " + e.getBonus());
				System.out.println("사원 관리자 사번 : " + e.getManagerId());
				System.out.println("사원 입사일 : " + e.getHireDate());
				System.out.println("사원 퇴사일 : " + e.getEntDate());
				System.out.println("사원 퇴사여부 : " + e.getEntyn());
			});

		} else {
			System.out.println("조회결과가 없습니다.");
		}

	}
	public void save() {
		
		
		
		System.out.println("사원 추가 서비스입니다.");
		
		System.out.print("사원 이름을 적어주세요 > ");
		String empName = sc.nextLine();
		System.out.print("사원 주민번호를 적어주세요 > ");
		String empNo = sc.nextLine();
		System.out.print("사원 이메일을 적어주세요 > ");
		String email = sc.nextLine();
		System.out.print("사원 전화번호를 적어주세요 > ");
		String phone = sc.nextLine();
		System.out.print("사원 부서코드를 적어주세요 > ");
		String deptCode = sc.nextLine();
		System.out.print("사원 직급코드를 적어주세요 > ");
		String jobCode = sc.nextLine();
		System.out.print("사원 급여등급을 적어주세요 > ");
		String salLevel = sc.nextLine();
		System.out.print("사원 급여를 적어주세요 > ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("사원 보너스를 적어주세요 > ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		System.out.print("사원 관리자사번을 적어주세요 > ");
		String managerId = sc.nextLine();
		
		int result = ec.save(empName,empNo,email,phone,deptCode,jobCode,salLevel,salary,bonus,managerId);
		
		if(result>0) {
			System.out.println("추가를 성공했습니다.");
		}else {
			System.out.println("추가에 실패했습니다.");
		}
	}
	
	public void update() {
		
		System.out.println("/n 사원 정보 수정 서비스입니다.");
		findAll();
		
		System.out.print("수정할 사원의 사번을 적어주세요 > ");
		String empId = sc.nextLine();
		System.out.print("수정할 부서명를 적어주세요 > ");
		String deptName = sc.nextLine();  
		System.out.print("수정할 직급명을 적어주세요 > ");
		String jobName = sc.nextLine();
		
		int result = ec.update(empId,deptName,jobName);
		
		if(result > 0) {
			System.out.println("변경이 완료되었습니다.");
		}
		else {
			System.out.println("변경에 실패했습니다.");
		}
		
		
	}
	
	public void delete() {
		
		System.out.println("사원의 퇴사여부 변경 서비스입니다");
		
		findAll();
		
		System.out.println("퇴사 여부를 바꿀 사원 번호를 입력하세요");
		String empId= sc.nextLine();
		
		int result = ec.delete(empId);
		
		if(result>0) {
			System.out.println("퇴사여부가 변경되었습니다.");
		}
		else {
			System.out.println("퇴사여부 변경에 실패했습니다.");
		}
	}
}
