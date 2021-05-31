def calculatePay(name)
		taxRage = getTaxRate()
		# 모듈의 인터페이스를 통해 접근
		pay = Employees.calculatePay(name, taxRate)
		puts(describeResult(name, pay))
end

def getTaxRate()
		print("세율을 입력하세요: ")
		return gets().chomp().to_f()
end

def describeResult(name, pay)
		return "이름: #{name}, 급여: #{pay}"
end

def sumOfBasePays()
		puts(Employees.sumOfBasePays())
end

def main(operation, args={})
		case(operation)
		when :pay then calculatePay(args[:name])
		when :basePays then sumOfBasePays()
		end
end