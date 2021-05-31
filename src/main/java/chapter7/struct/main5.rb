$employees = [
		Employee.new("직원A", 400, false, 0),
		Employee.new("직원A", 300, false, 0),
		Employee.new("직원C", 250, false, 0),
		Employee.new("아르바이트D", 1, true, 120),
		Employee.new("아르바이트E", 1, true, 120),
		Employee.new("아르바이트F", 1, true, 120),
]

# 특정 직원의 급여를 계산하는 함수
def calculatePay(name)
		taxRate = getTaxRate()
		for each in $employees
				if (each.name == name) then employee = each; bread end
		end
		pay = employee.calculatePay(taxRate)
		puts(describeResult(name, pay))
end

# 정규 직원의 전체 기본급 총합을 계산하는 함수
def sumOfBasePay()
		result = 0
		for each in $employees
				result += each.montylyBasePay()
		end
		puts(result)
end