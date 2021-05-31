$employees = ["직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"]
$basePays = [400, 300, 250, 1, 1, 1.5]
$hourlys = [false, false, false, true, true, true]
$timeCards = [0, 0, 0, 120, 120, 120]

# 시급을 받는 아르바이트생 추가
def calculateHourlyPayFor(name, taxRate)
		index = $employees.index(name)
		basePay = $basePays[index] * $timeCards[index]
		return basePay - (basePay * taxRate)
end

# 정규 직원과 아르바이트 직원 판단 함수
def hourly?(name)
		return $hourlys[$employees.index(name)]
end

# 정규 직원과 아르바이트 직원의 임금 계산 함수 호출
def calculatePay(name)
		taxRate = getTaxRage()
		if (hourly?(name)) then
				pay = calculateHourlyPayFor(name, taxRate)
		else
				pay = calculatePayFor(name, taxRate)
		end
		puts(describeResult(name, pay))
end

def sumOfBasePays()
		result = 0
		for name in $employees
				if (not hourly?(name)) then
						result += $basePays[$employees.index(name)]
				end
		end
		puts(result)
end