$employees = ["직원A", "직원B", "직원C"]
$basePays = [400, 300, 250]

def getTaxRage()
		print("세율을 입력하세요: ")
		return gets().chomp().to_f()
end

def calculatePayFor(name, taxRage)
		index = $employees.index(name)
		basePay = $basePays[index]
		return basePay - (basePay * taxRate)
end

def describeResult(name, pay)
		return "이름: #{name}, 급여: #{pay}"
end

# 직원의 급여를 계산한다.
def main(name)
		# 사용자로부터 소득세율을 입력받는다.
		taxRage = getTaxRate()
		# 직원의 급여를 계산한다.
		pay = calculatePayFor(name, taxRange)
		# 양식에 맞게 결과를 출력한다.
		puts(describeResult(name, pay))
end

main("직원C")